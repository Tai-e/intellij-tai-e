package pascal.taie.intellij.tir.syntax;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import pascal.taie.intellij.tir.syntax.TirTypes;

%%

%class TirLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
END_OF_LINE_COMMENT=("//")[^\r\n]*

//KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "
//FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
//VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
IDENTIFIER_CHARACTER=[a-zA-Z$_%][a-zA-Z0-9$_\-]*

%state WAITING_VALUE

%%

final|static|public|private|protected|transient|volatile              { yybegin(YYINITIAL); return TirTypes.MODIFIER; }

class                                                                 { yybegin(YYINITIAL); return TirTypes.CLASS; }

extends                                                               { yybegin(YYINITIAL); return TirTypes.EXTENDS; }

implements                                                            { yybegin(YYINITIAL); return TirTypes.IMPLEMENTS; }

,                                                                     { yybegin(YYINITIAL); return TirTypes.COMMA; }

;                                                                     { yybegin(YYINITIAL); return TirTypes.SEMICOLON; }

=                                                                     { yybegin(YYINITIAL); return TirTypes.EQUAL; }

\(                                                                    { yybegin(YYINITIAL); return TirTypes.LPAREN; }

\)                                                                    { yybegin(YYINITIAL); return TirTypes.RPAREN; }

\[                                                                    { yybegin(YYINITIAL); return TirTypes.LBRACKET; }

\]                                                                    { yybegin(YYINITIAL); return TirTypes.RBRACKET; }

\{                                                                    { yybegin(YYINITIAL); return TirTypes.LBRACE; }

\}                                                                    { yybegin(YYINITIAL); return TirTypes.RBRACE; }

\[\d+@L\d*-?\d+\]                                                     { yybegin(YYINITIAL); return TirTypes.LINE_NUMBER; }

<YYINITIAL> {END_OF_LINE_COMMENT}                                     { yybegin(YYINITIAL); return TirTypes.COMMENT; }

<YYINITIAL> {IDENTIFIER_CHARACTER}(\.{IDENTIFIER_CHARACTER})*         { yybegin(YYINITIAL); return TirTypes.IDENTIFIER; }

<YYINITIAL> \<{IDENTIFIER_CHARACTER}\>                                { yybegin(YYINITIAL); return TirTypes.IDENTIFIER; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+                         { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                                        { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                                   { return TokenType.BAD_CHARACTER; }
