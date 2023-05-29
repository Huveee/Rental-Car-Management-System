package objectpack;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.LocalTime;

public class Payment {
    private String custId;
    private String paymentAmount;
    private String paymentDate;
    private String paymentTime;
    private String CardNumber;
    private String ExpirationDate;
    private String CVC;
    public static List <Payment> payList=new ArrayList<>();
    

	public Payment( String CardNumber, String ExpirationDate, String CVC){
        this.CardNumber=CardNumber;
        this.ExpirationDate=ExpirationDate;
        this.CVC=CVC;
        
    }        
	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}
	
    public String getPaymentTime() {
		return paymentTime;
	}

    public boolean isCardNoValid(Payment pay){
        if (pay.CardNumber.matches("^[0-9]{16}$")) return true;
        else return false;
    }
    public boolean isCVCValid(Payment pay){
        if(pay.CVC.matches("^[0-9]{3}$")) return true;
        else return false;
    }
    public boolean isExpDateValid(Payment pay){
        if(pay.ExpirationDate.matches("^(0[1-9]|1[0-2])/[0-9]{2}$")) return true;
        else return false;
    }
    
    public boolean isAllFieldsValid(Payment pay) {
    	if(isCardNoValid(pay) && isCVCValid(pay) && isExpDateValid(pay)) return true;
    	else return false;
    }
	
	
	public void setpaymentDate() { //set payment date as instant date
		
		LocalDateTime myDateObj = LocalDateTime.now();
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		this.paymentDate = myDateObj.format(myFormatObj);
	    
	}
	
	public void setpaymentTime() { //set payment time as instant time
		
		LocalTime myObj = LocalTime.now();
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		this.paymentTime = myObj.format(myFormatObj);
		
	}
	
	public void addToDocument(Payment pay) {
		
		payList.add(pay);
		
		try {
		    FileWriter fWriter = new FileWriter("payments.csv",true);
		    PrintWriter pWriter = new PrintWriter(fWriter);

		    pWriter.println(pay.getCustId()+","+pay.getPaymentAmount()+","+pay.getPaymentDate()+","+pay.getPaymentTime()+","+
		    pay.getCardNumber()+","+pay.getExpirationDate()+","+pay.getCVC());

		    pWriter.close();
		    System.out.println("Payment info added to the csv file.");
		    
		} catch (IOException e) {
		    System.out.println("Error: " + e.getMessage());
		}
	}

	
	public String getCVC() {
		return CVC;
	}

	public String getExpirationDate() {
		return ExpirationDate;
	}

	public String getCardNumber() {
		return CardNumber;
	}
}
