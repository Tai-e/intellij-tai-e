// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import pascal.taie.intellij.tir.syntax.TirNamedElement;

public class TirVisitor extends PsiElementVisitor {

  public void visitBinaryExpr(@NotNull TirBinaryExpr o) {
    visitPsiElement(o);
  }

  public void visitClassExtends(@NotNull TirClassExtends o) {
    visitPsiElement(o);
  }

    public void visitClassImplements(@NotNull TirClassImplements o) {
        visitPsiElement(o);
    }

    public void visitClassMember(@NotNull TirClassMember o) {
        visitPsiElement(o);
    }

    public void visitFieldDef(@NotNull TirFieldDef o) {
        visitPsiElement(o);
    }

    public void visitFieldRef(@NotNull TirFieldRef o) {
        visitPsiElement(o);
    }

    public void visitFieldSig(@NotNull TirFieldSig o) {
        visitPsiElement(o);
    }

    public void visitIdentifierClass(@NotNull TirIdentifierClass o) {
        visitPsiElement(o);
    }

    public void visitIdentifierField(@NotNull TirIdentifierField o) {
        visitPsiElement(o);
    }

    public void visitIdentifierFieldList(@NotNull TirIdentifierFieldList o) {
        visitPsiElement(o);
    }

    public void visitIdentifierMethod(@NotNull TirIdentifierMethod o) {
        visitPsiElement(o);
    }

    public void visitIdentifierType(@NotNull TirIdentifierType o) {
    visitPsiElement(o);
  }

  public void visitIdentifierVariable(@NotNull TirIdentifierVariable o) {
      visitNamedElement(o);
  }

  public void visitInvokeArgumentList(@NotNull TirInvokeArgumentList o) {
    visitPsiElement(o);
  }

  public void visitInvokeExpr(@NotNull TirInvokeExpr o) {
    visitPsiElement(o);
  }

  public void visitInvokeMethodRef(@NotNull TirInvokeMethodRef o) {
    visitPsiElement(o);
  }

  public void visitLvalue(@NotNull TirLvalue o) {
    visitPsiElement(o);
  }

  public void visitMethodBody(@NotNull TirMethodBody o) {
    visitPsiElement(o);
  }

  public void visitMethodBodyCatch(@NotNull TirMethodBodyCatch o) {
    visitPsiElement(o);
  }

  public void visitMethodBodyLine(@NotNull TirMethodBodyLine o) {
    visitPsiElement(o);
  }

  public void visitMethodBodyStmt(@NotNull TirMethodBodyStmt o) {
    visitPsiElement(o);
  }

  public void visitMethodBodyVar(@NotNull TirMethodBodyVar o) {
    visitPsiElement(o);
  }

  public void visitMethodDef(@NotNull TirMethodDef o) {
    visitPsiElement(o);
  }

  public void visitMethodSig(@NotNull TirMethodSig o) {
      visitPsiElement(o);
  }

    public void visitRvalue(@NotNull TirRvalue o) {
        visitPsiElement(o);
    }

    public void visitUnaryExpr(@NotNull TirUnaryExpr o) {
        visitPsiElement(o);
    }

    public void visitNamedElement(@NotNull TirNamedElement o) {
        visitPsiElement(o);
    }

    public void visitPsiElement(@NotNull PsiElement o) {
        visitElement(o);
    }

}
