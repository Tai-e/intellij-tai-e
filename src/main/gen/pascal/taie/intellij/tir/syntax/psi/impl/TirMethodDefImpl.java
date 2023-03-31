// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pascal.taie.intellij.tir.syntax.psi.TirMethodBody;
import pascal.taie.intellij.tir.syntax.psi.TirMethodDef;
import pascal.taie.intellij.tir.syntax.psi.TirMethodSig;
import pascal.taie.intellij.tir.syntax.psi.TirVisitor;

public class TirMethodDefImpl extends ASTWrapperPsiElement implements TirMethodDef {

  public TirMethodDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitMethodDef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TirMethodBody getMethodBody() {
    return findChildByClass(TirMethodBody.class);
  }

  @Override
  @NotNull
  public TirMethodSig getMethodSig() {
    return findNotNullChildByClass(TirMethodSig.class);
  }

}
