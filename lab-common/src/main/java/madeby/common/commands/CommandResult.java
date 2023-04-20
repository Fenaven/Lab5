package madeby.common.commands;

public class CommandResult {
    private final String result;
    private final boolean exit;

    public CommandResult(String result) {
        this.result = result;
        this.exit = false;
    }

    public CommandResult(String result, boolean exit) {
        this.result = result;
        this.exit = exit;
    }

    public String getResult() {
        return result;
    }

    public boolean isExit() {
        return exit;
    }
}
