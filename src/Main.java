// Lab3: LLVM IR Code Generation
// Language: Java 11 + ANTLR4 + LLVM
//
// In this lab, you will implement an LLVM IR generator for SysY.
// Each step contains a TODO placeholder to be filled by students.

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.bytedeco.javacpp.BytePointer;
import java.io.IOException;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;

public class Main {
    public static final BytePointer error = new BytePointer();
    
    public static void main(String[] args) throws IOException {
        // Step 0: Check command line arguments
        if (args.length < 2) {
            System.err.println("Usage: java Main <input_file> <output_file>");
            return;
        }
        
        String inputFile = args[0];
        String outputFile = args[1];

        // Step 1: Initialize LLVM core components
        /* TODO: Initialize LLVM core, MCJIT, native target, etc. */
        
        // Step 2: Load the source file into a CharStream
        CharStream input = /* TODO */;

        // Step 3: Create lexer and parser
        SysYLexer sysYLexer = /* TODO */;
        CommonTokenStream tokens = /* TODO */;
        SysYParser sysYParser = /* TODO */;

        // Step 4: Parse the program to get the syntax tree
        ParseTree tree = /* TODO */;

        // Step 5: Create LLVM IR generator and visit the parse tree
        LLVMIRGenerator llvmVisitor = /* TODO */;
        /* TODO */ // visit the tree

        // Step 6: Output the generated LLVM IR to file
        /* TODO */ // print to file

        // Step 7: Clean up resources
        /* TODO */ // dispose resources
    }
}
