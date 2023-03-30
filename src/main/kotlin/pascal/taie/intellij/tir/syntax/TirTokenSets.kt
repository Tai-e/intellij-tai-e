package pascal.taie.intellij.tir.syntax

import com.intellij.psi.tree.TokenSet


interface TirTokenSets {
    companion object {
        val IDENTIFIERS = TokenSet.create(TirTypes.KEY)

        val COMMENTS = TokenSet.create(TirTypes.COMMENT)
    }
}
