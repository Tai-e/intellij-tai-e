package pascal.taie.intellij.tir

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class TirFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, TirLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return TirFileType.INSTANCE
    }

    override fun toString(): String {
        return "Tir File: " + super.toString();
    }
}
