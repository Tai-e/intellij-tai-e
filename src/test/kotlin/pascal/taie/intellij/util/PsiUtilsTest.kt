package pascal.taie.intellij.util

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiJavaFile
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class PsiUtilsTest : BasePlatformTestCase() {

    private fun classAt(index: Int, text: String): PsiClass =
        (myFixture.configureByText("A.java", text.trimIndent()) as PsiJavaFile).classes[index]

    fun testClassName() {
        val clz = classAt(0, """
            package com.example;
            public class A { }
        """)
        assertEquals("<com.example.A>", PsiUtils.toTirClassName(clz))
    }

    fun testMethodSignature() {
        val clz = classAt(0, """
            package com.example;
            public class A {
                public int foo(A a, int[] arr) { return 0; }
            }
        """)
        assertEquals("<com.example.A: int foo(com.example.A,int[])>", PsiUtils.toTirMethodSignature(clz.methods[0]))
    }

    fun testConstructorSignature() {
        val clz = classAt(0, """
            package com.example;
            public class A {
                public A() { }
            }
        """)
        assertEquals("<com.example.A: void <init>()>", PsiUtils.toTirMethodSignature(clz.methods[0]))
    }

    fun testVoidMethodSignature() {
        val clz = classAt(0, """
            package com.example;
            public class A {
                void bar() { }
            }
        """)
        assertEquals("<com.example.A: void bar()>", PsiUtils.toTirMethodSignature(clz.methods[0]))
    }

    fun testClassInitializerSignature() {
        val clz = classAt(0, """
            package com.example;
            public class A {
                static { }
            }
        """)
        assertEquals("<com.example.A: void <clinit>()>", PsiUtils.toTirMethodSignature(clz.initializers[0]))
    }

    fun testFieldSignature() {
        val clz = classAt(0, """
            package com.example;
            public class A {
                public int[] values;
            }
        """)
        assertEquals("<com.example.A: int[] values>", PsiUtils.toTirFieldSignature(clz.fields[0]))
    }

    fun testFieldSignatureErasesGenericType() {
        val clz = classAt(0, """
            package com.example;
            public class A {
                public Box<String> box;
            }
            class Box<T> { }
        """)
        assertEquals("<com.example.A: com.example.Box box>", PsiUtils.toTirFieldSignature(clz.fields[0]))
    }

    fun testTypeParameterFieldMapsToObject() {
        val clz = classAt(0, """
            package com.example;
            public class A<T> {
                public T value;
            }
        """)
        assertEquals("<com.example.A: java.lang.Object value>", PsiUtils.toTirFieldSignature(clz.fields[0]))
    }
}
