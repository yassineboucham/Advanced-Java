import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleGroupingService {
    public Map<FuelType, List<Vehicle>> groupByFuelType(List<Vehicle> vehicles){
        return vehicles.stream()
                .collect(Collectors.groupingBy(Vehicle::getFuelType));
    }

    public Map<FuelType, Long> countByFuelType(List<Vehicle> vehicles){
        return vehicles.stream()
                .collect(Collectors.groupingBy(Vehicle::getFuelType, Collectors.counting()));
    }
}