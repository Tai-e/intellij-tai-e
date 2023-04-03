// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TirRvalue extends PsiElement {

  @Nullable
  TirBinaryExpr getBinaryExpr();

  @Nullable
  TirFieldSig getFieldSig();

  @Nullable
  TirIdentifierType getIdentifierType();

  @Nullable
  TirIdentifierVariable getIdentifierVariable();

  @Nullable
  TirInvokeExpr getInvokeExpr();

  @Nullable
  TirUnaryExpr getUnaryExpr();

}
