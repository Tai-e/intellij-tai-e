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
IDENTIFIER_CHARACTER=[a-zA-Z$_%][a-zA-Z0-9$_]*

%state WAITING_VALUE

%%

// --- Modifiers ---
public            { yybegin(YYINITIAL); return TirTypes.PUBLIC; }

protected         { yybegin(YYINITIAL); return TirTypes.PROTECTED; }

private           { yybegin(YYINITIAL); return TirTypes.PRIVATE; }

abstract          { yybegin(YYINITIAL); return TirTypes.ABSTRACT; }

static            { yybegin(YYINITIAL); return TirTypes.STATIC; }

final             { yybegin(YYINITIAL); return TirTypes.FINAL; }

sealed            { yybegin(YYINITIAL); return TirTypes.SEALED; }

non-sealed        { yybegin(YYINITIAL); return TirTypes.NON_SEALED; }

strictfp          { yybegin(YYINITIAL); return TirTypes.STRICTFP; }

transient         { yybegin(YYINITIAL); return TirTypes.TRANSIENT; }

volatile          { yybegin(YYINITIAL); return TirTypes.VOLATILE; }

synchronized      { yybegin(YYINITIAL); return TirTypes.SYNCHRONIZED; }

native            { yybegin(YYINITIAL); return TirTypes.NATIVE; }

synthetic         { yybegin(YYINITIAL); return TirTypes.SYNTHETIC; }
// -----------------

// --- Invoke ---
invokespecial     { yybegin(YYINITIAL); return TirTypes.INVOKE_SPECIAL; }

invokestatic      { yybegin(YYINITIAL); return TirTypes.INVOKE_STATIC; }

invokedynamic     { yybegin(YYINITIAL); return TirTypes.INVOKE_DYNAMIC; }

invokevirtual     { yybegin(YYINITIAL); return TirTypes.INVOKE_VIRTUAL; }

invokeinterface   { yybegin(YYINITIAL); return TirTypes.INVOKE_INTERFACE; }
// --------------

interface                                                               { yybegin(YYINITIAL); return TirTypes.INTERFACE; }

class                                                                   { yybegin(YYINITIAL); return TirTypes.CLASS; }

extends                                                                 { yybegin(YYINITIAL); return TirTypes.EXTENDS; }

implements                                                              { yybegin(YYINITIAL); return TirTypes.IMPLEMENTS; }

if                                                                      { yybegin(YYINITIAL); return TirTypes.IF; }

goto                                                                    { yybegin(YYINITIAL); return TirTypes.GOTO; }

nop                                                                     { yybegin(YYINITIAL); return TirTypes.NOP; }

new                                                                     { yybegin(YYINITIAL); return TirTypes.NEW; }

newarray                                                                { yybegin(YYINITIAL); return TirTypes.NEW_ARRAY; }

newmultiarray                                                           { yybegin(YYINITIAL); return TirTypes.NEW_MULTI_ARRAY; }

try                                                                     { yybegin(YYINITIAL); return TirTypes.TRY; }

throw                                                                   { yybegin(YYINITIAL); return TirTypes.THROW; }

catch                                                                   { yybegin(YYINITIAL); return TirTypes.CATCH; }

at                                                                      { yybegin(YYINITIAL); return TirTypes.AT; }

lookupswitch                                                            { yybegin(YYINITIAL); return TirTypes.LOOKUP_SWITCH; }

\-\>                                                                    { yybegin(YYINITIAL); return TirTypes.RIGHT_ARROW; }

default                                                                 { yybegin(YYINITIAL); return TirTypes.DEFAULT; }

return                                                                  { yybegin(YYINITIAL); return TirTypes.RETURN; }

monitorenter                                                            { yybegin(YYINITIAL); return TirTypes.MONITOR_ENTER; }

monitorexit                                                             { yybegin(YYINITIAL); return TirTypes.MONITOR_EXIT; }

instanceof                                                              { yybegin(YYINITIAL); return TirTypes.INSTANCEOF; }

null-type                                                               { yybegin(YYINITIAL); return TirTypes.NULL_TYPE; }

null                                                                    { yybegin(YYINITIAL); return TirTypes.NULL; }

// TODO: avoid conflict
MethodType                                                              { yybegin(YYINITIAL); return TirTypes.METHOD_TYPE; }

MethodHandle                                                            { yybegin(YYINITIAL); return TirTypes.METHOD_HANDLE; }

,                                                                       { yybegin(YYINITIAL); return TirTypes.COMMA; }

:                                                                       { yybegin(YYINITIAL); return TirTypes.COLON; }

;                                                                       { yybegin(YYINITIAL); return TirTypes.SEMICOLON; }

(\+|-)?\d+\.\d*F                                                        { yybegin(YYINITIAL); return TirTypes.FLOAT; }

(\+|-)?\d+\.\d*                                                         { yybegin(YYINITIAL); return TirTypes.DOUBLE; }

(\+|-)?\d+L                                                             { yybegin(YYINITIAL); return TirTypes.LONG; }

(\+|-)?\d+                                                              { yybegin(YYINITIAL); return TirTypes.INTEGER; }

\"([^\"\\]|\\.)*\"                                                      { yybegin(YYINITIAL); return TirTypes.STRING; }

\+                                                                      { yybegin(YYINITIAL); return TirTypes.ADD_OP; }

\-                                                                      { yybegin(YYINITIAL); return TirTypes.SUB_OP; }

\*                                                                      { yybegin(YYINITIAL); return TirTypes.MUL_OP; }

\/                                                                      { yybegin(YYINITIAL); return TirTypes.DIV_OP; }

\%                                                                      { yybegin(YYINITIAL); return TirTypes.MOD_OP; }

==|\!=|<=|>=|cmpg                                                       { yybegin(YYINITIAL); return TirTypes.CMP_OP; }

\<\<|\>\>|\>\>\>|\<\<\<|\||\&|\^|\~                                     { yybegin(YYINITIAL); return TirTypes.BIT_OP; }

\!                                                                      { yybegin(YYINITIAL); return TirTypes.NOT_OP; }

=                                                                       { yybegin(YYINITIAL); return TirTypes.EQUAL; }

\.                                                                      { yybegin(YYINITIAL); return TirTypes.DOT; }

\(                                                                      { yybegin(YYINITIAL); return TirTypes.LPAREN; }

\)                                                                      { yybegin(YYINITIAL); return TirTypes.RPAREN; }

\[                                                                      { yybegin(YYINITIAL); return TirTypes.LBRACKET; }

\]                                                                      { yybegin(YYINITIAL); return TirTypes.RBRACKET; }

\<                                                                      { yybegin(YYINITIAL); return TirTypes.LANGLE; }

\>                                                                      { yybegin(YYINITIAL); return TirTypes.RANGLE; }

\{                                                                      { yybegin(YYINITIAL); return TirTypes.LBRACE; }

\}                                                                      { yybegin(YYINITIAL); return TirTypes.RBRACE; }

\[\d+@L\d*-?\d+\]                                                       { yybegin(YYINITIAL); return TirTypes.LINE_NUMBER; }

<YYINITIAL> {END_OF_LINE_COMMENT}                                       { yybegin(YYINITIAL); return TirTypes.COMMENT; }

<YYINITIAL> \%{IDENTIFIER_CHARACTER}                                    { yybegin(YYINITIAL); return TirTypes.CONSTANT_IDENTIFIER; }

<YYINITIAL> {IDENTIFIER_CHARACTER}(\.{IDENTIFIER_CHARACTER})*           { yybegin(YYINITIAL); return TirTypes.IDENTIFIER; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+                           { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                                          { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                                 { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                                     { return TokenType.BAD_CHARACTER; }
