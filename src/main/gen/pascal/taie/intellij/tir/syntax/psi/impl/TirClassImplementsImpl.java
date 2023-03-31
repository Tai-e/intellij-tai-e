// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import pascal.taie.intellij.tir.syntax.psi.TirClassImplements;
import pascal.taie.intellij.tir.syntax.psi.TirIdentifierClass;
import pascal.taie.intellij.tir.syntax.psi.TirVisitor;

import java.util.List;

public class TirClassImplementsImpl extends ASTWrapperPsiElement implements TirClassImplements {

  public TirClassImplementsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitClassImplements(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TirIdentifierClass> getIdentifierClassList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TirIdentifierClass.class);
  }

}
