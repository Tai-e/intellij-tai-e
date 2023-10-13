package pascal.taie.intellij.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TirPatternFilterTest {

    @Test
    fun getOurPatternToDetectTir() {
        // class
        assertEquals(
            "org.example.ClassName",
            TirPatternFilter.applyPatternReBuild("<org.example.ClassName>")
        )
        // constructor
        assertEquals(
            "org.example.ClassName",
            TirPatternFilter.applyPatternReBuild("<org.example.ClassName: void <init>()>")
        )
        // clinit
        assertEquals(
            "org.example.ClassName",
            TirPatternFilter.applyPatternReBuild("<org.example.ClassName: void <clinit>()>")
        )
        // method
        assertEquals(
            "org.example.ClassName.methodName",
            TirPatternFilter.applyPatternReBuild("<org.example.ClassName: void methodName(org.example.ClassName2)>")
        )
        // method with array
        assertEquals(
            "org.example.ClassName.methodName",
            TirPatternFilter.applyPatternReBuild("<org.example.ClassName: void methodName(org.example.ClassName2[])>")
        )
        // field
        assertEquals(
            "org.example.ClassName.ClassName",
            TirPatternFilter.applyPatternReBuild("<org.example.ClassName: java.util.List ClassName>")
        )
        // edge
        assertEquals(
            "org.example.ClassName3.methodName3",
            TirPatternFilter.applyPatternReBuild(
                "<org.example.ClassName3: void methodName3(org.example.ClassName4)>"
                        + "/org.example.ClassName4.methodName4/0\t"
                        + "<org.example.ClassName4: void methodName4()>"
            )
        )
        // ir with context
        // []:<java.lang.management.ManagementFactory: java.lang.management.PlatformManagedObject getPlatformMXBean(java.lang.Class)>[21@L674] $r5 = invokevirtual r0.getName()
    }
}