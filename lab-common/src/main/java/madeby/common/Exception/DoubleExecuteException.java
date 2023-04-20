package madeby.common.Exception;

public class DoubleExecuteException extends UnsupportedOperationException {
    public DoubleExecuteException() {
        super("The file was not executed due to recursion");
    }
}
