// Lab3: LLVM IR Generator Template
// Language: Java 11 + ANTLR4 + LLVM
//
// In this lab, you will implement the basic structure for LLVM IR generation.
// Each step contains a TODO placeholder to be filled by students.

import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.javacpp.*;
import org.bytedeco.llvm.LLVM.*;
import java.io.IOException;
import java.util.*;
import static org.bytedeco.llvm.global.LLVM.*;

public class LLVMIRGenerator extends SysYParserBaseVisitor<LLVMValueRef> {
    // ===== Core LLVM components =====
    private LLVMModuleRef llvmModule;
    private LLVMBuilderRef irBuilder;
    private LLVMTypeRef int32Type;
    private LLVMTypeRef voidType;
    private LLVMTypeRef boolType;
    private LLVMValueRef zeroValue;
    private LLVMValueRef currentFunction;

    // ===== Symbol management =====
    private HashMap<String, LLVMValueRef> symbolTable;
    private HashMap<String, LLVMTypeRef> functionTypeMap;
    private boolean isGlobalScope = true;
    
    // ===== Control flow management =====
    private Stack<LLVMBasicBlockRef> continueBlockStack;
    private Stack<LLVMBasicBlockRef> breakBlockStack;

    // ===== Constructor: Initialize LLVM environment =====
    public LLVMIRGenerator() {        
        // TODO: Create module and builder
        llvmModule = /* TODO */;
        irBuilder = /* TODO */;

        // TODO: Initialize basic types
        int32Type = /* TODO */;
        voidType = /* TODO */;
        boolType = /* TODO */;
        zeroValue = /* TODO */;

        // TODO: Initialize data structures
        symbolTable = /* TODO */;
        functionTypeMap = /* TODO */;
        continueBlockStack = /* TODO */;
        breakBlockStack = /* TODO */;
    }

    // ===== Block handling =====
    @Override
    public LLVMValueRef visitBlock(SysYParser.BlockContext ctx) {
        // TODO: Handle block statements
        // Hint: Simply visit all child statements
        return /* TODO */;
    }

    // ===== Part 1: Expression handling =====
    @Override
    public LLVMValueRef visitExp(SysYParser.ExpContext ctx) {
        // TODO: Handle different types of expressions
        
        // Case 1: Unary operations (-, +, !)
        if (ctx.unaryOp() != null) {
            LLVMValueRef operand = /* TODO */;
            String operator = ctx.unaryOp().getText();
            
            switch (operator) {
                case "+":
                    return /* TODO */;
                case "-":
                    return /* TODO */; // Hint: LLVMBuildNeg
                case "!":
                    return /* TODO */; // Hint: logical NOT operation
                default:
                    throw new RuntimeException("Unsupported unary operator: " + operator);
            }
        }
        
        // Case 2: Binary operations (+, -, *, /, %)
        else if (ctx.exp().size() == 2) {
            LLVMValueRef left = /* TODO */;
            LLVMValueRef right = /* TODO */;
            String operator = /* TODO */; // Get the operator token
            
            switch (operator) {
                case "+":
                    return /* TODO */; // Hint: LLVMBuildAdd
                case "-":
                    return /* TODO */; // Hint: LLVMBuildSub
                case "*":
                    return /* TODO */; // Hint: LLVMBuildMul
                case "/":
                    return /* TODO */; // Hint: LLVMBuildSDiv
                case "%":
                    return /* TODO */; // Hint: LLVMBuildSRem
                default:
                    throw new RuntimeException("Unsupported binary operator: " + operator);
            }
        }
        
        // Case 3: Variable reference (lVal)
        else if (ctx.lVal() != null) {
            String varName = /* TODO */;
            // TODO: Load value from symbol table or global variables
            return /* TODO */;
        }
        
        // Case 4: Number literal
        else if (ctx.number() != null) {
            // TODO: Parse number (decimal, octal, hexadecimal)
            String numberStr = /* TODO */;
            long value = /* TODO */; // Parse considering different bases
            return /* TODO */; // Create LLVM constant
        }
        
        // Case 5: Function call
        else if (ctx.IDENT() != null) {
            // TODO: Handle function calls
            String funcName = /* TODO */;
            // TODO: Get function parameters and call function
            return /* TODO */;
        }
        
        // Case 6: Parenthesized expression
        else if (ctx.exp().size() == 1) {
            return /* TODO */;
        }

        return null;
    }

    // ===== Part 2: Variable and constant declarations =====
    @Override
    public LLVMValueRef visitConstDef(SysYParser.ConstDefContext ctx) {
        String constName = /* TODO */;
        
        if (isGlobalScope) {
            // TODO: Create global constant
            LLVMValueRef globalVar = /* TODO */; // LLVMAddGlobal
            LLVMValueRef initValue = /* TODO */;
            /* TODO */ // LLVMSetInitializer
        } else {
            // TODO: Create local constant
            LLVMValueRef localVar = /* TODO */; // LLVMBuildAlloca
            LLVMValueRef initValue = /* TODO */;
            /* TODO */ // LLVMBuildStore
            /* TODO */ // Add to symbol table
        }
        
        return null;
    }

    @Override
    public LLVMValueRef visitVarDef(SysYParser.VarDefContext ctx) {
        String varName = /* TODO */;
        
        if (isGlobalScope) {
            // TODO: Create global variable
            LLVMValueRef globalVar = /* TODO */;
            
            if (ctx.ASSIGN() != null) {
                // TODO: Handle initialization
                LLVMValueRef initValue = /* TODO */;
                /* TODO */ // Set initializer
            } else {
                // TODO: Initialize with zero
                /* TODO */;
            }
        } else {
            // TODO: Create local variable
            LLVMValueRef localVar = /* TODO */;
            
            if (ctx.ASSIGN() != null) {
                // TODO: Handle initialization
                /* TODO */;
            } else {
                // TODO: Initialize with zero
                /* TODO */;
            }
            
            // TODO: Add to symbol table
            /* TODO */;
        }
        
        return null;
    }

    // ===== Part 3: Function definitions =====
    @Override
    public LLVMValueRef visitFuncDef(SysYParser.FuncDefContext ctx) {
        // TODO: Switch to local scope
        isGlobalScope = /* TODO */;
        symbolTable = /* TODO */;

        // TODO: Determine return type
        LLVMTypeRef returnType = /* TODO */; // void or int32

        // TODO: Get function parameters
        int paramCount = /* TODO */;
        PointerPointer<Pointer> paramTypes = /* TODO */;
        
        // TODO: Create function type and function
        LLVMTypeRef funcType = /* TODO */; // LLVMFunctionType
        String funcName = /* TODO */;
        LLVMValueRef function = /* TODO */; // LLVMAddFunction

        // TODO: Create entry basic block
        LLVMBasicBlockRef entryBlock = /* TODO */; // LLVMAppendBasicBlock
        /* TODO */; // LLVMPositionBuilderAtEnd

        // TODO: Handle function parameters
        for (int i = 0; i < paramCount; i++) {
            String paramName = /* TODO */;
            LLVMValueRef paramAlloca = /* TODO */; // LLVMBuildAlloca
            /* TODO */; // LLVMBuildStore parameter value
            /* TODO */; // Add to symbol table
        }

        // TODO: Store function information
        functionTypeMap.put(funcName, funcType);
        currentFunction = function;

        // TODO: Visit function body
        /* TODO */;

        // TODO: Add default return if needed
        if (/* void function */) {
            /* TODO */; // LLVMBuildRetVoid
        } else {
            /* TODO */; // LLVMBuildRet with zero
        }

        // TODO: Reset to global scope
        isGlobalScope = /* TODO */;
        symbolTable = /* TODO */;
        currentFunction = /* TODO */;
        
        return null;
    }

    // ===== Part 4: Control flow statements =====
    @Override
    public LLVMValueRef visitCond(SysYParser.CondContext ctx) {
        // TODO: Handle conditions with proper short-circuit evaluation
        
        if (ctx.exp() != null) {
            // Simple expression condition
            return /* TODO */;
        }
        
        // TODO: Handle logical AND with short-circuit
        if (ctx.AND() != null) {
            // TODO: Implement short-circuit AND
            return /* TODO */;
        }
        
        // TODO: Handle logical OR with short-circuit  
        if (ctx.OR() != null) {
            // TODO: Implement short-circuit OR
            return /* TODO */;
        }
        
        // TODO: Handle comparison operators
        LLVMValueRef left = /* TODO */;
        LLVMValueRef right = /* TODO */;
        
        if (ctx.LT() != null) return /* TODO */; // LLVMBuildICmp with LLVMIntSLT
        if (ctx.GT() != null) return /* TODO */; // LLVMBuildICmp with LLVMIntSGT
        if (ctx.LE() != null) return /* TODO */; // LLVMBuildICmp with LLVMIntSLE
        if (ctx.GE() != null) return /* TODO */; // LLVMBuildICmp with LLVMIntSGE
        if (ctx.EQ() != null) return /* TODO */; // LLVMBuildICmp with LLVMIntEQ
        if (ctx.NEQ() != null) return /* TODO */; // LLVMBuildICmp with LLVMIntNE
        
        return null;
    }

    @Override
    public LLVMValueRef visitStmt(SysYParser.StmtContext ctx) {
        // Case 1: Assignment statement
        if (ctx.ASSIGN() != null) {
            // TODO: Handle assignment
            String varName = /* TODO */;
            LLVMValueRef value = /* TODO */;
            LLVMValueRef varPtr = /* TODO */; // Get variable pointer
            /* TODO */; // LLVMBuildStore
            return null;
        }
        
        // Case 2: Return statement
        else if (ctx.RETURN() != null) {
            if (ctx.exp() != null) {
                // TODO: Return with value
                LLVMValueRef returnValue = /* TODO */;
                /* TODO */; // LLVMBuildRet
            } else {
                // TODO: Return void
                /* TODO */; // LLVMBuildRetVoid
            }
            return null;
        }
        
        // Case 3: If statement (potentially with else-if and else)
        else if (!ctx.IF().isEmpty()) {
            // TODO: Handle if-else-if-else chain
            // Hint: Create basic blocks for each condition and branch
            return null;
        }
        
        // Case 4: While loop
        else if (ctx.WHILE() != null) {
            // TODO: Create loop basic blocks
            LLVMBasicBlockRef condBlock = /* TODO */;
            LLVMBasicBlockRef bodyBlock = /* TODO */;
            LLVMBasicBlockRef exitBlock = /* TODO */;
            
            // TODO: Manage break/continue stacks
            /* TODO */;
            
            // TODO: Implement loop logic
            
            // TODO: Clean up stacks
            /* TODO */;
            
            return null;
        }
        
        // Case 5: Break statement
        else if (ctx.BREAK() != null) {
            // TODO: Jump to break block
            return null;
        }
        
        // Case 6: Continue statement  
        else if (ctx.CONTINUE() != null) {
            // TODO: Jump to continue block
            return null;
        }

        return super.visitStmt(ctx);
    }

    // ===== Utility methods =====
    
    /**
     * Output the generated LLVM IR to a file
     */
    public void printToFile(String filename) throws IOException {
        // TODO: Use LLVMPrintModuleToFile to output IR
        BytePointer error = new BytePointer((Pointer) null);
        if (/* TODO: call LLVMPrintModuleToFile */ != 0) {
            String errorMsg = error.getString();
            LLVMDisposeMessage(error);
            throw new IOException("Failed to write LLVM IR: " + errorMsg);
        }
    }

    /**
     * Clean up LLVM resources
     */
    public void dispose() {
        // TODO: Dispose builder and module
        /* TODO */; // LLVMDisposeBuilder
        /* TODO */; // LLVMDisposeModule
    }
}
