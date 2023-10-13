package pascal.taie.intellij

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassInitializer
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import com.intellij.psi.util.PsiTreeUtil
import pascal.taie.intellij.util.ClipboardUtils
import pascal.taie.intellij.util.PsiUtils


class TirCopyReferenceAction: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        var psiElement = e.getData(LangDataKeys.PSI_ELEMENT)
        if (psiElement == null) {
            val editor = e.getData(LangDataKeys.EDITOR) ?: return
            val psiFile = e.getData(LangDataKeys.PSI_FILE) ?: return
            psiElement = psiFile.findElementAt(editor.caretModel.offset)
        }
        psiElement?.run(::copyReference)
    }

    private fun copyReference(psiElement: PsiElement) {
        // copy class initializer
        PsiTreeUtil.getParentOfType(psiElement, PsiClassInitializer::class.java, false)
            ?.run(PsiUtils::toTirMethodSignature)
            ?.run(ClipboardUtils::setContent)
            ?.run { return@copyReference }

        // copy method signature
        PsiTreeUtil.getParentOfType(psiElement, PsiMethod::class.java, false)
            ?.run(PsiUtils::toTirMethodSignature)
            ?.run(ClipboardUtils::setContent)
            ?.run { return@copyReference }

        // copy field signature
        PsiTreeUtil.getParentOfType(psiElement, PsiField::class.java, false)
            ?.run(PsiUtils::toTirFieldSignature)
            ?.run(ClipboardUtils::setContent)
            ?.run { return@copyReference }

        // copy class name
        PsiTreeUtil.getParentOfType(psiElement, PsiClass::class.java, false)
            ?.run(PsiUtils::toTirClassName)
            ?.run(ClipboardUtils::setContent)
            ?.run { return@copyReference }
    }
}
