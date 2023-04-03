// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TirMethodBody extends PsiElement {

  @NotNull
  List<TirMethodBodyCatch> getMethodBodyCatchList();

  @NotNull
  List<TirMethodBodyLine> getMethodBodyLineList();

  @NotNull
  List<TirMethodBodyVar> getMethodBodyVarList();

}
