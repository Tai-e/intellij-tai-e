package pascal.taie.intellij.tir.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import pascal.taie.intellij.tir.syntax.TirLexerAdapter
import pascal.taie.intellij.tir.syntax.TirTypes


class TirSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        val KEY = createTextAttributesKey("TIR_KEY", DefaultLanguageHighlighterColors.KEYWORD)

        val FIELD = createTextAttributesKey("TIR_FIELD", DefaultLanguageHighlighterColors.INSTANCE_FIELD)

        val NUMBER = createTextAttributesKey("TIR_NUMBER", DefaultLanguageHighlighterColors.NUMBER)

        val LINE_NUMBER =
            createTextAttributesKey("TIR_LINE_NUMBER", DefaultLanguageHighlighterColors.INLAY_TEXT_WITHOUT_BACKGROUND)

        private val KEY_KEYS = arrayOf(KEY)

        private val FIELD_KEYS = arrayOf(FIELD)

        private val INVOKE_KEYS =
            arrayOf(createTextAttributesKey("TIR_INVOKE", DefaultLanguageHighlighterColors.FUNCTION_CALL))

        private val STRING_KEYS =
            arrayOf(createTextAttributesKey("TIR_STRING", DefaultLanguageHighlighterColors.STRING))

        private val NUMBER_KEYS = arrayOf(NUMBER)

        private val LINE_NUMBER_KEYS = arrayOf(LINE_NUMBER)

        private val BAD_KEYS = arrayOf(createTextAttributesKey("TIR_BAD", HighlighterColors.BAD_CHARACTER))

        private val EMPTY_KEYS = arrayOfNulls<TextAttributesKey>(0)
    }

    override fun getHighlightingLexer(): Lexer {
        return TirLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<out TextAttributesKey?> {
        return when (tokenType) {
            TirTypes.CLASS,
            TirTypes.INTERFACE,
            TirTypes.MODIFIER,
            TirTypes.EXTENDS,
            TirTypes.IMPLEMENTS,
            TirTypes.RETURN,
            TirTypes.TRY,
            TirTypes.THROW,
            TirTypes.CATCH,
            TirTypes.NEW,
            TirTypes.NEW_ARRAY,
            TirTypes.NULL_TYPE,
            TirTypes.INSTANCEOF,
            TirTypes.IF,
            TirTypes.GOTO -> {
                KEY_KEYS
            }

            TirTypes.INVOKE_KEY -> {
                INVOKE_KEYS
            }

            TirTypes.INTEGER, TirTypes.FLOAT -> {
                NUMBER_KEYS
            }

            TirTypes.STRING_LITERAL -> {
                STRING_KEYS
            }

            TirTypes.LINE_NUMBER -> {
                LINE_NUMBER_KEYS
            }

            else -> EMPTY_KEYS
        }
    }
}
