package madeby.common.commands;

import madeby.common.util.CollectionManager;

public class SumOfDistanceTravelledCommand extends Command {
    private final CollectionManager collectionManager;

    public SumOfDistanceTravelledCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        if (collectionManager.isEmpty()) {
            return new CommandResult("empty collection");
        }
        return new CommandResult("result = " + collectionManager.sumOfDistanceTravelled().toString());
    }
}
