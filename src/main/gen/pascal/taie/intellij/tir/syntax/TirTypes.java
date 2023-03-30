// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import pascal.taie.intellij.tir.syntax.psi.impl.*;

public interface TirTypes {

  IElementType CLASS_EXTENDS = new TirElementType("CLASS_EXTENDS");
  IElementType CLASS_IMPLEMENTS = new TirElementType("CLASS_IMPLEMENTS");
  IElementType CLASS_MEMBER = new TirElementType("CLASS_MEMBER");
  IElementType FIELD_DEF = new TirElementType("FIELD_DEF");
  IElementType IDENTIFIER_LIST = new TirElementType("IDENTIFIER_LIST");
  IElementType IDENTIFIER_METHOD = new TirElementType("IDENTIFIER_METHOD");
  IElementType IDENTIFIER_TYPE = new TirElementType("IDENTIFIER_TYPE");
  IElementType METHOD_BODY = new TirElementType("METHOD_BODY");
  IElementType METHOD_BODY_LINE = new TirElementType("METHOD_BODY_LINE");
  IElementType METHOD_BODY_STMT = new TirElementType("METHOD_BODY_STMT");
  IElementType METHOD_BODY_VAR = new TirElementType("METHOD_BODY_VAR");
  IElementType METHOD_DEF = new TirElementType("METHOD_DEF");
  IElementType METHOD_SIG = new TirElementType("METHOD_SIG");

  IElementType CLASS = new TirTokenType("CLASS");
  IElementType COMMA = new TirTokenType("COMMA");
  IElementType COMMENT = new TirTokenType("COMMENT");
  IElementType EQUAL = new TirTokenType("EQUAL");
  IElementType EXTENDS = new TirTokenType("EXTENDS");
  IElementType IDENTIFIER = new TirTokenType("IDENTIFIER");
  IElementType IMPLEMENTS = new TirTokenType("IMPLEMENTS");
  IElementType LBRACE = new TirTokenType("LBRACE");
  IElementType LBRACKET = new TirTokenType("LBRACKET");
  IElementType LINE_NUMBER = new TirTokenType("LINE_NUMBER");
  IElementType LPAREN = new TirTokenType("LPAREN");
  IElementType MODIFIER = new TirTokenType("MODIFIER");
  IElementType RBRACE = new TirTokenType("RBRACE");
  IElementType RBRACKET = new TirTokenType("RBRACKET");
  IElementType RPAREN = new TirTokenType("RPAREN");
  IElementType SEMICOLON = new TirTokenType("SEMICOLON");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CLASS_EXTENDS) {
        return new TirClassExtendsImpl(node);
      }
      else if (type == CLASS_IMPLEMENTS) {
        return new TirClassImplementsImpl(node);
      }
      else if (type == CLASS_MEMBER) {
        return new TirClassMemberImpl(node);
      }
      else if (type == FIELD_DEF) {
        return new TirFieldDefImpl(node);
      }
      else if (type == IDENTIFIER_LIST) {
        return new TirIdentifierListImpl(node);
      }
      else if (type == IDENTIFIER_METHOD) {
        return new TirIdentifierMethodImpl(node);
      }
      else if (type == IDENTIFIER_TYPE) {
        return new TirIdentifierTypeImpl(node);
      }
      else if (type == METHOD_BODY) {
        return new TirMethodBodyImpl(node);
      }
      else if (type == METHOD_BODY_LINE) {
        return new TirMethodBodyLineImpl(node);
      }
      else if (type == METHOD_BODY_STMT) {
        return new TirMethodBodyStmtImpl(node);
      }
      else if (type == METHOD_BODY_VAR) {
        return new TirMethodBodyVarImpl(node);
      }
      else if (type == METHOD_DEF) {
        return new TirMethodDefImpl(node);
      }
      else if (type == METHOD_SIG) {
        return new TirMethodSigImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
