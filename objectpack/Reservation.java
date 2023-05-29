package objectpack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;

public class Reservation {
	
	private String custId;
    private String pickupDate;
    private String dropOffDate;
    private String pickupTime;
    private String dropOffTime;   
    private Location pickupLocation;
	private Location dropOffLocation;
    Car car;
	Payment payment;
    public static List <Reservation> resList=new ArrayList<>();
    
    public Reservation(Location pickupLocation,Location dropOffLocation,Car car){
    	
        this.pickupLocation=pickupLocation;
        this.dropOffLocation=dropOffLocation;
        this.car=car;
        setPickupDate();
        setDropOffDate();
        setPickupTime();
        setDropOffTime();        
    }
    
    public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}
    

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public static void getReservationsHistory(DefaultListModel<String> model, String custId){
        try {
            File resFile = new File("reservations.csv");
            Scanner resScanner = new Scanner(resFile);
            resScanner.nextLine();
            while(resScanner.hasNext()) {
                String resLine = resScanner.nextLine();
                if(custId==null){
					model.addElement(resLine);
				}
				else{
					if(resLine.contains(custId)){
						model.addElement(resLine);
					}
				}
            }
            resScanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
	

    public String getPickupDate() {
        return this.pickupDate;
    }

    public String getDropOffDate() {
        return this.dropOffDate;
    }

    public String getPickupTime() {
		return pickupTime;
	}

	public String getDropOffTime() {
		return dropOffTime;
	}

    public Location getPickupLocation() {
        return this.pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropOffLocation() {
        return this.dropOffLocation;
    }

    public void setDropOffLocation(Location dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }
	

	public void setPickupDate() { //set pickUp date as instant date
		
		LocalDateTime myDateObj = LocalDateTime.now();
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		this.pickupDate = myDateObj.format(myFormatObj);
	    
	}
	
	public void setDropOffDate() { //Set the drop off date as 1 day after pickUp Date
		
		LocalDateTime myDateObj = LocalDateTime.now().plusDays(1); 
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		this.dropOffDate = myDateObj.format(myFormatObj);
	    
	}
	
	public void setPickupTime() { //set pickUp time as instant time
		
		LocalTime myObj = LocalTime.now();
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		this.pickupTime = myObj.format(myFormatObj);
		
	}
	
	public void setDropOffTime() { //set DropOffTime time as same with pickUp time
		
		LocalTime myObj = LocalTime.now();
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		this.dropOffTime = myObj.format(myFormatObj);
		
	}
		
	
	public void addToDocument(Reservation res) {
		
		resList.add(res);
		
		try {
		    FileWriter fWriter = new FileWriter("reservations.csv",true);
		    PrintWriter pWriter = new PrintWriter(fWriter);

		    pWriter.println(res.getCustId()+","+res.getPickupDate()+","+res.getDropOffDate()+","+res.getPickupTime()+","+res.dropOffTime+
		    ","+res.getPickupLocation().getLocationName()+","+res.getDropOffLocation().getLocationName()+","+res.getCar().getBrandName()+","+res.getPayment().getPaymentAmount());

		    pWriter.close();
		    System.out.println("Reservation info added to the csv file.");
		    
		} catch (IOException e) {
		    System.out.println("Error: " + e.getMessage());
		}
	}
}
