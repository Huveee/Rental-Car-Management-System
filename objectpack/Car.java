package objectpack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.DefaultListModel;

public class Car {
    private String brandName;
    private String modelName;
    private String year;
    private String color;
    private String fuelConsumption;
    private String dailyRentalRate;
    private String licensePlate;
    private boolean isReserved;
    private String currentLocation;

    
    
    //Constructer
    public Car(String brandName,String modelName,String year,String color,String fuelConsumption, String dailyRentalRate,String licensePlate,boolean isReserved, String currentLocation){
        this.brandName = brandName;
        this.modelName = modelName;
        this.year = year;
        this.color = color;
        this.fuelConsumption = fuelConsumption;
        this.dailyRentalRate = dailyRentalRate;
        this.licensePlate = licensePlate;
        this.isReserved = isReserved;
        this.currentLocation = currentLocation;
    }
    
    //Methods

    public void addToCSV(){
        try {
            File carFile = new File("cars.csv");
            File tempFile = new File("temp.csv");
            FileWriter carWriter = new FileWriter(tempFile);
            Scanner carScanner = new Scanner(carFile);
            carWriter.write(carScanner.nextLine()+"\n");
            while(carScanner.hasNext()){
                String carLine = carScanner.nextLine();
                carWriter.write(carLine+"\n");
            }
            carScanner.close();
            carWriter.write(this.brandName+","+this.modelName+","+this.year+","+this.color+","+this.fuelConsumption+","+this.dailyRentalRate+","+this.licensePlate+","+this.isReserved+","+this.currentLocation);
            carWriter.close();
            carFile.delete();
            tempFile.renameTo(carFile);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Not done
    public void updateCar(Car c){
        try {
            File carFile = new File("cars.csv");
            File tempFile = new File("temp.csv");
            FileWriter carWriter = new FileWriter(tempFile);
            Scanner carScanner = new Scanner(carFile);
            carWriter.write(carScanner.nextLine()+"\n");
            while(carScanner.hasNext()){
                String carLine = carScanner.nextLine();
                String[] carrAttr = carLine.split(",");
                if(!(this.licensePlate.equalsIgnoreCase(carrAttr[6]))){
                    carWriter.write(carLine+"\n");
                }
            }
            carScanner.close();
            carWriter.write(c.brandName+","+c.modelName+","+c.year+","+c.color+","+c.fuelConsumption+","+c.dailyRentalRate+","+c.licensePlate+","+c.isReserved+","+c.currentLocation);
            carWriter.close();
            carFile.delete();
            tempFile.renameTo(carFile);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeCar(){
        try {
            File carFile = new File("cars.csv");
            File tempFile = new File("temp.csv");
            FileWriter carWriter = new FileWriter(tempFile);
            Scanner carScanner = new Scanner(carFile);
            carWriter.write(carScanner.nextLine()+"\n");
            while(carScanner.hasNext()){
                String carLine = carScanner.nextLine();
                String[] carrAttr = carLine.split(",");
                if(!(this.licensePlate.equalsIgnoreCase(carrAttr[6]))){
                    carWriter.write(carLine+"\n");
                }
            }
            carScanner.close();
            carWriter.close();
            carFile.delete();
            tempFile.renameTo(carFile);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getCarList(DefaultListModel<Car> model){
        try {
            File carFile = new File("cars.csv");
            Scanner carScanner = new Scanner(carFile);
            carScanner.nextLine();
            while(carScanner.hasNext()) {
                String carLine = carScanner.nextLine();
                String[] carAttr = carLine.split(",");
                Car c = new Car(carAttr[0], carAttr[1], carAttr[2], carAttr[3], carAttr[4], carAttr[5], carAttr[6], Boolean.parseBoolean(carAttr[7]), carAttr[8]);
                model.addElement(c);
            }
            carScanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public String getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getBrandName() {
        return this.brandName;
    }
    
    public String getModelName() {
        return this.modelName;
    }  
    
    public String getYear() {
        return this.year;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public String getFuelConsumption() {
        return this.fuelConsumption;
    }
    
    public String getDailyRentalRate() {
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