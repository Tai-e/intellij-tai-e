package pascal.taie.intellij.model

import java.util.regex.Pattern


class Edge {
    companion object {
        @JvmStatic
        val pattern = Pattern.compile("""<(.+): (.+) (.+)\((.*)\)>/(.+)/\d+\t<(.+): (.+) (.+)\((.*)\)>""")
    }
}
