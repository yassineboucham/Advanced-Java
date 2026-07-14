# Vehicle Rental — Practice Project (Enums + Streams)

## Purpose

Practice project to master **Enums** combined with the **Streams API**
(`filter`, `map`, `flatMap`, `collect`, `groupingBy`, `min`/`max`, `Optional`)
before applying the same patterns to the real exam (`Client` / `Commande`).

No business logic is filled in below — only class responsibilities and
method signatures. Fill in the bodies yourself.

---

## Package Structure

```
VehicleRentalProject/
│
├── src/
│   └── com/
│       └── rental/
│           ├── model/
│           │   ├── FuelType.java
│           │   └── Vehicle.java
│           │
│           ├── data/
│           │   └── DataInitializer.java
│           │
│           ├── service/
│           │   ├── VehicleFilterService.java
│           │   ├── VehicleGroupingService.java
│           │   └── VehicleStatsService.java
│           │
│           ├── util/
│           │   └── FuelDescriptionUtil.java
│           │
│           └── Main.java
│
└── README.md
```

---

## Class Responsibilities

| Class | Responsibility |
|---|---|
| `FuelType` | Enum of possible fuel types, each carrying a `co2EmissionPerKm` value |
| `Vehicle` | Data holder: plate number, price per day, fuel type |
| `DataInitializer` | Builds the test `List<Vehicle>` with intentional variety |
| `VehicleFilterService` | Filtering and boolean-check operations over vehicles |
| `VehicleGroupingService` | Grouping vehicles by fuel type |
| `VehicleStatsService` | Aggregations: max, average, sorting, per-vehicle totals |
| `FuelDescriptionUtil` | Standalone enum helpers: switch description, values(), valueOf() |
| `Main` | Wires everything together, prints results |

---

## Method Signatures (to implement)

### `model/FuelType.java`

```java
public enum FuelType {
    PETROL, DIESEL, ELECTRIC, HYBRID;

    // constructor taking co2EmissionPerKm

    public double getCo2EmissionPerKm() { }
}
```

### `model/Vehicle.java`

```java
public class Vehicle {

    public Vehicle(String plateNumber, double pricePerDay, FuelType fuelType) { }

    public String getPlateNumber() { }
    public double getPricePerDay() { }
    public FuelType getFuelType() { }

    @Override
    public String toString() { }
}
```

### `data/DataInitializer.java`

```java
public class DataInitializer {

    public static List<Vehicle> createVehicles() { }
}
```

### `service/VehicleFilterService.java`

```java
public class VehicleFilterService {

    public List<Vehicle> getElectricVehicles(List<Vehicle> vehicles) { }

    public long countDieselVehicles(List<Vehicle> vehicles) { }

    public boolean hasHybridVehicle(List<Vehicle> vehicles) { }
}
```

### `service/VehicleGroupingService.java`

```java
public class VehicleGroupingService {

    public Map<FuelType, List<Vehicle>> groupByFuelType(List<Vehicle> vehicles) { }

    public Map<FuelType, Long> countByFuelType(List<Vehicle> vehicles) { }
}
```

### `service/VehicleStatsService.java`

```java
public class VehicleStatsService {

    public Optional<Vehicle> getMostExpensiveVehicle(List<Vehicle> vehicles) { }

    public double getAverageCo2Emission(List<Vehicle> vehicles) { }

    public List<Vehicle> sortByPriceDescending(List<Vehicle> vehicles) { }

    public Map<String, Double> getWeeklyCostByPlate(List<Vehicle> vehicles) { }
}
```

### `util/FuelDescriptionUtil.java`

```java
public class FuelDescriptionUtil {

    public String describe(FuelType type) { }

    public void printAllFuelTypes() { }

    public Optional<FuelType> safeValueOf(String input) { }
}
```

### `Main.java`

```java
public class Main {

    public static void main(String[] args) {
        // 1. get vehicles from DataInitializer
        // 2. call VehicleFilterService methods, print results
        // 3. call VehicleGroupingService methods, print results
        // 4. call VehicleStatsService methods, print results
        // 5. call FuelDescriptionUtil methods, print results
    }
}
```

---

## Suggested Build Order

1. `FuelType` + `Vehicle` → compile, no errors
2. `DataInitializer` → print raw list from `Main`, confirm data variety
3. `VehicleFilterService` → test each method one at a time
4. `VehicleGroupingService` → test grouping output
5. `FuelDescriptionUtil` → test independently, single enum values
6. `VehicleStatsService` → hardest one, combines everything

---

## How to Run

```bash
cd src
javac com/rental/model/*.java com/rental/data/*.java com/rental/service/*.java com/rental/util/*.java com/rental/Main.java
java com.rental.Main
```

---

## Transfer to the Real Exam

| This project | Exam equivalent |
|---|---|
| `Vehicle` / `FuelType` | `Commande` / `statut` |
| `VehicleFilterService` | Questions 2–3 (filtering clients/commandes) |
| `VehicleGroupingService` | Question 14 (`groupingBy`) |
| `VehicleStatsService` | Questions 5–9, 13, 15, 16 (aggregations, sorting, Map building) |
| `FuelDescriptionUtil` | Not directly tested, but useful for understanding enums if `statut` were one |
