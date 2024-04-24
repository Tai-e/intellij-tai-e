package pascal.taie.intellij

import com.intellij.testFramework.ParsingTestCase
import pascal.taie.intellij.tir.TirParserDefinition

class TirParseTest : ParsingTestCase("", "tir", TirParserDefinition()) {
    /**
     * @return path to test data file directory relative to root of this module.
     */
    override fun getTestDataPath() = "src/test/testData"

    override fun skipSpaces() = true

    override fun includeRanges() = true

    fun testAllInOne() = doTest(true)

    fun testJava9StringConcatenation() = doTest(true)

    fun testListToArray() = doTest(true)

    fun testMahjong() = doTest(true)

    fun testAnnotatedJava() = doTest(true)
}
