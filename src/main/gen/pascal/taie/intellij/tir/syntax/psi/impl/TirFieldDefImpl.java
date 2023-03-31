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

public class TirFieldDefImpl extends ASTWrapperPsiElement implements TirFieldDef {

  public TirFieldDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TirVisitor visitor) {
    visitor.visitFieldDef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TirVisitor) accept((TirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public TirIdentifierFieldList getIdentifierFieldList() {
    return findNotNullChildByClass(TirIdentifierFieldList.class);
  }

  @Override
  @NotNull
  public TirIdentifierType getIdentifierType() {
    return findNotNullChildByClass(TirIdentifierType.class);
  }

}
