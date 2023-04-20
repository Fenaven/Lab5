package madeby.common.commands;

import madeby.common.Exception.DoubleExecuteException;
import madeby.common.util.InputManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExecuteScriptCommand extends Command {
    private List<String> args;
    private final InputManager inputManager;

    public ExecuteScriptCommand(InputManager inputManager) {
        this.inputManager = inputManager;
        args = new ArrayList<>();
    }

    @Override
    public CommandResult execute(String arg) {
        try {
            if (!inputManager.getCheckReg()) {
                args.clear();
            }
            if (args.contains(arg)) {
                return new CommandResult("recursive");
            }
            args.add(arg);
            inputManager.connectToFile(new File(arg));
            return new CommandResult("Starting to execute script...");
        } catch (IOException e) {
            return new CommandResult("There was a problem opening the file. Check if it is available and you have written it in the command arg correctly.");
        } catch (DoubleExecuteException e) {
            return new CommandResult(e.getMessage());
        }
    }
}
