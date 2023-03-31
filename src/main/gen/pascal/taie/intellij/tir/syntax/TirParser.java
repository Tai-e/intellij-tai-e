// This is a generated file. Not intended for manual editing.
package pascal.taie.intellij.tir.syntax;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static pascal.taie.intellij.tir.syntax.TirTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TirParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return tir_file(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // identifier_variable (LANGLE | RANGLE | CMP_OP | BIT_OP | ADD_OP | SUB_OP | MUL_OP | DIV_OP | MOD_OP) identifier_variable
  public static boolean binary_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binary_expr")) return false;
    if (!nextTokenIs(builder_, "<binary expr>", CONSTANT_IDENTIFIER, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, BINARY_EXPR, "<binary expr>");
    result_ = identifier_variable(builder_, level_ + 1);
    result_ = result_ && binary_expr_1(builder_, level_ + 1);
    result_ = result_ && identifier_variable(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // LANGLE | RANGLE | CMP_OP | BIT_OP | ADD_OP | SUB_OP | MUL_OP | DIV_OP | MOD_OP
  private static boolean binary_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binary_expr_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, LANGLE);
    if (!result_) result_ = consumeToken(builder_, RANGLE);
    if (!result_) result_ = consumeToken(builder_, CMP_OP);
    if (!result_) result_ = consumeToken(builder_, BIT_OP);
    if (!result_) result_ = consumeToken(builder_, ADD_OP);
    if (!result_) result_ = consumeToken(builder_, SUB_OP);
    if (!result_) result_ = consumeToken(builder_, MUL_OP);
    if (!result_) result_ = consumeToken(builder_, DIV_OP);
    if (!result_) result_ = consumeToken(builder_, MOD_OP);
    return result_;
  }

  /* ********************************************************** */
  // EXTENDS identifier_class (COMMA identifier_class)*
  public static boolean class_extends(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_extends")) return false;
    if (!nextTokenIs(builder_, EXTENDS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EXTENDS);
    result_ = result_ && identifier_class(builder_, level_ + 1);
    result_ = result_ && class_extends_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, CLASS_EXTENDS, result_);
    return result_;
  }

  // (COMMA identifier_class)*
  private static boolean class_extends_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_extends_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!class_extends_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "class_extends_2", pos_)) break;
    }
    return true;
  }

  // COMMA identifier_class
  private static boolean class_extends_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_extends_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && identifier_class(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // IMPLEMENTS identifier_class (COMMA identifier_class)*
  public static boolean class_implements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_implements")) return false;
    if (!nextTokenIs(builder_, IMPLEMENTS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IMPLEMENTS);
    result_ = result_ && identifier_class(builder_, level_ + 1);
    result_ = result_ && class_implements_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, CLASS_IMPLEMENTS, result_);
    return result_;
  }

  // (COMMA identifier_class)*
  private static boolean class_implements_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_implements_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!class_implements_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "class_implements_2", pos_)) break;
    }
    return true;
  }

  // COMMA identifier_class
  private static boolean class_implements_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_implements_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && identifier_class(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // field_def | method_def | COMMENT
  public static boolean class_member(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_member")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CLASS_MEMBER, "<class member>");
    result_ = field_def(builder_, level_ + 1);
    if (!result_) result_ = method_def(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // MODIFIER* identifier_type identifier_field_list SEMICOLON
  public static boolean field_def(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_def")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FIELD_DEF, "<field def>");
    result_ = field_def_0(builder_, level_ + 1);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && identifier_field_list(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // MODIFIER*
  private static boolean field_def_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_def_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, MODIFIER)) break;
      if (!empty_element_parsed_guard_(builder_, "field_def_0", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER COLON identifier_type IDENTIFIER
  public static boolean field_ref(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_ref")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, COLON);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, FIELD_REF, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean identifier_class(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_class")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, IDENTIFIER_CLASS, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean identifier_field(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_field")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, IDENTIFIER_FIELD, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier_field (COMMA identifier_field)*
  public static boolean identifier_field_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_field_list")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_field(builder_, level_ + 1);
    result_ = result_ && identifier_field_list_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, IDENTIFIER_FIELD_LIST, result_);
    return result_;
  }

  // (COMMA identifier_field)*
  private static boolean identifier_field_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_field_list_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!identifier_field_list_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "identifier_field_list_1", pos_)) break;
    }
    return true;
  }

  // COMMA identifier_field
  private static boolean identifier_field_list_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_field_list_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && identifier_field(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER | LANGLE IDENTIFIER RANGLE
  public static boolean identifier_method(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_method")) return false;
    if (!nextTokenIs(builder_, "<identifier method>", IDENTIFIER, LANGLE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, IDENTIFIER_METHOD, "<identifier method>");
    result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = parseTokens(builder_, 0, LANGLE, IDENTIFIER, RANGLE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // identifier_class (LBRACKET RBRACKET)? | NULL_TYPE
  public static boolean identifier_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_type")) return false;
    if (!nextTokenIs(builder_, "<identifier type>", IDENTIFIER, NULL_TYPE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, IDENTIFIER_TYPE, "<identifier type>");
    result_ = identifier_type_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, NULL_TYPE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // identifier_class (LBRACKET RBRACKET)?
  private static boolean identifier_type_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_type_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_class(builder_, level_ + 1);
    result_ = result_ && identifier_type_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (LBRACKET RBRACKET)?
  private static boolean identifier_type_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_type_0_1")) return false;
    identifier_type_0_1_0(builder_, level_ + 1);
    return true;
  }

  // LBRACKET RBRACKET
  private static boolean identifier_type_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_type_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, LBRACKET, RBRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER | CONSTANT_IDENTIFIER
  public static boolean identifier_variable(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_variable")) return false;
    if (!nextTokenIs(builder_, "<identifier variable>", CONSTANT_IDENTIFIER, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, IDENTIFIER_VARIABLE, "<identifier variable>");
    result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, CONSTANT_IDENTIFIER);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // identifier_variable (COMMA identifier_variable)*
  public static boolean invoke_argument_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_argument_list")) return false;
    if (!nextTokenIs(builder_, "<invoke argument list>", CONSTANT_IDENTIFIER, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, INVOKE_ARGUMENT_LIST, "<invoke argument list>");
    result_ = identifier_variable(builder_, level_ + 1);
    result_ = result_ && invoke_argument_list_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (COMMA identifier_variable)*
  private static boolean invoke_argument_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_argument_list_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!invoke_argument_list_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "invoke_argument_list_1", pos_)) break;
    }
    return true;
  }

  // COMMA identifier_variable
  private static boolean invoke_argument_list_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_argument_list_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && identifier_variable(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // INVOKE_KEY (identifier_variable DOT)? LANGLE invoke_method_ref RANGLE LPAREN invoke_argument_list? RPAREN
  public static boolean invoke_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_expr")) return false;
    if (!nextTokenIs(builder_, INVOKE_KEY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, INVOKE_KEY);
    result_ = result_ && invoke_expr_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LANGLE);
    result_ = result_ && invoke_method_ref(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, RANGLE, LPAREN);
    result_ = result_ && invoke_expr_6(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, INVOKE_EXPR, result_);
    return result_;
  }

  // (identifier_variable DOT)?
  private static boolean invoke_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_expr_1")) return false;
    invoke_expr_1_0(builder_, level_ + 1);
    return true;
  }

  // identifier_variable DOT
  private static boolean invoke_expr_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_expr_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_variable(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, DOT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // invoke_argument_list?
  private static boolean invoke_expr_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_expr_6")) return false;
    invoke_argument_list(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier_class COLON identifier_type identifier_method LPAREN (identifier_type (COMMA identifier_type)*)? RPAREN
  public static boolean invoke_method_ref(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_method_ref")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_class(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && identifier_method(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LPAREN);
    result_ = result_ && invoke_method_ref_5(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, INVOKE_METHOD_REF, result_);
    return result_;
  }

  // (identifier_type (COMMA identifier_type)*)?
  private static boolean invoke_method_ref_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_method_ref_5")) return false;
    invoke_method_ref_5_0(builder_, level_ + 1);
    return true;
  }

  // identifier_type (COMMA identifier_type)*
  private static boolean invoke_method_ref_5_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_method_ref_5_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_type(builder_, level_ + 1);
    result_ = result_ && invoke_method_ref_5_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (COMMA identifier_type)*
  private static boolean invoke_method_ref_5_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_method_ref_5_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!invoke_method_ref_5_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "invoke_method_ref_5_0_1", pos_)) break;
    }
    return true;
  }

  // COMMA identifier_type
  private static boolean invoke_method_ref_5_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_method_ref_5_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier_variable DOT LANGLE field_ref RANGLE
  //          | identifier_variable LBRACKET IDENTIFIER RBRACKET
  //          | identifier_variable
  public static boolean lvalue(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lvalue")) return false;
    if (!nextTokenIs(builder_, "<lvalue>", CONSTANT_IDENTIFIER, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LVALUE, "<lvalue>");
    result_ = lvalue_0(builder_, level_ + 1);
    if (!result_) result_ = lvalue_1(builder_, level_ + 1);
    if (!result_) result_ = identifier_variable(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // identifier_variable DOT LANGLE field_ref RANGLE
  private static boolean lvalue_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lvalue_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_variable(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, DOT, LANGLE);
    result_ = result_ && field_ref(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RANGLE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // identifier_variable LBRACKET IDENTIFIER RBRACKET
  private static boolean lvalue_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lvalue_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_variable(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, LBRACKET, IDENTIFIER, RBRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (method_body_var | method_body_line | method_body_catch)+
  public static boolean method_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, METHOD_BODY, "<method body>");
    result_ = method_body_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!method_body_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "method_body", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // method_body_var | method_body_line | method_body_catch
  private static boolean method_body_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_0")) return false;
    boolean result_;
    result_ = method_body_var(builder_, level_ + 1);
    if (!result_) result_ = method_body_line(builder_, level_ + 1);
    if (!result_) result_ = method_body_catch(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // TRY LBRACKET INTEGER COMMA INTEGER RPAREN COMMA CATCH identifier_variable AT INTEGER
  public static boolean method_body_catch(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_catch")) return false;
    if (!nextTokenIs(builder_, TRY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, TRY, LBRACKET, INTEGER, COMMA, INTEGER, RPAREN, COMMA, CATCH);
    result_ = result_ && identifier_variable(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, AT, INTEGER);
    exit_section_(builder_, marker_, METHOD_BODY_CATCH, result_);
    return result_;
  }

  /* ********************************************************** */
  // LINE_NUMBER method_body_stmt SEMICOLON
  public static boolean method_body_line(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_line")) return false;
    if (!nextTokenIs(builder_, LINE_NUMBER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LINE_NUMBER);
    result_ = result_ && method_body_stmt(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, marker_, METHOD_BODY_LINE, result_);
    return result_;
  }

  /* ********************************************************** */
  // lvalue EQUAL rvalue
  //                    | identifier_variable EQUAL NEW identifier_type
  //                    | identifier_variable EQUAL NEW_ARRAY identifier_type LBRACKET identifier_variable RBRACKET
  //                    | THROW identifier_type
  //                    | CATCH identifier_variable
  //                    | invoke_expr
  //                    | IF LPAREN (unary_expr | binary_expr | IDENTIFIER) RPAREN GOTO INTEGER
  //                    | GOTO INTEGER
  //                    | RETURN identifier_variable?
  public static boolean method_body_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, METHOD_BODY_STMT, "<method body stmt>");
    result_ = method_body_stmt_0(builder_, level_ + 1);
    if (!result_) result_ = method_body_stmt_1(builder_, level_ + 1);
    if (!result_) result_ = method_body_stmt_2(builder_, level_ + 1);
    if (!result_) result_ = method_body_stmt_3(builder_, level_ + 1);
    if (!result_) result_ = method_body_stmt_4(builder_, level_ + 1);
    if (!result_) result_ = invoke_expr(builder_, level_ + 1);
    if (!result_) result_ = method_body_stmt_6(builder_, level_ + 1);
    if (!result_) result_ = parseTokens(builder_, 0, GOTO, INTEGER);
    if (!result_) result_ = method_body_stmt_8(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // lvalue EQUAL rvalue
  private static boolean method_body_stmt_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = lvalue(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EQUAL);
    result_ = result_ && rvalue(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // identifier_variable EQUAL NEW identifier_type
  private static boolean method_body_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_variable(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, EQUAL, NEW);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // identifier_variable EQUAL NEW_ARRAY identifier_type LBRACKET identifier_variable RBRACKET
  private static boolean method_body_stmt_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_variable(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, EQUAL, NEW_ARRAY);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LBRACKET);
    result_ = result_ && identifier_variable(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RBRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // THROW identifier_type
  private static boolean method_body_stmt_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, THROW);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // CATCH identifier_variable
  private static boolean method_body_stmt_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_4")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, CATCH);
    result_ = result_ && identifier_variable(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // IF LPAREN (unary_expr | binary_expr | IDENTIFIER) RPAREN GOTO INTEGER
  private static boolean method_body_stmt_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_6")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IF, LPAREN);
    result_ = result_ && method_body_stmt_6_2(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, RPAREN, GOTO, INTEGER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // unary_expr | binary_expr | IDENTIFIER
  private static boolean method_body_stmt_6_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_6_2")) return false;
    boolean result_;
    result_ = unary_expr(builder_, level_ + 1);
    if (!result_) result_ = binary_expr(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    return result_;
  }

  // RETURN identifier_variable?
  private static boolean method_body_stmt_8(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_8")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RETURN);
    result_ = result_ && method_body_stmt_8_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // identifier_variable?
  private static boolean method_body_stmt_8_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_8_1")) return false;
    identifier_variable(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier_type identifier_variable (COMMA identifier_variable)* SEMICOLON
  public static boolean method_body_var(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_var")) return false;
    if (!nextTokenIs(builder_, "<method body var>", IDENTIFIER, NULL_TYPE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, METHOD_BODY_VAR, "<method body var>");
    result_ = identifier_type(builder_, level_ + 1);
    result_ = result_ && identifier_variable(builder_, level_ + 1);
    result_ = result_ && method_body_var_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (COMMA identifier_variable)*
  private static boolean method_body_var_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_var_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!method_body_var_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "method_body_var_2", pos_)) break;
    }
    return true;
  }

  // COMMA identifier_variable
  private static boolean method_body_var_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_var_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && identifier_variable(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // method_sig LBRACE method_body RBRACE
  public static boolean method_def(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_def")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, METHOD_DEF, "<method def>");
    result_ = method_sig(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LBRACE);
    result_ = result_ && method_body(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RBRACE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // MODIFIER* identifier_type identifier_method LPAREN (identifier_type IDENTIFIER (COMMA identifier_type IDENTIFIER)*)? RPAREN
  public static boolean method_sig(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_sig")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, METHOD_SIG, "<method sig>");
    result_ = method_sig_0(builder_, level_ + 1);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && identifier_method(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LPAREN);
    result_ = result_ && method_sig_4(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // MODIFIER*
  private static boolean method_sig_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_sig_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, MODIFIER)) break;
      if (!empty_element_parsed_guard_(builder_, "method_sig_0", pos_)) break;
    }
    return true;
  }

  // (identifier_type IDENTIFIER (COMMA identifier_type IDENTIFIER)*)?
  private static boolean method_sig_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_sig_4")) return false;
    method_sig_4_0(builder_, level_ + 1);
    return true;
  }

  // identifier_type IDENTIFIER (COMMA identifier_type IDENTIFIER)*
  private static boolean method_sig_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_sig_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_type(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    result_ = result_ && method_sig_4_0_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (COMMA identifier_type IDENTIFIER)*
  private static boolean method_sig_4_0_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_sig_4_0_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!method_sig_4_0_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "method_sig_4_0_2", pos_)) break;
    }
    return true;
  }

  // COMMA identifier_type IDENTIFIER
  private static boolean method_sig_4_0_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_sig_4_0_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier_variable DOT LANGLE field_ref RANGLE
  //          | identifier_variable LBRACKET IDENTIFIER RBRACKET
  //          | LPAREN identifier_type RPAREN IDENTIFIER
  //          | invoke_expr
  //          | unary_expr
  //          | binary_expr
  //          | identifier_variable INSTANCEOF identifier_type
  //          | identifier_variable
  //          | FLOAT
  //          | INTEGER
  //          | STRING_LITERAL
  public static boolean rvalue(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rvalue")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RVALUE, "<rvalue>");
    result_ = rvalue_0(builder_, level_ + 1);
    if (!result_) result_ = rvalue_1(builder_, level_ + 1);
    if (!result_) result_ = rvalue_2(builder_, level_ + 1);
    if (!result_) result_ = invoke_expr(builder_, level_ + 1);
    if (!result_) result_ = unary_expr(builder_, level_ + 1);
    if (!result_) result_ = binary_expr(builder_, level_ + 1);
    if (!result_) result_ = rvalue_6(builder_, level_ + 1);
    if (!result_) result_ = identifier_variable(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, FLOAT);
    if (!result_) result_ = consumeToken(builder_, INTEGER);
    if (!result_) result_ = consumeToken(builder_, STRING_LITERAL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // identifier_variable DOT LANGLE field_ref RANGLE
  private static boolean rvalue_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rvalue_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_variable(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, DOT, LANGLE);
    result_ = result_ && field_ref(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RANGLE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // identifier_variable LBRACKET IDENTIFIER RBRACKET
  private static boolean rvalue_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rvalue_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_variable(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, LBRACKET, IDENTIFIER, RBRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // LPAREN identifier_type RPAREN IDENTIFIER
  private static boolean rvalue_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rvalue_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, RPAREN, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // identifier_variable INSTANCEOF identifier_type
  private static boolean rvalue_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rvalue_6")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_variable(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, INSTANCEOF);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // MODIFIER* (CLASS | INTERFACE) identifier_class class_extends? class_implements? LBRACE class_member* RBRACE
  static boolean tir_file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tir_file")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = tir_file_0(builder_, level_ + 1);
    result_ = result_ && tir_file_1(builder_, level_ + 1);
    result_ = result_ && identifier_class(builder_, level_ + 1);
    result_ = result_ && tir_file_3(builder_, level_ + 1);
    result_ = result_ && tir_file_4(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LBRACE);
    result_ = result_ && tir_file_6(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RBRACE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // MODIFIER*
  private static boolean tir_file_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tir_file_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, MODIFIER)) break;
      if (!empty_element_parsed_guard_(builder_, "tir_file_0", pos_)) break;
    }
    return true;
  }

  // CLASS | INTERFACE
  private static boolean tir_file_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tir_file_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, CLASS);
    if (!result_) result_ = consumeToken(builder_, INTERFACE);
    return result_;
  }

  // class_extends?
  private static boolean tir_file_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tir_file_3")) return false;
    class_extends(builder_, level_ + 1);
    return true;
  }

  // class_implements?
  private static boolean tir_file_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tir_file_4")) return false;
    class_implements(builder_, level_ + 1);
    return true;
  }

  // class_member*
  private static boolean tir_file_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tir_file_6")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!class_member(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "tir_file_6", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (ADD_OP | SUB_OP | NOT_OP) identifier_variable
  public static boolean unary_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unary_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, UNARY_EXPR, "<unary expr>");
    result_ = unary_expr_0(builder_, level_ + 1);
    result_ = result_ && identifier_variable(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ADD_OP | SUB_OP | NOT_OP
  private static boolean unary_expr_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unary_expr_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, ADD_OP);
    if (!result_) result_ = consumeToken(builder_, SUB_OP);
    if (!result_) result_ = consumeToken(builder_, NOT_OP);
    return result_;
  }

}
