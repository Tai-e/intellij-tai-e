// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import pascal.taie.intellij.tir.syntax.TirNamedElementMixin;
import pascal.taie.intellij.tir.syntax.psi.TirIdentifierVariable;
import pascal.taie.intellij.tir.syntax.psi.TirVisitor;

public class TirIdentifierVariableImpl extends TirNamedElementMixin implements TirIdentifierVariable {

    public TirIdentifierVariableImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull TirVisitor visitor) {
        visitor.visitIdentifierVariable(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof TirVisitor) accept((TirVisitor) visitor);
        else super.accept(visitor);
    }

}
