// Lab1: SysY Lexer
// Language: Java 11 + ANTLR4
//
// In this lab, you will implement a simple lexer for the SysY language.
// Each function contains its own step-by-step tasks. 
// Fill in the missing parts where indicated.

import org.antlr.v4.runtime.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Input path is required.");
        }
        String source = args[0];

        // Step 1: Load the source file into a CharStream
        // Hint: check available CharStreams APIs
        CharStream input = /* TODO */;

        // Step 2: Create a SysYLexer instance with the CharStream
        SysYLexer sysYLexer = /* TODO */;

        // Step 3: Remove default error listeners and attach your own MyErrorListener
        /* TODO */

        // Step 4: Retrieve all tokens from the lexer
        List<? extends Token> myTokens = /* TODO */;

        // Step 5: If errors exist, stop execution. Otherwise, print all tokens.
        // Hint1: check MyErrorListener for error tracking
        // Hint2: call your printSysYTokenInformation function to print each token
        /* TODO */
    }

    /**
     * Print token in the format:
     *   <TOKEN_TYPE> <TEXT> at Line <LINE>.
     *
     * Special case:
     *   If the token type is INTEGER_CONST,
     *   normalize octal/hex values into decimal form before printing.
     */
    private static void printSysYTokenInformation(Token token, SysYLexer sysYLexer) {
        // Step 1: Map token type to its rule name
        String ruleName = /* TODO */;

        // Step 2: Get line number and token text
        int line = /* TODO */;
        String text = /* TODO */;

        // Step 3: Normalize INTEGER_CONST if needed
        if (ruleName.equals("INTEGER_CONST")) {
            text = convertIntegerConst(text);
        }

        // Step 4: Print the token information
        /* TODO */
    }

    /**
     * Convert integer constants to decimal string.
     * Examples:
     *   "0x10" -> "16"
     *   "077"  -> "63"
     */
    private static String convertIntegerConst(String text) {
        // Step 1: Check if the string starts with "0x" or "0X"
        /* TODO */

        // Step 2: Otherwise, check if it starts with "0" (octal case)
        /* TODO */

        // Step 3: If neither, return as is
        /* TODO */
        return text; // placeholder
    }
}
