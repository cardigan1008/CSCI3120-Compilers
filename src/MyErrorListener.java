import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;

public class MyErrorListener extends BaseErrorListener {
    private boolean hasError;

    public MyErrorListener() {
        hasError = false;
    }

    public boolean hasError() {
        return hasError;
    }

    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg,
            RecognitionException e) {

        // Step 1: Mark that an error has occurred
        /* TODO */

        // Step 2: Print the error message in the required format
        // Example format: "Error type A at Line <line>: error."
        /* TODO */
    }
}
