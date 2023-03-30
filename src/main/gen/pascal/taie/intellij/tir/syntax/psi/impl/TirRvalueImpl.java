// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static pascal.taie.intellij.tir.syntax.TirTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
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
  public TirFieldRef getFieldRef() {
    return findChildByClass(TirFieldRef.class);
  }

  @Override
  @Nullable
  public TirIdentifierType getIdentifierType() {
    return findChildByClass(TirIdentifierType.class);
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
