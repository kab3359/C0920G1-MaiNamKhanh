package common;

public class Validate {
    private static String regex = "";
    public static boolean checkMaSoTietKiem(String str){
        regex = "(STK-)[0-9]{4}";
        return str.matches(regex);
    }
}
