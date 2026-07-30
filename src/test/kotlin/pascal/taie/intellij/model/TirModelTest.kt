package pascal.taie.intellij.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class TirModelTest {

    @Test
    fun `jmethod create parses full signature`() {
        val method = JMethod.create("<com.example.Foo: int bar(java.lang.String,int[])>")!!
        assertEquals("com.example.Foo", method.declaringClass.name)
        assertEquals("int", method.returnType.name)
        assertEquals("bar", method.name)
        assertEquals(listOf("java.lang.String", "int[]"), method.parameters.map { it.name })
    }

    @Test
    fun `jmethod create parses no-arg signature`() {
        val method = JMethod.create("<com.example.Foo: void <init>()>")!!
        assertEquals("<init>", method.name)
        // Pins current behavior: empty parameter text splits into a single empty-named parameter.
        assertEquals(listOf(""), method.parameters.map { it.name })
    }

    @Test
    fun `jmethod create returns null for invalid input`() {
        assertNull(JMethod.create("not a signature"))
        assertNull(JMethod.create(""))
    }

    @Test
    fun `edge pattern matches call edge`() {
        val matcher = Edge.pattern.matcher(
            "<org.example.ClassName3: void methodName3(org.example.ClassName4)>" +
                    "/org.example.ClassName4.methodName4/0\t" +
                    "<org.example.ClassName4: void methodName4()>"
        )
        assertTrue(matcher.find())
        assertEquals("org.example.ClassName3", matcher.group(1))
        assertEquals("void", matcher.group(2))
        assertEquals("methodName3", matcher.group(3))
        assertEquals("org.example.ClassName4", matcher.group(4))
        assertEquals("org.example.ClassName4.methodName4", matcher.group(5))
        assertEquals("org.example.ClassName4", matcher.group(6))
        assertEquals("void", matcher.group(7))
        assertEquals("methodName4", matcher.group(8))
        assertEquals("", matcher.group(9))
    }

    @Test
    fun `edge pattern rejects plain signature`() {
        assertFalse(Edge.pattern.matcher("<org.example.ClassName3: void methodName3()>").find())
    }
}
