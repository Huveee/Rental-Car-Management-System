public class Reservation {
    private String pickupDate;
    private String dropOffDate;
    private int rentalPeriod;
    private String pickupLocation;
    private String dropOffLocation;
    private Customer customer;

    
    public Reservation(){
        
        
    }
    
    public String getPickupDate() {
        return this.pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getDropOffDate() {
        return this.dropOffDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public int getRentalPeriod() {
        return this.rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }

    public String getPickupLocation() {
        return this.pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropOffLocation() {
        return this.dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
