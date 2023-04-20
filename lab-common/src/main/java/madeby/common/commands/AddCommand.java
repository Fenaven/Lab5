package madeby.common.commands;

import madeby.common.data.data_class.Vehicle;
import madeby.common.util.CollectionManager;
import madeby.common.util.InputManager;
import madeby.common.util.OutputManager;
import madeby.common.util.VehicleCreator;

public class AddCommand extends Command {
    private final CollectionManager collectionManager;
    private final InputManager inputManager;
    private final OutputManager outputManager;

    public AddCommand(CollectionManager collectionManager, InputManager inputManager, OutputManager outputManager) {
        this.collectionManager = collectionManager;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Vehicle vehicle = VehicleCreator.createVehicle(inputManager, outputManager, collectionManager);
        collectionManager.add(vehicle);
        return new CommandResult("Vehicle create");
    }
}
