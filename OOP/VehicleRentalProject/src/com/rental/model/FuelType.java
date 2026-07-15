public enum FuelType {
    PETROL(120.0), 
    DIESEL(100.0), 
    ELECTRIC(0.0), 
    HYBRID(60.0);

    private final double co2EmissionPerKm;

    FuelType(double co2EmissionPerKm){
        this.co2EmissionPerKm = co2EmissionPerKm;
    }

    public double getCo2EmissionPerKm() {
        return co2EmissionPerKm;
    }
}
