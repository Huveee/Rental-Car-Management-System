public class Payment {
    private double paymentAmount;
    private String paymentDate;
    private Customer customer;

    
    public Payment(double paymentAmount, String paymentDate, Customer customer){
        this.paymentAmount=paymentAmount;
        this.paymentDate=paymentDate;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return this.customer;
    }
}
