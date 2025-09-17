// Lab1: SysY Lexer
// Language: Java 11 + ANTLR4
// === Students should complete all TODOs ===

import org.antlr.v4.runtime.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("input path is required");
        }
        String source = args[0];

        // === TODO: read source file into CharStream ===

        // === TODO: create SysYLexer ===

        // === TODO: 1. remove default error listeners ===
        // === TODO: 2. attach your own error listener (MyErrorListener) ===

        // === TODO: get all tokens ===

        // === TODO: 1. if errors exist, stop here (errors already printed) ===
        // === TODO: 2. otherwise, iterate tokens and print each one ===
        
    }

    /**
     * Print token in format:
     *   <TOKEN_TYPE> <TEXT> at Line <LINE>.
     * 
     * Special rule: if token type is INTEGER_CONST,
     * normalize oct/hex into decimal string before printing.
     */
    private static void printSysYTokenInformation(Token token, SysYLexer lexer) {
        // === TODO: map token type to rule name ===
        // === TODO: get line number and token text ===
        // === TODO: handle INTEGER_CONST normalization (call convertIntegerConst) ===
        // === TODO: print to System.err in the required format ===
    }

    /**
     * Convert integer constant to decimal string when needed.
     * Examples: "0x10" -> "16", "077" -> "63"
     */
    private static String convertIntegerConst(String text) {
        // === TODO: implement conversion for hex and octal ===
        return text; // placeholder
    }
}
