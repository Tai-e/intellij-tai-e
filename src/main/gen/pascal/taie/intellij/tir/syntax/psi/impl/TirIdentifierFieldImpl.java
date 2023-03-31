// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import pascal.taie.intellij.tir.syntax.psi.TirIdentifierField;
import pascal.taie.intellij.tir.syntax.psi.TirVisitor;

public class TirIdentifierFieldImpl extends ASTWrapperPsiElement implements TirIdentifierField {

  public TirIdentifierFieldImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitIdentifierField(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

}
