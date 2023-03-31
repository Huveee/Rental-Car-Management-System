public class Car {
    private String brandName;
    private String modelName;
    private int year;
    private String color;
    private double fuelConsumption;
    private double dailyRentalRate;
    private String licensePlate;
    private boolean isReserved;

    
    //Constructer
    public Car(){
        
    }
    
    //Methods
    public String getBrandName() {
        return this.brandName;
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    
    public String getModelName() {
        return this.modelName;
    }
    
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }
    
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    
    public double getDailyRentalRate() {
        return this.dailyRentalRate;
    }
    
    public void setDailyRentalRate(double dailyRentalRate) {
        this.dailyRentalRate = dailyRentalRate;
    }
    
    public String getLicensePlate() {
        return this.licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public boolean isIsReserved() {
        return this.isReserved;
    }
    
    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }
}
