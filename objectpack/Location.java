package objectpack;
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
    
    public String getLocationName() {
        return this.locationName;
    }
    
    public String getAddress() {
        return this.address;
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
