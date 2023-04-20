package madeby.common.commands;

import madeby.common.util.CollectionManager;

public class FilterStartsWithNameCommand extends Command {
    private final CollectionManager collectionManager;

    public FilterStartsWithNameCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        if (collectionManager.isEmpty()) {
            return new CommandResult("collection empty");
        }
        if ("".equals(arg)) {
            return new CommandResult("arg empty");
        }
        return new CommandResult(collectionManager.filterStartsWithName(arg).toString());
    }
}
