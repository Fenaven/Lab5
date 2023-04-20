package madeby.common.util;

import madeby.common.Exception.DontCorrectJsonException;
import madeby.common.data.data_class.Vehicle;
import madeby.common.data.data_class.Vehicles;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.stream.Collectors;

@XmlRootElement
public class CollectionManager {
    private final Vehicles dataCollection;
    private final HashSet<Integer> dataIds;
    private final Date date;
    private int idIterator;


    public CollectionManager() {
        this.dataCollection = new Vehicles();
        this.dataIds = new HashSet<>();
        this.date = new Date();
        this.idIterator = 0;
    }

    public void clear() {
        this.dataCollection.getVehicleArrayList().clear();
        this.dataIds.clear();
    }

    public void initData(Vehicles vehicles) throws DontCorrectJsonException {
        for (Vehicle vehicle : vehicles.getVehicleArrayList()) {
            if (vehicle.getId() < 0) {
                throw new DontCorrectJsonException("id < 0");
            }
            if (dataIds.contains(vehicle.getId())) {
                throw new DontCorrectJsonException("id constain");
            }

            this.dataCollection.getVehicleArrayList().add(vehicle);
            this.dataIds.add(vehicle.getId());
        }
    }

    public ArrayList<Vehicle> printDescending() {
        return dataCollection.getVehicleArrayList().stream().sorted(Collections.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Vehicle> filterStartsWithName(String nameStart) {
        return dataCollection.getVehicleArrayList().stream().filter(x -> x.getName().startsWith(nameStart)).collect(Collectors.toCollection(ArrayList::new));
    }

    private int getNewId() {
        while (this.dataIds.contains(idIterator)) {
            idIterator++;
        }
        return idIterator;
    }

    public boolean update(Vehicle vehicle, Integer id) {
        if (removeByID(id)) {
            vehicle.setId(id);
            this.dataCollection.getVehicleArrayList().add(vehicle);
            this.dataIds.add(vehicle.getId());
            return true;
        }
        return false;
    }

    public Vehicles getDataCollection() {
        return dataCollection;
    }

    public void removeFirst() {
        dataCollection.getVehicleArrayList().remove(0);
    }

    public boolean insertAt(Vehicle vehicle, Integer index) {
        if (checkIndex(index)) {
            dataCollection.getVehicleArrayList().add(index, vehicle);
            return true;
        }
        return false;
    }

    public boolean checkIndex(Integer index) {
        return index > 0 && index < dataCollection.getVehicleArrayList().size();
    }

    private void removeId(Integer id) {
        dataIds.remove(id);
    }

    @Override
    public String toString() {
        return dataCollection.getVehicleArrayList().toString();
    }

    public boolean isEmpty() {
        return dataCollection.getVehicleArrayList().isEmpty();
    }


    public Long sumOfDistanceTravelled() {
        return dataCollection.getVehicleArrayList().stream().mapToLong(Vehicle::getDistanceTravelled).sum();
    }


    public long removeLower(Vehicle vehicle) {
        long count = dataCollection.getVehicleArrayList().stream().filter((x -> x.compareTo(vehicle) > 0)).count();
        dataCollection.getVehicleArrayList().removeAll(dataCollection.getVehicleArrayList().stream().filter(x -> x.compareTo(vehicle) > 0).toList());
        return count;
    }


    public boolean removeByID(Integer id) {
        if (containsId(id)) {
            Vehicle vehicle = dataCollection.getVehicleArrayList().stream().filter(x -> id.equals(x.getId())).findAny().get();
            removeId(vehicle.getId());
            dataCollection.getVehicleArrayList().remove(vehicle);
            return true;
        }
        return false;
    }


    public void add(Vehicle vehicle) {
        vehicle.setId(getNewId());
        vehicle.setCreationDate(new Date());
        this.dataCollection.getVehicleArrayList().add(vehicle);
        this.dataIds.add(vehicle.getId());
    }


    public String info() {
        return "type:" + dataCollection.getClass().toString()
                + "\ndate:" + date.toString() + "\n"
                + "count_elem:" + Integer.toString(dataCollection.getVehicleArrayList().size()) + "\n";
    }

    public boolean containsId(Integer id) {
        return this.dataIds.contains(id);
    }

}
