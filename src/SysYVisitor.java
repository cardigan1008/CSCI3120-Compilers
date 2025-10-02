import org.antlr.v4.runtime.tree.*;

public class SysYVisitor extends SysYParserBaseVisitor<Void> {
    private int indentLevel = 0;
    private StringBuilder output = new StringBuilder();

    // ===== Helper methods for formatting =====
    private String getIndent() {
        return " ".repeat(indentLevel * 4);
    }

    private void addLine(String line) {
        output.append(getIndent()).append(line).append("\n");
    }

    private void addLineWithoutIndent(String line) {
        output.append(line).append("\n");
    }

    private void addSpace() {
        output.append(" ");
    }

    private void addNewLine() {
        output.append("\n");
    }

    private void addIndent() {
        output.append(getIndent());
    }

    private void addToken(String token) {
        output.append(token);
    }

    // ===== Example methods for reference =====
    @Override
    public Void visitBType(SysYParser.BTypeContext ctx) {
        addToken(ctx.getText());
        return null;
    }

    @Override
    public Void visitFuncType(SysYParser.FuncTypeContext ctx) {
        addToken(ctx.getText());
        return null;
    }

    // ===== You should implement the following methods =====
    // - visitProgram / visitCompUnit
    // - visitDecl / visitConstDecl / visitVarDecl
    // - visitFuncDef / visitFuncFParams / visitFuncFParam
    // - visitBlock / visitBlockItem / visitStmt
    // - visitExp / visitCond / visitLVal / visitNumber / visitUnaryOp
    //
    // Guidelines:
    //   * Use addToken() to append symbols or keywords.
    //   * Use addNewLine(), addIndent(), and indentLevel++/-- to manage indentation.
    //   * Apply formatting rules from the lab specification:
    //       - one statement per line
    //       - spaces around binary operators
    //       - no spaces for unary operators
    //       - braces formatting rules as described

    // ===== Final result =====
    public String getFormattedCode() {
        return output.toString();
    }
}
