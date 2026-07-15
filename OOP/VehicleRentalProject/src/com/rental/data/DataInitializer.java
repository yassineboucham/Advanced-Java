import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static List<Vehicle> createVehicles() {
        List<Vehicle> Vehicles = new ArrayList<>();

        Vehicles.add(new Vehicle(1001, 400, FuelType.PETROL));
        Vehicles.add(new Vehicle(1002, 450, FuelType.DIESEL));
        Vehicles.add(new Vehicle(1003, 600, FuelType.ELECTRIC));
        Vehicles.add(new Vehicle(1004, 550, FuelType.HYBRID));
        Vehicles.add(new Vehicle(1005, 350, FuelType.PETROL));
        Vehicles.add(new Vehicle(1006, 700, FuelType.ELECTRIC));

        return Vehicles;
    }
}