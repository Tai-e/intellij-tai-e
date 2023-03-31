package pascal.taie.intellij

import com.intellij.testFramework.ParsingTestCase
import pascal.taie.intellij.tir.TirParserDefinition

class TirParseTest : ParsingTestCase("", "tir", TirParserDefinition()) {

    fun testAnimal() {
        doTest(true)
    }

    /**
     * @return path to test data file directory relative to root of this module.
     */
    override fun getTestDataPath() = "src/test/testData"

    override fun skipSpaces() = true

    override fun includeRanges() = true
}

