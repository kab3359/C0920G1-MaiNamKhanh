package validate;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.Locale;

public class Validate {
    private static String regex = "";
    public static boolean checkCustomerId(String id){
        regex = "(KH-)[0-9]{4}";
        return id.matches(regex);
    }

    public static boolean checkServiceId(String id){
        regex = "(DV-)[0-9]{4}";
        return id.matches(regex);
    }

    public static boolean checkPhone(String phone){
        regex = "((090)|(091)|([(]84[)][+]90)|[(]84[)][+]91)[0-9]{7}";
        return phone.matches(regex);
    }

    public static boolean checkIdCard(String idCard){
        regex = "([0-9]{9})([0-9]{3})?";
        return idCard.matches(regex);
    }

    public static boolean checkEmail(String email){
        regex = "[a-zA-Z0-9]+[@][a-zA-Z0-9]+[.][a-zA-Z0-9]+";
        return email.matches(regex);
    }

    public static boolean checkBirthday(String birthday){
        if(Year.now().getValue() < Integer.parseInt(birthday.substring(0,4)) + 18){
            return false;
        }else {
            return true;
        }
    }

    public static boolean checkInt(int num){
        if(num > 0){
            return true;
        }else {
            return false;
        }
    }

    public static boolean checkDouble(double num){
        if(num > 0){
            return true;
        }else {
            return false;
        }
    }
}
