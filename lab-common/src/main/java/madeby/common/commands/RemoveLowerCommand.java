package madeby.common.commands;

import madeby.common.util.CollectionManager;
import madeby.common.util.InputManager;
import madeby.common.util.OutputManager;
import madeby.common.util.VehicleCreator;

public class RemoveLowerCommand extends Command {
    private final CollectionManager collectionManager;
    private final InputManager inputManager;
    private final OutputManager outputManager;

    public RemoveLowerCommand(CollectionManager collectionManager, InputManager inputManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Long count = collectionManager.removeLower(VehicleCreator.createVehicle(inputManager, outputManager, collectionManager));
        return new CommandResult("remove " + count.toString());
    }
}
