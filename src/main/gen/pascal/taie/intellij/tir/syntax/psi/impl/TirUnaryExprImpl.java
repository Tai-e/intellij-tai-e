// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import pascal.taie.intellij.tir.syntax.psi.TirIdentifierVariable;
import pascal.taie.intellij.tir.syntax.psi.TirUnaryExpr;
import pascal.taie.intellij.tir.syntax.psi.TirVisitor;

public class TirUnaryExprImpl extends ASTWrapperPsiElement implements TirUnaryExpr {

  public TirUnaryExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitUnaryExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public TirIdentifierVariable getIdentifierVariable() {
    return findNotNullChildByClass(TirIdentifierVariable.class);
  }

}
