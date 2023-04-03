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
import pascal.taie.intellij.tir.syntax.TirPsiUtil;

public class TirMethodBodyStmtImpl extends ASTWrapperPsiElement implements TirMethodBodyStmt {

  public TirMethodBodyStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitMethodBodyStmt(this);
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
  public TirLvalue getLvalue() {
    return findChildByClass(TirLvalue.class);
  }

  @Override
  @Nullable
  public TirRvalue getRvalue() {
    return findChildByClass(TirRvalue.class);
  }

  @Override
  @Nullable
  public TirUnaryExpr getUnaryExpr() {
    return findChildByClass(TirUnaryExpr.class);
  }

}
