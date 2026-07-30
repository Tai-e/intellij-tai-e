package pascal.taie.intellij.tir.syntax

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.util.TextRange
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import pascal.taie.intellij.tir.highlight.TirSyntaxHighlighter

class TirAnnotatorTest : BasePlatformTestCase() {

    private fun highlightKeys(text: String): Map<String, TextAttributesKey> {
        myFixture.configureByText("test.tir", text.trimIndent())
        val document = myFixture.editor.document
        return myFixture.doHighlighting(HighlightSeverity.INFORMATION)
            .filter { it.forcedTextAttributesKey != null }
            .associate {
                document.getText(TextRange(it.startOffset, it.endOffset)) to it.forcedTextAttributesKey
            }
    }

    fun testSemanticHighlighting() {
        val keys = highlightKeys("""
            @Year(2022)
            public class com.example.Foo extends java.lang.Object {
                private int value;
                void bar() {
                    [0@L1] invokespecial %this.<java.lang.Object: void <init>()>();
                    [1@L1] return;
                }
            }
        """)
        assertEquals(TirSyntaxHighlighter.ANNOTATION, keys["@Year"])
        assertEquals(TirSyntaxHighlighter.TYPE, keys["int"])
        assertEquals(TirSyntaxHighlighter.INSTANCE_FIELD, keys["value"])
        assertEquals(TirSyntaxHighlighter.INSTANCE_METHOD, keys["bar"])
        assertEquals(TirSyntaxHighlighter.PARAMETER, keys["%this"])
        assertEquals(TirSyntaxHighlighter.INSTANCE_METHOD, keys["<java.lang.Object: void <init>()>"])
    }

    fun testInstanceFieldAccessHighlighting() {
        val keys = highlightKeys("""
            public class com.example.Foo extends java.lang.Object {
                private int value;
                void bar() {
                    com.example.Foo r;
                    int t;
                    [0@L1] r = %this;
                    [1@L2] t = r.<com.example.Foo: int value>;
                    [2@L2] return;
                }
            }
        """)
        // field signature in an instance field access
        assertEquals(TirSyntaxHighlighter.INSTANCE_FIELD, keys["<com.example.Foo: int value>"])
        // local variable declarations are annotated as types
        assertEquals(TirSyntaxHighlighter.TYPE, keys["com.example.Foo"])
    }
}
