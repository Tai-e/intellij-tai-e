// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import pascal.taie.intellij.tir.syntax.psi.*;

import java.util.List;

public class TirMethodBodyImpl extends ASTWrapperPsiElement implements TirMethodBody {

  public TirMethodBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitMethodBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TirMethodBodyCatch> getMethodBodyCatchList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TirMethodBodyCatch.class);
  }

  @Override
  @NotNull
  public List<TirMethodBodyLine> getMethodBodyLineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TirMethodBodyLine.class);
  }

  @Override
  @NotNull
  public List<TirMethodBodyVar> getMethodBodyVarList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TirMethodBodyVar.class);
  }

}
