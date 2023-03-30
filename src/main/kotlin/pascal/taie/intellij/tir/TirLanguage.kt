package pascal.taie.intellij.tir

import com.intellij.lang.Language

class TirLanguage : Language(ID) {
    companion object {
        const val ID = "tir"

        val INSTANCE = TirLanguage()
    }
}
