package pascal.taie.intellij.languages

import com.intellij.lang.Language

class TirLanguage : Language(ID) {
    companion object {
        const val ID = "tir"

        val INSTANCE = TirLanguage()
    }
}
