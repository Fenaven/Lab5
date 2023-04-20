package madeby.common.commands;

import madeby.common.util.CollectionManager;
import madeby.common.util.InputManager;
import madeby.common.util.OutputManager;

public class RemoveByIdCommand extends Command {
    private final CollectionManager collectionManager;
    private final InputManager inputManager;
    private final OutputManager outputManager;

    public RemoveByIdCommand(CollectionManager collectionManager, InputManager inputManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        int id;
        try {
            id = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return new CommandResult("Your argument was incorrect. The command was not executed.");
        }
        if (collectionManager.removeByID(id)) {
            return new CommandResult("remove success");
        }
        return new CommandResult("haven't id in collection");
    }
}
