package objectpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Customer {
    private String userName;
    private String eMail;
    private String password;
    private String idNumber;
    private int age;
    private String phone;
    private Car car;

    
    //Constructer
    public Customer(String userName, String eMail, String password, String idNumber, int age, String phone){
        this.userName = userName;
        this.eMail = eMail;
        this.age = age;
        this.password = password;
        this.idNumber = idNumber;
        this.phone = phone;
    }
    
    //Methods
    Car getCar() {
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

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean userNameValidation(Customer cust){
        if (cust.userName.matches("[a-zA-Z ]+")) return true;
        else return false;
    }
    public boolean emailValidation(Customer cust){
        if(cust.eMail.matches("[a-zA-Z0-9]+@[a-zA-Z]+\\.com")) return true;
        else return false;
    }
    public boolean passwordValidation(Customer cust){
        if(cust.password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) return true;
        else return false;
    }
    public boolean idValidation(Customer cust){
        if(cust.idNumber.matches("\\d{11}")) return true;
        else return false;
    }
    public boolean ageValidation(Customer cust){
        if(Integer.toString(cust.age).matches("\\d+") && cust.age >= 18) return true;
        else return false;
    }
    public boolean phoneValidation(Customer cust){
        if(cust.phone.matches("[1-9]\\d{10}")) return true;
        else return false;
    }

    public boolean toDocument(Customer cust) {
        boolean flag = true;
        List<String[]> custList = readCSV("accounts.csv", ",");
        for (String[] row : custList) {
            if (Arrays.asList(row).contains(cust.eMail) || Arrays.asList(row).contains(cust.idNumber)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            List<String> newCust = new ArrayList<>();
            newCust.add(cust.userName);
            newCust.add(cust.eMail);
            newCust.add(cust.password);
            newCust.add(cust.idNumber);
            newCust.add(Integer.toString(cust.age));
            newCust.add(cust.phone);
            writeCSV(newCust, "accounts.csv", ",");
        }
        return flag;
    }
    
    void writeCSV(List<String> data, String csvFile, String csvSplitBy) {
        
        try (FileWriter writer = new FileWriter(csvFile, true)) {
            StringBuilder sb = new StringBuilder();
            for (String cell : data) {
                sb.append(cell).append(csvSplitBy);
            }
            sb.deleteCharAt(sb.length() - 1); // Son ayırıcı karakteri silme
            sb.append("\n"); // Satır sonu karakteri ekleme
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static List<String[]> readCSV(String csvFile, String csvSplitBy) {
        List<String[]> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(csvSplitBy);
                rows.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }
    public static boolean doCredentialsMatch(String eMail, String password){
        List<String[]> list = readCSV("accounts.csv", ",");
        for (String[] row : list) {
            if (Arrays.asList(row).contains(eMail) && Arrays.asList(row).contains(password)) {
                return true;
            }
        }
        return false;
    }

}
