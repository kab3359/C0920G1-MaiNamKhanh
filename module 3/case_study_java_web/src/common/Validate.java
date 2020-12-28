package common;

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
        regex = "[a-zA-Z]+[@][a-zA-Z]+[.][a-zA-Z]+";
        return email.matches(regex);
    }
}
