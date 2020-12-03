package commons;

public class Validate {
    private static String regex = "";
    public static boolean checkServiceName(String str){
        regex = "([A-Z][a-z]*[ ])*([A-Z][a-z]*)";
        return str.matches(regex);
    }
    public static boolean checkArea(double dou){
        return dou > 30;
    }
    public static boolean checkCostRent(double dou){
        return dou > 0;
    }
    public static boolean checkNumPeople (int num){
        return num > 0 && num < 20;
    }
    public static boolean checkNumFloor(int num){
        return num > 0;
    }
    public static boolean checkTypeRent(String str){
        regex = "((Year)|(Month)|(Date)|(Hour))";
        return str.matches(regex);
    }
    public static boolean checkDateOfBirth(String str){
        regex = "^(((0[1-9]|[12][0-9]|30)[-\\/](0[13-9]|1[012])|31[-\\/](0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-\\/]02)" +
                "[-\\/](19[0-9]{2}|200[012])|29[-\\/]02[-\\/]" +
                "([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$";
        return str.matches(regex);
    }
    public static boolean checkEmail(String str){
        regex = "[\\w]+@[\\w]+[.][\\w]+";
        return str.matches(regex);
    }
    public static boolean checkGender(String str){
        regex = "([Mm][Aa][Ll][Ee])|([Ff][Ee][Mm][Aa][Ll][Ee])|([Uu][Nn][Kk][Nn][Oo][Ww][Nn])";
        return str.matches(regex);
    }
    public static boolean checkIdCard(String str){
        regex = "([0-9]{3}[ ]){2}[0-9]{3}";
        return str.matches(regex);
    }
    public static boolean checkPhone(String str){
        regex = "(0|[+]84)[-][0-9]{9}";
        return str.matches(regex);
    }
    public static boolean checkID(String str, String type){
        String regexVilla = "(SVVL-)[0-9]{4}";
        String regexHouse = "(SVHO-)[0-9]{4}";
        String regexRoom = "(SVRO-)[0-9]{4}";
        if (type == "VL"){
            return str.matches(regexVilla);
        }else if (type == "HO"){
            return str.matches(regexHouse);
        }else if (type == "RO"){
            return str.matches(regexRoom);
        }return false;
    }
    public static boolean checkFreeService(String str){
        regex = "((Massage)|(Karaoke)|(Food)|(Water)|(Car))";
        return str.matches(regex);
    }
}
