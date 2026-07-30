package pascal.taie.intellij.tir.editing

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class TirFoldingBuilderTest : BasePlatformTestCase() {

    override fun getTestDataPath() = "src/test/testData"

    fun testFolding() = myFixture.testFolding("$testDataPath/Folding.tir")
}
