// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pascal.taie.intellij.tir.syntax.psi.TirClassMember;
import pascal.taie.intellij.tir.syntax.psi.TirFieldDef;
import pascal.taie.intellij.tir.syntax.psi.TirMethodDef;
import pascal.taie.intellij.tir.syntax.psi.TirVisitor;

public class TirClassMemberImpl extends ASTWrapperPsiElement implements TirClassMember {

  public TirClassMemberImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitClassMember(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TirFieldDef getFieldDef() {
    return findChildByClass(TirFieldDef.class);
  }

  @Override
  @Nullable
  public TirMethodDef getMethodDef() {
    return findChildByClass(TirMethodDef.class);
  }

}
