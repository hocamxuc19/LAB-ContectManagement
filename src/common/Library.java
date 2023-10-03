package common;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Contact;

public class Library {
   
    private Scanner sc = new Scanner(System.in);
    private String VALID_PHONE = "^(03[2-9]|05[6-9]|07[06-9]|08[1-9]|09[0-9])[0-9]{7}$";
    
    public int inputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String inputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    public int inputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input number!");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String inputPhone() {
        while (true) {
            String result = inputString();
            if (result.matches(VALID_PHONE)) {
                return result;
            }
            System.err.println("Please input Phone numbers of telecommunications companies in VietNam ) : \n"
                    + "• 09XXXXXXXX\n"
                    + "• 07XXXXXXXX \n"
                    + "• 03XXXXXXXX \n");
            System.out.print("Enter again: ");
        }
    }  
  
    public boolean inputYesNo() {
        while (true) {
            String result = inputString().trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    public boolean inputAddress(String address) {
        // Biểu thức chính quy để kiểm tra địa chỉ
        String regex = "^[0-9]+\\s[A-Za-zĐđÀ-Ỹà-ỹ,\\s]+,[\\s]+[A-Za-zĐđÀ-Ỹà-ỹ,\\s]+,[\\s]+[A-Za-zĐđÀ-Ỹà-ỹ]+$";
        // Tạo Pattern object
        Pattern pattern = Pattern.compile(regex);
        // Tạo Matcher object
        Matcher matcher = pattern.matcher(address);
        // Kiểm tra xem địa chỉ có khớp với biểu thức chính quy không
        return matcher.matches();
    }
    public boolean checkIdExist(ArrayList<Contact> contacts, int id) {
        for (Contact c : contacts) {
            if (c.getContactId() == id) {
                System.err.println("Id exist!");
                return false;
            }
        }
        return true;
    }
    
  
}