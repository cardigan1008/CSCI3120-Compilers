// Note: You can simply reuse the SysYLexer you wrote in Lab2.
// If needed, you may copy and replace it here.

parser grammar SysYParser;

options {
    tokenVocab = SysYLexer; 
}

// ===== Root rule =====
program
    : compUnit
    ;

// ===== Compilation unit =====
compUnit
    : /* TODO: sequence of decl or funcDef, ending with EOF */
    ;

// ===== Declarations =====
decl
    : constDecl
    | varDecl
    ;

// ===== Constant declaration =====
constDecl
    : CONST bType /* TODO: constDef list */ SEMICOLON
    ;

// ===== Basic type =====
bType
    : INT
    ;

// ===== Constant definition =====
constDef
    : /* TODO: Ident, optional dimensions, '=', constInitVal */
    ;

// ===== Constant initial value =====
constInitVal
    : /* TODO: constExp or '{' ... '}' */
    ;

// ===== Variable declaration =====
varDecl
    : bType /* TODO: varDef list */ SEMICOLON
    ;

// ===== Variable definition =====
varDef
    : /* TODO: Ident with optional array size and optional init */
    ;

// ===== Variable initial value =====
initVal
    : /* TODO: exp or '{' ... '}' */
    ;

// ===== Function definition =====
funcDef
    : /* TODO: funcType Ident '(' optional params ')' block */
    ;

// ===== Function type =====
funcType
    : VOID
    | INT
    ;

// ===== Function parameter list =====
funcFParams
    : /* TODO: funcFParam list */
    ;

// ===== Function parameter =====
funcFParam
    : /* TODO: bType Ident, with optional array dimensions */
    ;

// ===== Block =====
block
    : L_BRACE /* TODO: blockItem* */ R_BRACE
    ;

// ===== Block item =====
blockItem
    : decl
    | stmt
    ;

// ===== Statement =====
stmt
    : /* TODO: assignment | exp ';' | block | if/else | while | break/continue | return */
    ;

// ===== Expressions =====
exp
    : /* TODO: primary, unary, binary, function call, parentheses */
    ;

cond
    : /* TODO: relational and logical combinations */
    ;

lVal
    : /* TODO: Ident with optional indices */
    ;

number
    : INTEGER_CONST
    ;

unaryOp
    : PLUS
    | MINUS
    | NOT
    ;

// ===== Function real parameters =====
funcRParams
    : /* TODO: param list */
    ;

param
    : exp
    ;

// ===== Constant expression =====
constExp
    : exp
    ;
