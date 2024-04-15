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

        val TYPE = createTextAttributesKey("TIR_TYPE", DefaultLanguageHighlighterColors.CLASS_NAME)

        val INVOKE_KEY = createTextAttributesKey("TIR_INVOKE_KEY", DefaultLanguageHighlighterColors.FUNCTION_CALL)

        val STATIC_METHOD = createTextAttributesKey("TIR_STATIC_METHOD", DefaultLanguageHighlighterColors.STATIC_METHOD)

        val INSTANCE_METHOD =
            createTextAttributesKey("TIR_INSTANCE_METHOD", DefaultLanguageHighlighterColors.INSTANCE_METHOD)

        val STATIC_FIELD = createTextAttributesKey("TIR_STATIC_FIELD", DefaultLanguageHighlighterColors.STATIC_FIELD)

        val INSTANCE_FIELD =
            createTextAttributesKey("TIR_INSTANCE_FIELD", DefaultLanguageHighlighterColors.INSTANCE_FIELD)

        val PARAMETER = createTextAttributesKey("TIR_PARAMETER", DefaultLanguageHighlighterColors.PARAMETER)

        val NUMBER = createTextAttributesKey("TIR_NUMBER", DefaultLanguageHighlighterColors.NUMBER)

        val STRING = createTextAttributesKey("TIR_STRING", DefaultLanguageHighlighterColors.STRING)

        val LINE_NUMBER =
            createTextAttributesKey("TIR_LINE_NUMBER", DefaultLanguageHighlighterColors.INLAY_TEXT_WITHOUT_BACKGROUND)

        private val KEY_KEYS = arrayOf(KEY)

        private val TYPE_KEYS = arrayOf(TYPE)

        private val FIELD_KEYS = arrayOf(STATIC_FIELD, INSTANCE_FIELD)

        private val METHOD_KEYS = arrayOf(STATIC_METHOD, INSTANCE_METHOD)

        private val PARAMETER_KEYS = arrayOf(PARAMETER)

        private val INVOKE_KEYS = arrayOf(INVOKE_KEY)

        private val STRING_KEYS = arrayOf(STRING)

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
            TirTypes.MODIFIER_CLASS,
            TirTypes.MODIFIER_FIELD,
            TirTypes.MODIFIER_METHOD,
            TirTypes.EXTENDS,
            TirTypes.IMPLEMENTS,
            TirTypes.RETURN,
            TirTypes.TRY,
            TirTypes.THROW,
            TirTypes.CATCH,
            TirTypes.AT,
            TirTypes.LOOKUP_SWITCH,
            TirTypes.DEFAULT,
            TirTypes.NEW,
            TirTypes.NEW_ARRAY,
            TirTypes.NEW_MULTI_ARRAY,
            TirTypes.NULL_TYPE,
            TirTypes.INSTANCEOF,
            TirTypes.IF,
            TirTypes.GOTO -> {
                KEY_KEYS
            }

            TirTypes.INVOKE_VIRTUAL,
            TirTypes.INVOKE_SPECIAL,
            TirTypes.INVOKE_INTERFACE,
            TirTypes.INVOKE_STATIC,
            TirTypes.INVOKE_DYNAMIC -> {
                INVOKE_KEYS
            }

            TirTypes.INTEGER, TirTypes.FLOAT -> {
                NUMBER_KEYS
            }

            TirTypes.STRING_LITERAL,
            TirTypes.STRING -> {
                STRING_KEYS
            }

            TirTypes.LINE_NUMBER -> {
                LINE_NUMBER_KEYS
            }

            else -> EMPTY_KEYS
        }
    }
}
