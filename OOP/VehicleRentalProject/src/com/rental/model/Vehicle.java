public class Vehicle {
    private int plateNumber;
    private int pricePerDay;
    private FuelType fuelType;

    public Vehicle(int plateNumber, int pricePerDay, FuelType fuelType) {
        this.plateNumber = plateNumber;
        this.pricePerDay = pricePerDay;
        this.fuelType = fuelType;
    }

    // Getters
    public int getPlateNumber() {
        return plateNumber;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNumber=" + plateNumber +
                ", pricePerDay=" + pricePerDay +
                ", fuelType=" + fuelType +
                '}';
    }
}