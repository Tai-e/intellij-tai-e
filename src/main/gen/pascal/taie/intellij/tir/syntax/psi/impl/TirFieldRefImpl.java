// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import pascal.taie.intellij.tir.syntax.psi.TirFieldRef;
import pascal.taie.intellij.tir.syntax.psi.TirIdentifierType;
import pascal.taie.intellij.tir.syntax.psi.TirVisitor;

public class TirFieldRefImpl extends ASTWrapperPsiElement implements TirFieldRef {

  public TirFieldRefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitFieldRef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public TirIdentifierType getIdentifierType() {
    return findNotNullChildByClass(TirIdentifierType.class);
  }

}
