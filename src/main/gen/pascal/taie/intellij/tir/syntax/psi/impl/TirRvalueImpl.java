// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pascal.taie.intellij.tir.syntax.psi.*;

public class TirRvalueImpl extends ASTWrapperPsiElement implements TirRvalue {

  public TirRvalueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitRvalue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TirBinaryExpr getBinaryExpr() {
    return findChildByClass(TirBinaryExpr.class);
  }

  @Override
  @Nullable
  public TirFieldSig getFieldSig() {
      return findChildByClass(TirFieldSig.class);
  }

  @Override
  @Nullable
  public TirIdentifierType getIdentifierType() {
    return findChildByClass(TirIdentifierType.class);
  }

  @Override
  @Nullable
  public TirIdentifierVariable getIdentifierVariable() {
    return findChildByClass(TirIdentifierVariable.class);
  }

  @Override
  @Nullable
  public TirInvokeExpr getInvokeExpr() {
    return findChildByClass(TirInvokeExpr.class);
  }

  @Override
  @Nullable
  public TirUnaryExpr getUnaryExpr() {
    return findChildByClass(TirUnaryExpr.class);
  }

}
