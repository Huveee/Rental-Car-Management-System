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
    public Car(String brandName,String modelName,int year,String color,double fuelConsumption, double dailyRentalRate,String licensePlate,boolean isReserved){
        this.brandName = brandName;
        this.modelName = modelName;
        this.year = year;
        this.color = color;
        this.fuelConsumption = fuelConsumption;
        this.dailyRentalRate = dailyRentalRate;
        this.licensePlate = licensePlate;
        this.isReserved = isReserved;
    }
    
    //Methods
    public String getBrandName() {
        return this.brandName;
    }
    
    public String getModelName() {
        return this.modelName;
    }  
    
    public int getYear() {
        return this.year;
    }
    
    
    public String getColor() {
        return this.color;
    }
    
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }
    
    public double getDailyRentalRate() {
        return this.dailyRentalRate;
    }
    
    public String getLicensePlate() {
        return this.licensePlate;
    }
    
    public boolean getIsReserved() {
        return this.isReserved;
    }
    
    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }
}
