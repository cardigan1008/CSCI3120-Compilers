import org.antlr.v4.runtime.*;

public class MyErrorListener2 extends BaseErrorListener {
    // Step 0: Track whether errors occurred
    private boolean hasErrors = /* TODO */;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                            int charPositionInLine, String msg, RecognitionException e) {
        // Step 1: Print error in the format:
        //   Error type B at Line <line>:<msg>
        /* TODO */

        // Step 2: Mark that errors exist
        /* TODO */
    }

    // Step 3: Return whether errors exist
    public boolean hasErrors() {
        /* TODO */
    }
}
