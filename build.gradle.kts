import org.gradle.process.CommandLineArgumentProvider
import org.jetbrains.changelog.Changelog
import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.intellij.platform.gradle.TestFrameworkType

fun properties(key: String) = providers.gradleProperty(key)
fun environment(key: String) = providers.environmentVariable(key)

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.intellij.platform")
    id("org.jetbrains.changelog")
    alias(libs.plugins.qodana)
    alias(libs.plugins.kover)
    alias(libs.plugins.intellijGrammarKit)
}

group = properties("group").get()
version = properties("version").get()

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity(properties("platformVersion").get())
        bundledPlugin("com.intellij.java")
        testFramework(TestFrameworkType.Platform)
    }

    implementation(libs.annotations)
    testImplementation("junit:junit:4.13.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.1.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:6.1.2")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

kotlin {
    jvmToolchain(21)
}

grammarKit {
    jflexRelease.set("1.9.2")
    grammarKitRelease.set("2023.3.4")
}

changelog {
    groups.empty()
    repositoryUrl = properties("pluginRepositoryUrl")
}

kover {
    reports {
        total {
            xml {
                onCheck = true
            }
        }
    }
}

intellijPlatform {
    buildSearchableOptions = false

    pluginConfiguration {
        name = properties("pluginName")

        ideaVersion {
            sinceBuild = properties("pluginSinceBuild")
            untilBuild = properties("pluginUntilBuild")
        }

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest.
        description = providers.fileContents(layout.projectDirectory.file("README.md")).asText.map {
            val start = "<!-- Plugin description -->"
            val end = "<!-- Plugin description end -->"

            with(it.lines()) {
                if (!containsAll(listOf(start, end))) {
                    throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                }
                subList(indexOf(start) + 1, indexOf(end)).joinToString("\n").let(::markdownToHTML)
            }
        }

        val changelog = project.changelog
        changeNotes = properties("version").map { pluginVersion ->
            with(changelog) {
                renderItem(
                    (getOrNull(pluginVersion) ?: getUnreleased())
                        .withHeader(false)
                        .withEmptySections(false),
                    Changelog.OutputType.HTML,
                )
            }
        }
    }

    signing {
        certificateChain = environment("CERTIFICATE_CHAIN")
        privateKey = environment("PRIVATE_KEY")
        password = environment("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = environment("PUBLISH_TOKEN")
        channels = properties("version").map {
            listOf(it.substringAfter('-', "").substringBefore('.').ifEmpty { "default" })
        }
    }

    pluginVerification {
        freeArgs = listOf("-mute", "TemplateWordInPluginId")

        ides {
            current()
            recommended()
        }
    }
}

val runIdeForUiTests by intellijPlatformTesting.runIde.registering {
    task {
        jvmArgumentProviders += CommandLineArgumentProvider {
            listOf(
                "-Drobot-server.port=8082",
                "-Dide.mac.message.dialogs.as.sheets=false",
                "-Djb.privacy.policy.text=<!--999.999-->",
                "-Djb.consents.confirmation.enabled=false",
            )
        }
    }

    plugins {
        robotServerPlugin()
    }
}

sourceSets["main"].java.srcDirs("src/main/gen")

tasks.register<Delete>("cleanTirParser") {
    delete("src/main/gen/pascal/taie/intellij/tir/syntax")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks {
    compileKotlin {
        dependsOn.add(generateParser)
    }

    generateLexer {
        dependsOn.add("cleanTirParser")
        sourceFile.set(File("src/main/syntax/tir.flex"))
        targetOutputDir.set(layout.projectDirectory.dir("src/main/gen/pascal/taie/intellij/tir/syntax/"))
    }

    generateParser {
        dependsOn.add(generateLexer)
        sourceFile.set(File("src/main/syntax/tir.bnf"))
        targetRootOutputDir.set(layout.projectDirectory.dir("src/main/gen/"))
        pathToParser.set("pascal/taie/intellij/tir/syntax/TirParser.java")
        pathToPsiRoot.set("pascal/taie/intellij/tir/syntax/psi")
    }

    wrapper {
        gradleVersion = properties("gradleVersion").get()
    }
}
