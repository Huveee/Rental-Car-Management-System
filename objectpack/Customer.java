package objectpack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String userName;
    private String eMail;
    private String password;
    private String idNumber;
    private int age;
    private String phone;
    Reservation res;
    public static List<Customer> objList = new ArrayList<>();

    
    //Constructer
    public Customer(String userName, String eMail, String password, String idNumber, int age, String phone){
        this.userName = userName;
        this.eMail = eMail;
        this.age = age;
        this.password = password;
        this.idNumber = idNumber;
        this.phone = phone;
    }
    

    public Reservation getRes() {
		return res;
	}

	public void setRes(Reservation res) {
		this.res = res;
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
        if(cust.phone.matches("^\\d{10}$")) return true;
        else return false;
    }
    
    boolean allFieldsValidation(Customer cust) { //make all validations
        if(userNameValidation(cust)&& emailValidation( cust) && passwordValidation( cust) 
            && idValidation( cust) && ageValidation( cust) && phoneValidation( cust))
            return true;
        else
            return false;
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
            objList.add(cust); //Add customer as object to the List
        }
        return flag;
    }
    
    void writeCSV(List<String> data, String csvFile, String csvSplitBy) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile, true))) {
            StringBuilder sb = new StringBuilder();
            for (String cell : data) {
                sb.append(cell).append(csvSplitBy);
            }
            sb.deleteCharAt(sb.length() - 1); // Son ayırıcı karakteri silme
            sb.append("\n"); // Satır sonu karakteri ekleme
            writer.print(sb.toString());
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
    
    // public static Customer findCustomer(String eMail) { //To find the customer object in object List
    //     for (Customer cust : objList  ) {
    //         if (cust.getEMail().equals(eMail)) {
    //             return cust;
    //         }
    //     }
    //     return null;
    // }

    public static Customer findCustomer(String eMail){
        Customer cust = new Customer(null, null, null, null, 0, null);
        List<String[]> list = readCSV("accounts.csv", ",");
        for (String[] row : list) {
            if (Arrays.asList(row).contains(eMail)) {
                cust.setUserName(Arrays.asList(row).get(0));
                cust.setEMail(Arrays.asList(row).get(1));
                cust.setPassword(Arrays.asList(row).get(2));
                cust.setIdNumber(Arrays.asList(row).get(3));
                cust.setAge(Integer.parseInt(Arrays.asList(row).get(4)));
                cust.setPhone(Arrays.asList(row).get(5));
            }
        }
        return cust;
    }

    public void deleteAccount(){
        try {
            File cusFile = new File("accounts.csv");
            File tempFile = new File("temp.csv");
            FileWriter cusWriter = new FileWriter(tempFile);
            Scanner cusScanner = new Scanner(cusFile);
            cusWriter.write(cusScanner.nextLine()+"\n");
            while(cusScanner.hasNext()){
                String cusLine = cusScanner.nextLine();
                String[] cusAttr = cusLine.split(",");
                if(!(this.idNumber.equalsIgnoreCase(cusAttr[3]))){
                    cusWriter.write(cusLine+"\n");
                }
            }
            cusScanner.close();
            cusWriter.close();
            cusFile.delete();
            tempFile.renameTo(cusFile);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
