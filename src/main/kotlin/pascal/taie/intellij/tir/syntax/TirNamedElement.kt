package pascal.taie.intellij.tir.syntax

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface TirNamedElement : PsiNameIdentifierOwner

abstract class TirNamedElementMixin(node: ASTNode) : ASTWrapperPsiElement(node), TirNamedElement {
    override fun setName(name: String): PsiElement {
        nameIdentifier?.replace(this)
        return this
    }

    override fun getNameIdentifier(): PsiElement? {
        return this
    }
}