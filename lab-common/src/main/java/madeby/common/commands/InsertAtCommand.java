package madeby.common.commands;

import madeby.common.util.CollectionManager;
import madeby.common.util.InputManager;
import madeby.common.util.OutputManager;
import madeby.common.util.VehicleCreator;

public class InsertAtCommand extends Command {
    private final CollectionManager collectionManager;
    private final InputManager inputManager;
    private final OutputManager outputManager;

    public InsertAtCommand(CollectionManager collectionManager, InputManager inputManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Integer index;
        try {
            index = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return new CommandResult("Your argument was incorrect. The command was not executed.");
        }
        if (collectionManager.checkIndex(index)) {
            collectionManager.insertAt(VehicleCreator.createVehicle(inputManager, outputManager, collectionManager), index);
            return new CommandResult("insert success");
        }
        return new CommandResult("Out of range");
    }
}
