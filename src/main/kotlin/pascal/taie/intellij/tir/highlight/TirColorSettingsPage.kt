package pascal.taie.intellij.tir.highlight

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import pascal.taie.intellij.tir.TirIcons
import javax.swing.Icon

class TirColorSettingsPage : ColorSettingsPage {
    companion object {
        private val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Key", TirSyntaxHighlighter.KEY),
            AttributesDescriptor("Field", TirSyntaxHighlighter.FIELD),
            AttributesDescriptor("Line number", TirSyntaxHighlighter.LINE_NUMBER),
            AttributesDescriptor("Number", TirSyntaxHighlighter.NUMBER)
        )
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Tai-e IR"
    }

    override fun getIcon(): Icon {
        return TirIcons.PASCAL
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return TirSyntaxHighlighter()
    }

    override fun getDemoText() = """
        class Alias extends java.lang.Object {

            java.lang.Object f;

            public static void main(java.lang.String[] args) {
                Alias temp${'$'}0, a, temp${'$'}1, b;
                java.lang.Object temp${'$'}2, temp${'$'}3;
                [0@L5] temp${'$'}0 = new Alias;
                [1@L5] invokespecial temp${'$'}0.<Alias: void <init>()>();
                [2@L5] a = temp${'$'}0;
                [3@L6] temp${'$'}1 = new Alias;
                [4@L6] invokespecial temp${'$'}1.<Alias: void <init>()>();
                [5@L6] b = temp${'$'}1;
                [6@L7] temp${'$'}2 = new java.lang.Object;
                [7@L7] invokespecial temp${'$'}2.<java.lang.Object: void <init>()>();
                [8@L7] a.<Alias: java.lang.Object f> = temp${'$'}2;
                [9@L8] temp${'$'}3 = new java.lang.Object;
                [10@L8] invokespecial temp${'$'}3.<java.lang.Object: void <init>()>();
                [11@L8] b.<Alias: java.lang.Object f> = temp${'$'}3;
                [12@L9] invokestatic <Alias: void func(Alias)>(a);
                [13@L10] invokestatic <Alias: void func(Alias)>(b);
                [14@L10] return;
            }

            static void func(Alias x) {
                java.lang.Object c, temp${'$'}0, d;
                [0@L14] c = x.<Alias: java.lang.Object f>;
                [1@L15] temp${'$'}0 = new java.lang.Object;
                [2@L15] invokespecial temp${'$'}0.<java.lang.Object: void <init>()>();
                [3@L15] d = temp${'$'}0;
                [4@L16] x.<Alias: java.lang.Object f> = d;
                [5@L16] return;
            }

            void <init>() {
                [0@L1] invokespecial %this.<java.lang.Object: void <init>()>();
                [1@L1] return;
            }

        }
    """.trimIndent()

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
        return null
    }
}