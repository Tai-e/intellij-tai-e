package pascal.taie.intellij.model


class JMethod(
    val declaringClass: JClass,
    val returnType: JClass,
    val name: String,
    val parameters: List<JClass>,
) {

    companion object {
        @JvmStatic
        val pattern = java.util.regex.Pattern.compile("""<(.+): (.+) (.+)\((.*)\)>""")

        @JvmStatic
        fun create(rawString: String): JMethod? {
            val matcher = pattern.matcher(rawString)
            if (matcher.find()) {
                val clz = JClass(matcher.group(1))
                val returnType = JClass(matcher.group(2))
                val name = matcher.group(3)
                val params = matcher.group(4).split(",").map { JClass(it.trim()) }
                return JMethod(clz, returnType, name, params)
            }
            return null
        }
    }
}
