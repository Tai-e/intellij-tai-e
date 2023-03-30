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
  // IDENTIFIER (LANGLE | RANGLE | CMP_OP | BIT_OP | ADD_OP | SUB_OP | MUL_OP | DIV_OP | MOD_OP) IDENTIFIER
  public static boolean binary_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "binary_expr")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && binary_expr_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, BINARY_EXPR, result_);
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
  // EXTENDS identifier_list
  public static boolean class_extends(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_extends")) return false;
    if (!nextTokenIs(builder_, EXTENDS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EXTENDS);
    result_ = result_ && identifier_list(builder_, level_ + 1);
    exit_section_(builder_, marker_, CLASS_EXTENDS, result_);
    return result_;
  }

  /* ********************************************************** */
  // IMPLEMENTS identifier_list
  public static boolean class_implements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "class_implements")) return false;
    if (!nextTokenIs(builder_, IMPLEMENTS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IMPLEMENTS);
    result_ = result_ && identifier_list(builder_, level_ + 1);
    exit_section_(builder_, marker_, CLASS_IMPLEMENTS, result_);
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
  // MODIFIER* identifier_type field_identifier_list SEMICOLON
  public static boolean field_def(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_def")) return false;
    if (!nextTokenIs(builder_, "<field def>", IDENTIFIER, MODIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FIELD_DEF, "<field def>");
    result_ = field_def_0(builder_, level_ + 1);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && field_identifier_list(builder_, level_ + 1);
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
  // IDENTIFIER
  public static boolean field_identifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_identifier")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, FIELD_IDENTIFIER, result_);
    return result_;
  }

  /* ********************************************************** */
  // field_identifier (COMMA field_identifier)*
  public static boolean field_identifier_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_identifier_list")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = field_identifier(builder_, level_ + 1);
    result_ = result_ && field_identifier_list_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, FIELD_IDENTIFIER_LIST, result_);
    return result_;
  }

  // (COMMA field_identifier)*
  private static boolean field_identifier_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_identifier_list_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!field_identifier_list_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "field_identifier_list_1", pos_)) break;
    }
    return true;
  }

  // COMMA field_identifier
  private static boolean field_identifier_list_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_identifier_list_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && field_identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
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
  // IDENTIFIER (COMMA IDENTIFIER)*
  public static boolean identifier_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_list")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && identifier_list_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, IDENTIFIER_LIST, result_);
    return result_;
  }

  // (COMMA IDENTIFIER)*
  private static boolean identifier_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_list_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!identifier_list_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "identifier_list_1", pos_)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean identifier_list_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_list_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COMMA, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean identifier_method(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_method")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, IDENTIFIER_METHOD, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER (LBRACKET RBRACKET)?
  public static boolean identifier_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_type")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && identifier_type_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, IDENTIFIER_TYPE, result_);
    return result_;
  }

  // (LBRACKET RBRACKET)?
  private static boolean identifier_type_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_type_1")) return false;
    identifier_type_1_0(builder_, level_ + 1);
    return true;
  }

  // LBRACKET RBRACKET
  private static boolean identifier_type_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier_type_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, LBRACKET, RBRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER (COMMA IDENTIFIER)*
  public static boolean invoke_argument_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_argument_list")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && invoke_argument_list_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, INVOKE_ARGUMENT_LIST, result_);
    return result_;
  }

  // (COMMA IDENTIFIER)*
  private static boolean invoke_argument_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_argument_list_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!invoke_argument_list_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "invoke_argument_list_1", pos_)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean invoke_argument_list_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_argument_list_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COMMA, IDENTIFIER);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER (IDENTIFIER DOT)? LANGLE invoke_method_ref RANGLE LPAREN invoke_argument_list? RPAREN
  public static boolean invoke_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_expr")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && invoke_expr_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LANGLE);
    result_ = result_ && invoke_method_ref(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, RANGLE, LPAREN);
    result_ = result_ && invoke_expr_6(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, INVOKE_EXPR, result_);
    return result_;
  }

  // (IDENTIFIER DOT)?
  private static boolean invoke_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_expr_1")) return false;
    invoke_expr_1_0(builder_, level_ + 1);
    return true;
  }

  // IDENTIFIER DOT
  private static boolean invoke_expr_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_expr_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, DOT);
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
  // IDENTIFIER COLON identifier_type IDENTIFIER LPAREN (identifier_type (COMMA identifier_type)*)? RPAREN
  public static boolean invoke_method_ref(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "invoke_method_ref")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, COLON);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, IDENTIFIER, LPAREN);
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
  // IDENTIFIER DOT LANGLE field_ref RANGLE
  //          | IDENTIFIER LBRACKET IDENTIFIER RBRACKET
  //          | IDENTIFIER
  public static boolean lvalue(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lvalue")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = lvalue_0(builder_, level_ + 1);
    if (!result_) result_ = parseTokens(builder_, 0, IDENTIFIER, LBRACKET, IDENTIFIER, RBRACKET);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, LVALUE, result_);
    return result_;
  }

  // IDENTIFIER DOT LANGLE field_ref RANGLE
  private static boolean lvalue_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lvalue_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, DOT, LANGLE);
    result_ = result_ && field_ref(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RANGLE);
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
  // TRY LBRACKET INTEGER COMMA INTEGER RPAREN COMMA CATCH IDENTIFIER AT INTEGER
  public static boolean method_body_catch(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_catch")) return false;
    if (!nextTokenIs(builder_, TRY)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, TRY, LBRACKET, INTEGER, COMMA, INTEGER, RPAREN, COMMA, CATCH, IDENTIFIER, AT, INTEGER);
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
  //                    | IDENTIFIER EQUAL NEW identifier_type
  //                    | IDENTIFIER EQUAL NEW_ARRAY identifier_type LBRACKET IDENTIFIER RBRACKET
  //                    | THROW identifier_type
  //                    | CATCH IDENTIFIER
  //                    | invoke_expr
  //                    | IF LPAREN (unary_expr | binary_expr | IDENTIFIER) RPAREN GOTO INTEGER
  //                    | GOTO INTEGER
  //                    | RETURN IDENTIFIER?
  public static boolean method_body_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, METHOD_BODY_STMT, "<method body stmt>");
    result_ = method_body_stmt_0(builder_, level_ + 1);
    if (!result_) result_ = method_body_stmt_1(builder_, level_ + 1);
    if (!result_) result_ = method_body_stmt_2(builder_, level_ + 1);
    if (!result_) result_ = method_body_stmt_3(builder_, level_ + 1);
    if (!result_) result_ = parseTokens(builder_, 0, CATCH, IDENTIFIER);
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

  // IDENTIFIER EQUAL NEW identifier_type
  private static boolean method_body_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, EQUAL, NEW);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // IDENTIFIER EQUAL NEW_ARRAY identifier_type LBRACKET IDENTIFIER RBRACKET
  private static boolean method_body_stmt_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, EQUAL, NEW_ARRAY);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, LBRACKET, IDENTIFIER, RBRACKET);
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

  // RETURN IDENTIFIER?
  private static boolean method_body_stmt_8(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_8")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RETURN);
    result_ = result_ && method_body_stmt_8_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // IDENTIFIER?
  private static boolean method_body_stmt_8_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt_8_1")) return false;
    consumeToken(builder_, IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // identifier_type identifier_list SEMICOLON
  public static boolean method_body_var(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_var")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier_type(builder_, level_ + 1);
    result_ = result_ && identifier_list(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, marker_, METHOD_BODY_VAR, result_);
    return result_;
  }

  /* ********************************************************** */
  // method_sig LBRACE method_body RBRACE
  public static boolean method_def(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_def")) return false;
    if (!nextTokenIs(builder_, "<method def>", IDENTIFIER, MODIFIER)) return false;
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
    if (!nextTokenIs(builder_, "<method sig>", IDENTIFIER, MODIFIER)) return false;
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
  // IDENTIFIER DOT LANGLE field_ref RANGLE
  //          | IDENTIFIER LBRACKET IDENTIFIER RBRACKET
  //          | LPAREN identifier_type RPAREN IDENTIFIER
  //          | invoke_expr
  //          | unary_expr
  //          | binary_expr
  //          | IDENTIFIER INSTANCEOF identifier_type
  //          | IDENTIFIER
  //          | FLOAT
  //          | INTEGER
  //          | STRING_LITERAL
  public static boolean rvalue(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rvalue")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RVALUE, "<rvalue>");
    result_ = rvalue_0(builder_, level_ + 1);
    if (!result_) result_ = parseTokens(builder_, 0, IDENTIFIER, LBRACKET, IDENTIFIER, RBRACKET);
    if (!result_) result_ = rvalue_2(builder_, level_ + 1);
    if (!result_) result_ = invoke_expr(builder_, level_ + 1);
    if (!result_) result_ = unary_expr(builder_, level_ + 1);
    if (!result_) result_ = binary_expr(builder_, level_ + 1);
    if (!result_) result_ = rvalue_6(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, FLOAT);
    if (!result_) result_ = consumeToken(builder_, INTEGER);
    if (!result_) result_ = consumeToken(builder_, STRING_LITERAL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // IDENTIFIER DOT LANGLE field_ref RANGLE
  private static boolean rvalue_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rvalue_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, DOT, LANGLE);
    result_ = result_ && field_ref(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RANGLE);
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

  // IDENTIFIER INSTANCEOF identifier_type
  private static boolean rvalue_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rvalue_6")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, INSTANCEOF);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // MODIFIER* CLASS IDENTIFIER class_extends? class_implements? LBRACE class_member* RBRACE
  static boolean tir_file(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "tir_file")) return false;
    if (!nextTokenIs(builder_, "", CLASS, MODIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = tir_file_0(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, CLASS, IDENTIFIER);
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
  // (ADD_OP | SUB_OP | NOT_OP) IDENTIFIER
  public static boolean unary_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unary_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, UNARY_EXPR, "<unary expr>");
    result_ = unary_expr_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
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
