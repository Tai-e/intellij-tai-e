package pascal.taie.intellij.tir.syntax

import com.intellij.lexer.FlexAdapter

class TirLexerAdapter : FlexAdapter(TirLexer(null))
