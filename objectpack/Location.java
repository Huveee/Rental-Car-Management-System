package objectpack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.DefaultListModel;

public class Location {
    private String locationName;
    private String address;
    private String contactInformation;
    private boolean isLocationAvailable;
    private Car car;

    
    
    public Location(String locationName,String address,String contactInformation,boolean isLocationAvailable,Car car){
        this.locationName = locationName;
        this.address = address;
        this.contactInformation = contactInformation;
        this.isLocationAvailable = isLocationAvailable;
        this.car = car;
    }

    public static void getLocList(DefaultListModel<Location> model, Car c){
        try {
            File locFile = new File("locations.csv");
            Scanner locScanner = new Scanner(locFile);
            locScanner.nextLine();
            while(locScanner.hasNext()) {
                String locLine = locScanner.nextLine();
                String[] locAttr = locLine.split(",");
                Location l = new Location(locAttr[0], locAttr[1], locAttr[2], Boolean.parseBoolean(locAttr[3]), null);                
                if(c.getCurrentLocation()!=null){
                    if(c.getCurrentLocation().equalsIgnoreCase(l.getLocationName())){
                        model.addElement(l);
                    }
                }
                else{
                    model.addElement(l);
                }
            }
            locScanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public String getLocationName() {
        return this.locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return this.contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public boolean getIsLocationAvailable() {
        return this.isLocationAvailable;
    }

    public void setIsLocationAvailable(boolean isLocationAvailable) {
        this.isLocationAvailable = isLocationAvailable;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
}
