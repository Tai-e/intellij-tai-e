package pascal.taie.intellij.util

object TirPatternFilter {

    private val ourPatternToDetectTir = arrayOf(
        // class
        Regex("^<([^:]+)>$"),
        // field
        Regex("^<([^:]+): (\\S+) ([^()]+)>$"),
        // method
        Regex("^<([^:]+): (\\S+) ([^()]+)\\([^()]*\\)>"),
    )

    fun applyPatternReBuild(text: String): String {
        // TODO: handle the callee of edge
        val trimText = text.trim()
        for (regex in ourPatternToDetectTir) {
            val matchResult = regex.find(trimText)
            if (matchResult != null) {
                val clz = matchResult.groupValues[1]
                if (matchResult.groupValues.size > 2) {
                    val name = matchResult.groupValues[3]
                    if ("<init>" == name || "<clinit>" == name) {
                        return clz
                    }
                    return "$clz.$name"
                }
                return clz
            }
        }
        return trimText
    }
}
