package madeby.common.commands;

import madeby.common.util.CollectionManager;

public class PrintDescendingCommand extends Command {
    private final CollectionManager collectionManager;

    public PrintDescendingCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        if (collectionManager.isEmpty()) {
            return new CommandResult("collection empty");
        }
        return new CommandResult(collectionManager.printDescending().toString());
    }
}
