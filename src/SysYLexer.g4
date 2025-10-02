// Note: You can simply reuse the SysYLexer you wrote in Lab1.
// If needed, you may copy and replace it here.

lexer grammar SysYLexer;

// Step 1: Define keywords
CONST    : 'const';
INT      : 'int';
VOID     : 'void';
IF       : 'if';
ELSE     : 'else';
WHILE    : 'while';
BREAK    : 'break';
CONTINUE : 'continue';
RETURN   : 'return';

// Step 2: Define operators
PLUS   : '+';
MINUS  : '-';
MUL    : '*';
DIV    : '/';
MOD    : '%';
ASSIGN : '=';

// Step 3: Define comparison operators
EQ   : '==';
NEQ  : '!=';
LT   : '<';
GT   : '>';
LE   : '<='; 
GE   : '>=';

// Step 4: Define logical operators
NOT : '!';
AND : '&&';
OR  : '||';

// Step 5: Define punctuation
L_PAREN   : '(';
R_PAREN   : ')';
L_BRACE   : '{';
R_BRACE   : '}';
L_BRACKT  : /* TODO: left square bracket */;
R_BRACKT  : /* TODO: right square bracket */;
COMMA     : ',';
SEMICOLON : ';';

// Step 6: Identifiers
// Hint: start with a letter or '_', followed by letters, digits, or '_'
IDENT : /* TODO */;

// Step 7: Integer constants
// Hint: include decimal, octal, and hex
INTEGER_CONST
    : '0'
    | [1-9][0-9]*
    | /* TODO: octal */
    | /* TODO: hex */
    ;

// Step 8: Whitespace and comments (skip them)

// Task 1: Match whitespace (space, tab, newline, etc.) and skip
WS : /* TODO */ -> skip;

// Task 2: Match single-line comments starting with '//' until newline
LINE_COMMENT : /* TODO */ -> skip;

// Task 3: Match multi-line comments between '/*' and '*/'
MULTILINE_COMMENT : /* TODO */ -> skip;
