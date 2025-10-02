// Lab2: SysY Parser
// Language: Java 11 + ANTLR4
//
// In this lab, you will implement a parser and code formatter for SysY.
// Each step contains a TODO placeholder to be filled by students.

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class Main {
    // Step 0: Create custom error listeners for lexer and parser
    private static final MyErrorListener myErrorListener = /* TODO */;
    private static final MyErrorListener2 myErrorListener2 = /* TODO */;

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("input path is required");
            return;
        }
        String source = args[0];

        // Step 1: Load the source file into a CharStream
        CharStream input = /* TODO */;

        // Step 2: Create a SysYLexer instance with the CharStream
        SysYLexer sysYLexer = /* TODO */;

        // Step 3: Remove default error listeners and attach your MyErrorListener
        /* TODO */

        // Step 4: Create a CommonTokenStream with the lexer
        CommonTokenStream tokens = /* TODO */;

        // Step 5: Create a SysYParser instance with the token stream
        SysYParser sysYParser = /* TODO */;

        // Step 6: Remove default error listeners and attach your MyErrorListener2
        /* TODO */

        // Step 7: Parse the program to get the syntax tree
        SysYParser.ProgramContext tree = /* TODO */;

        // Step 8: If syntax errors exist, stop here (MyErrorListener2 already prints them)
        if (/* TODO */) {
            // do nothing
        } else {
            // Step 9: Otherwise, visit the parse tree with SysYVisitor to format code
            SysYVisitor visitor = /* TODO */;
            /* TODO */ // traverse the tree
            String formattedCode = /* TODO */;
            System.out.println(formattedCode);
        }
    }
}
