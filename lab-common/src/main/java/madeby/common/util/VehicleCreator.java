package madeby.common.util;

import madeby.common.data.data_class.Coordinates;
import madeby.common.data.data_class.Vehicle;

import java.util.Date;

public final class VehicleCreator {

    private VehicleCreator() {
    }

    public static Vehicle createVehicle(InputManager inputManager, OutputManager outputManager, CollectionManager collectionManager) {
        Coordinates.CoordinatesBuilder coordinatesBuilder = Coordinates.builder();
        Vehicle.VehicleBuilder vehicleBuilder = Vehicle.builder();
        coordinatesBuilder.x(inputManager.readDoubleValue("Coordinates(x)", outputManager, x -> x > Coordinates.MAX_X));
        coordinatesBuilder.y(inputManager.readLongValue("Coordinates(y)", outputManager));
        vehicleBuilder.type(inputManager.readTypeValue("PLANE\nBICYCLE\nHOVERBOARD,\nSPACESHIP\n\"\" to null", outputManager));
        vehicleBuilder.id(-1);
        vehicleBuilder.creationDate(new Date());
        vehicleBuilder.name(inputManager.readStringWithPredicatValue("name", outputManager, x -> x.length() < Vehicle.MIN_LEN_NAME));
        vehicleBuilder.coordinates(coordinatesBuilder.build());
        vehicleBuilder.enginePower(inputManager.readIntegerValueWithPredicate("enginePower", outputManager, x -> x < Vehicle.MIN_ENGINEPOWER));
        vehicleBuilder.capacity(inputManager.readIntegerValueWithPredicate("capacity", outputManager, x -> x < Vehicle.MIN_CAPACITY));
        vehicleBuilder.distanceTravelled(inputManager.readLongValueWithPrediction("distance", outputManager, x -> x < Vehicle.MIN_DISTANCE));
        return vehicleBuilder.build();

    }
}
