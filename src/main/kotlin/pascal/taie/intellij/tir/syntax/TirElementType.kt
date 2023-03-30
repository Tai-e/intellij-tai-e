package pascal.taie.intellij.tir.syntax

import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls
import pascal.taie.intellij.tir.TirLanguage

class TirElementType(debugName: @NonNls String) : IElementType(debugName, TirLanguage.INSTANCE) {
    override fun toString(): String {
        return "TirElementType." + super.toString()
    }
}
