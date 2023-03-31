// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface TirLvalue extends PsiElement {

    @Nullable
    TirFieldSig getFieldSig();

    @NotNull
    List<TirIdentifierVariable> getIdentifierVariableList();

}
