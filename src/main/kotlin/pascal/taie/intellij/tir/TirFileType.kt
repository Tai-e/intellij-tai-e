package pascal.taie.intellij.tir

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class TirFileType : LanguageFileType(TirLanguage.INSTANCE) {
    companion object {
        val INSTANCE = TirFileType();
    }

    override fun getName(): String {
        return "Tai-e IR File"
    }

    override fun getDescription(): String {
        return "Tai-e IR Language File"
    }

    override fun getDefaultExtension(): String {
        return "tir"
    }

    override fun getIcon(): Icon {
        return TirIcons.PASCAL
    }
}
