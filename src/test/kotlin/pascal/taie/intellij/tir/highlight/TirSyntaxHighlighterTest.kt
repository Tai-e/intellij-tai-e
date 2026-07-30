package pascal.taie.intellij.tir.highlight

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import pascal.taie.intellij.tir.syntax.TirLexerAdapter
import pascal.taie.intellij.tir.syntax.TirTypes

internal class TirSyntaxHighlighterTest {

    private val highlighter = TirSyntaxHighlighter()

    @Test
    fun `keywords map to KEY`() {
        val keywords = listOf(
            TirTypes.CLASS, TirTypes.INTERFACE,
            TirTypes.PUBLIC, TirTypes.PROTECTED, TirTypes.PRIVATE, TirTypes.ABSTRACT, TirTypes.STATIC,
            TirTypes.FINAL, TirTypes.SEALED, TirTypes.NON_SEALED, TirTypes.STRICTFP, TirTypes.TRANSIENT,
            TirTypes.VOLATILE, TirTypes.SYNCHRONIZED, TirTypes.NATIVE, TirTypes.SYNTHETIC, TirTypes.ENUM,
            TirTypes.ANNOTATION, TirTypes.EXTENDS, TirTypes.IMPLEMENTS, TirTypes.RETURN, TirTypes.TRY,
            TirTypes.THROW, TirTypes.CATCH, TirTypes.CATCH_AT, TirTypes.LOOKUP_SWITCH, TirTypes.DEFAULT,
            TirTypes.NEW, TirTypes.NEW_ARRAY, TirTypes.NEW_MULTI_ARRAY, TirTypes.NULL_TYPE,
            TirTypes.INSTANCEOF, TirTypes.IF, TirTypes.GOTO,
        )
        for (keyword in keywords) {
            assertEquals(listOf(TirSyntaxHighlighter.KEY), highlighter.getTokenHighlights(keyword).toList())
        }
    }

    @Test
    fun `annotation def name maps to ANNOTATION`() {
        assertEquals(
            listOf(TirSyntaxHighlighter.ANNOTATION),
            highlighter.getTokenHighlights(TirTypes.ANNOTATION_DEF_NAME).toList()
        )
    }

    @Test
    fun `invoke tokens map to INVOKE_KEY`() {
        val invokes = listOf(
            TirTypes.INVOKE_VIRTUAL, TirTypes.INVOKE_SPECIAL, TirTypes.INVOKE_INTERFACE,
            TirTypes.INVOKE_STATIC, TirTypes.INVOKE_DYNAMIC
        )
        for (invoke in invokes) {
            assertEquals(listOf(TirSyntaxHighlighter.INVOKE_KEY), highlighter.getTokenHighlights(invoke).toList())
        }
    }

    @Test
    fun `numbers map to NUMBER`() {
        assertEquals(listOf(TirSyntaxHighlighter.NUMBER), highlighter.getTokenHighlights(TirTypes.INTEGER).toList())
        assertEquals(listOf(TirSyntaxHighlighter.NUMBER), highlighter.getTokenHighlights(TirTypes.FLOAT).toList())
    }

    @Test
    fun `strings map to STRING`() {
        assertEquals(
            listOf(TirSyntaxHighlighter.STRING),
            highlighter.getTokenHighlights(TirTypes.STRING_LITERAL).toList()
        )
        assertEquals(listOf(TirSyntaxHighlighter.STRING), highlighter.getTokenHighlights(TirTypes.STRING).toList())
    }

    @Test
    fun `line number maps to LINE_NUMBER`() {
        assertEquals(
            listOf(TirSyntaxHighlighter.LINE_NUMBER),
            highlighter.getTokenHighlights(TirTypes.LINE_NUMBER).toList()
        )
    }

    @Test
    fun `unmapped token maps to empty`() {
        assertTrue(highlighter.getTokenHighlights(TirTypes.COMMENT).isEmpty())
    }

    @Test
    fun `highlighting lexer is tir lexer`() {
        assertTrue(highlighter.highlightingLexer is TirLexerAdapter)
    }
}
