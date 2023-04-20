package madeby.common.commands;

import madeby.common.data.data_class.Vehicle;
import madeby.common.util.CollectionManager;
import madeby.common.util.InputManager;
import madeby.common.util.OutputManager;
import madeby.common.util.VehicleCreator;

public class UpdateCommand extends Command {
    private final CollectionManager collectionManager;
    private final InputManager inputManager;
    private final OutputManager outputManager;

    public UpdateCommand(CollectionManager collectionManager, InputManager inputManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Integer id;
        try {
            id = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return new CommandResult("Your argument was incorrect. The command was not executed.");
        }
        if (collectionManager.containsId(id)) {
            Vehicle vehicle = VehicleCreator.createVehicle(inputManager, outputManager, collectionManager);
            collectionManager.update(vehicle, id);
            return new CommandResult("Vehicle update");
        }
        return new CommandResult("haven't id in collection");
    }
}
