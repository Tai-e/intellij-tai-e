package pascal.taie.intellij.tir.editing

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.SyntaxTraverser
import pascal.taie.intellij.tir.syntax.psi.TirClassBody
import pascal.taie.intellij.tir.syntax.psi.TirMethodBody

class TirFoldingBuilder : FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(
        root: PsiElement, document: Document, quick: Boolean
    ) = SyntaxTraverser
        .psiTraverser(root)
        .filter { it is TirMethodBody || it is TirClassBody }
        .map { TirFoldingDescriptor(it, "{…}") }
        .toList().toTypedArray()

    override fun getPlaceholderText(node: ASTNode) = "…"

    override fun isCollapsedByDefault(node: ASTNode) = false

    class TirFoldingDescriptor(element: PsiElement, private val holder: String) :
        FoldingDescriptor(element.node, element.textRange) {
        override fun getPlaceholderText() = holder
    }
}