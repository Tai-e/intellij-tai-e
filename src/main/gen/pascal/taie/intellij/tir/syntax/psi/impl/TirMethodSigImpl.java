// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import pascal.taie.intellij.tir.syntax.psi.TirIdentifierMethod;
import pascal.taie.intellij.tir.syntax.psi.TirIdentifierType;
import pascal.taie.intellij.tir.syntax.psi.TirMethodSig;
import pascal.taie.intellij.tir.syntax.psi.TirVisitor;

import java.util.List;

public class TirMethodSigImpl extends ASTWrapperPsiElement implements TirMethodSig {

  public TirMethodSigImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitMethodSig(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public TirIdentifierMethod getIdentifierMethod() {
    return findNotNullChildByClass(TirIdentifierMethod.class);
  }

  @Override
  @NotNull
  public List<TirIdentifierType> getIdentifierTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TirIdentifierType.class);
  }

}
