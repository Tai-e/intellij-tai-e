package pascal.taie.intellij.tir.syntax

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType


class TirSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        private val KEY = createTextAttributesKey("TIR_KEY", DefaultLanguageHighlighterColors.KEYWORD)

        private val FIELD = createTextAttributesKey("TIR_FIELD", DefaultLanguageHighlighterColors.INSTANCE_FIELD)

        private val LINE_NUMBER = createTextAttributesKey("TIR_LINE_NUMBER", DefaultLanguageHighlighterColors.INLAY_TEXT_WITHOUT_BACKGROUND);

        private val KEY_KEYS = arrayOf(KEY)

        private val FIELD_KEYS = arrayOf(FIELD)

        private val LINE_NUMBER_KEYS = arrayOf(LINE_NUMBER)

        private val EMPTY_KEYS = arrayOfNulls<TextAttributesKey>(0)
    }

    override fun getHighlightingLexer(): Lexer {
        return TirLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<out TextAttributesKey?> {
        return when (tokenType) {
            TirTypes.CLASS, TirTypes.MODIFIER, TirTypes.EXTENDS, TirTypes.IMPLEMENTS -> {
                KEY_KEYS
            }
            TirTypes.FIELD_IDENTIFIER -> {
                FIELD_KEYS;
            }
            TirTypes.LINE_NUMBER -> {
                LINE_NUMBER_KEYS
            }
            else -> EMPTY_KEYS
        }
    }
}
