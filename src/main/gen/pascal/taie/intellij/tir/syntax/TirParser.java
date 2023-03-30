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
  // MODIFIER* identifier_type identifier_list SEMICOLON
  public static boolean field_def(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "field_def")) return false;
    if (!nextTokenIs(builder_, "<field def>", IDENTIFIER, MODIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FIELD_DEF, "<field def>");
    result_ = field_def_0(builder_, level_ + 1);
    result_ = result_ && identifier_type(builder_, level_ + 1);
    result_ = result_ && identifier_list(builder_, level_ + 1);
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
  // (method_body_var | method_body_line)+
  public static boolean method_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body")) return false;
    if (!nextTokenIs(builder_, "<method body>", IDENTIFIER, LINE_NUMBER)) return false;
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

  // method_body_var | method_body_line
  private static boolean method_body_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_0")) return false;
    boolean result_;
    result_ = method_body_var(builder_, level_ + 1);
    if (!result_) result_ = method_body_line(builder_, level_ + 1);
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
  // IDENTIFIER EQUAL IDENTIFIER
  public static boolean method_body_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "method_body_stmt")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, EQUAL, IDENTIFIER);
    exit_section_(builder_, marker_, METHOD_BODY_STMT, result_);
    return result_;
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

}
