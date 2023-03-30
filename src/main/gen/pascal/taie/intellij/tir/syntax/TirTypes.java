// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import pascal.taie.intellij.tir.syntax.psi.impl.*;

public interface TirTypes {

  IElementType PROPERTY = new TirElementType("PROPERTY");

  IElementType COMMENT = new TirTokenType("COMMENT");
  IElementType CRLF = new TirTokenType("CRLF");
  IElementType KEY = new TirTokenType("KEY");
  IElementType SEPARATOR = new TirTokenType("SEPARATOR");
  IElementType VALUE = new TirTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new TirPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
