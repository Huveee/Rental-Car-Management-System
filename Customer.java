public class Customer {
    private String userName;
    private String eMail;
    private String password;
    private int idNumber;
    private int age;
    private int phone;
    private Car car;

    
    //Constructer
    public Customer(String userName, String eMail, String password, int idNumber, int age, int phone){
        this.userName = userName;
        this.eMail = eMail;
        this.age = age;
        this.password = password;
        this.idNumber = idNumber;
        this.phone = phone;
    }
    
    //Methods
    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEMail() {
        return this.eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
