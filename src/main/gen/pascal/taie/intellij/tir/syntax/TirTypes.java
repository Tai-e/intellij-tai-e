// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import pascal.taie.intellij.tir.syntax.psi.impl.*;

public interface TirTypes {

  IElementType BINARY_EXPR = new TirElementType("BINARY_EXPR");
  IElementType CLASS_EXTENDS = new TirElementType("CLASS_EXTENDS");
  IElementType CLASS_IMPLEMENTS = new TirElementType("CLASS_IMPLEMENTS");
  IElementType CLASS_MEMBER = new TirElementType("CLASS_MEMBER");
  IElementType FIELD_DEF = new TirElementType("FIELD_DEF");
  IElementType FIELD_REF = new TirElementType("FIELD_REF");
    IElementType FIELD_SIG = new TirElementType("FIELD_SIG");
    IElementType IDENTIFIER_CLASS = new TirElementType("IDENTIFIER_CLASS");
  IElementType IDENTIFIER_FIELD = new TirElementType("IDENTIFIER_FIELD");
  IElementType IDENTIFIER_FIELD_LIST = new TirElementType("IDENTIFIER_FIELD_LIST");
  IElementType IDENTIFIER_METHOD = new TirElementType("IDENTIFIER_METHOD");
  IElementType IDENTIFIER_TYPE = new TirElementType("IDENTIFIER_TYPE");
  IElementType IDENTIFIER_VARIABLE = new TirElementType("IDENTIFIER_VARIABLE");
  IElementType INVOKE_ARGUMENT_LIST = new TirElementType("INVOKE_ARGUMENT_LIST");
  IElementType INVOKE_EXPR = new TirElementType("INVOKE_EXPR");
  IElementType INVOKE_METHOD_REF = new TirElementType("INVOKE_METHOD_REF");
  IElementType LVALUE = new TirElementType("LVALUE");
  IElementType METHOD_BODY = new TirElementType("METHOD_BODY");
  IElementType METHOD_BODY_CATCH = new TirElementType("METHOD_BODY_CATCH");
  IElementType METHOD_BODY_LINE = new TirElementType("METHOD_BODY_LINE");
  IElementType METHOD_BODY_STMT = new TirElementType("METHOD_BODY_STMT");
  IElementType METHOD_BODY_VAR = new TirElementType("METHOD_BODY_VAR");
  IElementType METHOD_DEF = new TirElementType("METHOD_DEF");
  IElementType METHOD_SIG = new TirElementType("METHOD_SIG");
  IElementType RVALUE = new TirElementType("RVALUE");
  IElementType UNARY_EXPR = new TirElementType("UNARY_EXPR");

  IElementType ADD_OP = new TirTokenType("ADD_OP");
  IElementType AT = new TirTokenType("AT");
  IElementType BIT_OP = new TirTokenType("BIT_OP");
  IElementType CATCH = new TirTokenType("CATCH");
  IElementType CLASS = new TirTokenType("CLASS");
  IElementType CMP_OP = new TirTokenType("CMP_OP");
  IElementType COLON = new TirTokenType("COLON");
  IElementType COMMA = new TirTokenType("COMMA");
  IElementType COMMENT = new TirTokenType("COMMENT");
  IElementType CONSTANT_IDENTIFIER = new TirTokenType("CONSTANT_IDENTIFIER");
  IElementType DIV_OP = new TirTokenType("DIV_OP");
  IElementType DOT = new TirTokenType("DOT");
  IElementType EQUAL = new TirTokenType("EQUAL");
  IElementType EXTENDS = new TirTokenType("EXTENDS");
  IElementType FLOAT = new TirTokenType("FLOAT");
  IElementType GOTO = new TirTokenType("GOTO");
  IElementType IDENTIFIER = new TirTokenType("IDENTIFIER");
  IElementType IF = new TirTokenType("IF");
  IElementType IMPLEMENTS = new TirTokenType("IMPLEMENTS");
  IElementType INSTANCEOF = new TirTokenType("INSTANCEOF");
  IElementType INTEGER = new TirTokenType("INTEGER");
  IElementType INTERFACE = new TirTokenType("INTERFACE");
  IElementType INVOKE_KEY = new TirTokenType("INVOKE_KEY");
  IElementType LANGLE = new TirTokenType("LANGLE");
  IElementType LBRACE = new TirTokenType("LBRACE");
  IElementType LBRACKET = new TirTokenType("LBRACKET");
  IElementType LINE_NUMBER = new TirTokenType("LINE_NUMBER");
  IElementType LPAREN = new TirTokenType("LPAREN");
  IElementType MODIFIER = new TirTokenType("MODIFIER");
  IElementType MOD_OP = new TirTokenType("MOD_OP");
  IElementType MUL_OP = new TirTokenType("MUL_OP");
  IElementType NEW = new TirTokenType("NEW");
  IElementType NEW_ARRAY = new TirTokenType("NEW_ARRAY");
  IElementType NOP = new TirTokenType("NOP");
  IElementType NOT_OP = new TirTokenType("NOT_OP");
  IElementType NULL_TYPE = new TirTokenType("NULL_TYPE");
  IElementType RANGLE = new TirTokenType("RANGLE");
  IElementType RBRACE = new TirTokenType("RBRACE");
  IElementType RBRACKET = new TirTokenType("RBRACKET");
  IElementType RETURN = new TirTokenType("RETURN");
  IElementType RPAREN = new TirTokenType("RPAREN");
  IElementType SEMICOLON = new TirTokenType("SEMICOLON");
  IElementType STRING_LITERAL = new TirTokenType("STRING_LITERAL");
  IElementType SUB_OP = new TirTokenType("SUB_OP");
  IElementType THROW = new TirTokenType("THROW");
  IElementType TRY = new TirTokenType("TRY");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BINARY_EXPR) {
        return new TirBinaryExprImpl(node);
      }
      else if (type == CLASS_EXTENDS) {
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
      else if (type == FIELD_REF) {
          return new TirFieldRefImpl(node);
      } else if (type == FIELD_SIG) {
          return new TirFieldSigImpl(node);
      } else if (type == IDENTIFIER_CLASS) {
          return new TirIdentifierClassImpl(node);
      } else if (type == IDENTIFIER_FIELD) {
          return new TirIdentifierFieldImpl(node);
      } else if (type == IDENTIFIER_FIELD_LIST) {
          return new TirIdentifierFieldListImpl(node);
      } else if (type == IDENTIFIER_METHOD) {
          return new TirIdentifierMethodImpl(node);
      } else if (type == IDENTIFIER_TYPE) {
          return new TirIdentifierTypeImpl(node);
      } else if (type == IDENTIFIER_VARIABLE) {
          return new TirIdentifierVariableImpl(node);
      } else if (type == INVOKE_ARGUMENT_LIST) {
          return new TirInvokeArgumentListImpl(node);
      } else if (type == INVOKE_EXPR) {
          return new TirInvokeExprImpl(node);
      } else if (type == INVOKE_METHOD_REF) {
          return new TirInvokeMethodRefImpl(node);
      } else if (type == LVALUE) {
          return new TirLvalueImpl(node);
      } else if (type == METHOD_BODY) {
          return new TirMethodBodyImpl(node);
      } else if (type == METHOD_BODY_CATCH) {
          return new TirMethodBodyCatchImpl(node);
      } else if (type == METHOD_BODY_LINE) {
          return new TirMethodBodyLineImpl(node);
      } else if (type == METHOD_BODY_STMT) {
          return new TirMethodBodyStmtImpl(node);
      } else if (type == METHOD_BODY_VAR) {
          return new TirMethodBodyVarImpl(node);
      } else if (type == METHOD_DEF) {
          return new TirMethodDefImpl(node);
      } else if (type == METHOD_SIG) {
          return new TirMethodSigImpl(node);
      } else if (type == RVALUE) {
          return new TirRvalueImpl(node);
      } else if (type == UNARY_EXPR) {
          return new TirUnaryExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
