import java.util.List;

public class VehicleFilterService{

    public List<Vehicle> getElectricVehicles(List<Vehicle> vehicles) {
        return vehicles.stream()
            .filter(vehicle -> vehicle.getFuelType() == FuelType.ELECTRIC)
            .toList();
    }

    public List<Vehicle> getDieselVehicles(List<Vehicle> vehicles){
        return vehicles.stream()
             .filter(vehicle -> vehicle.getFuelType() == FuelType.DIESEL)
             .toList();
    }

    public List<Vehicle> getHtbridVehicles(List<Vehicle> vehicles){
        return vehicles.stream()
            .filter(vehicle -> vehicle.getFuelType() == FuelType.HYBRID)
            .toList();
    }
}