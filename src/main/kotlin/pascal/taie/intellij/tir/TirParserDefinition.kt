package pascal.taie.intellij.tir

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import pascal.taie.intellij.tir.syntax.TirLexerAdapter
import pascal.taie.intellij.tir.syntax.TirParser
import pascal.taie.intellij.tir.syntax.TirTokenSets
import pascal.taie.intellij.tir.syntax.TirTypes

class TirParserDefinition : ParserDefinition {
    companion object {
        val FILE = IFileElementType(TirLanguage.INSTANCE)
    }

    override fun createLexer(project: Project?): Lexer {
        return TirLexerAdapter()
    }

    override fun createParser(project: Project?): PsiParser {
        return TirParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        return TirTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return TirTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return TirFile(viewProvider)
    }
}
