package madeby.common.commands;

import madeby.common.util.CollectionManager;

public class RemoveFirstCommand extends Command {
    private CollectionManager collectionManager;

    public RemoveFirstCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        if (collectionManager.isEmpty()) {
            return new CommandResult("collection is empty");
        }
        collectionManager.removeFirst();
        return new CommandResult("success delete");
    }

}
