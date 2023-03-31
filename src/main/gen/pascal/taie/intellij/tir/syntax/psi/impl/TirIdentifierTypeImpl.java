// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pascal.taie.intellij.tir.syntax.psi.TirIdentifierClass;
import pascal.taie.intellij.tir.syntax.psi.TirIdentifierType;
import pascal.taie.intellij.tir.syntax.psi.TirVisitor;

public class TirIdentifierTypeImpl extends ASTWrapperPsiElement implements TirIdentifierType {

  public TirIdentifierTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitIdentifierType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TirIdentifierClass getIdentifierClass() {
    return findChildByClass(TirIdentifierClass.class);
  }

}
