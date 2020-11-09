package session_11.bai_tap.test_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String string = input.nextLine();
        string.toLowerCase();
        System.out.println(string.length());
//        for (int i=0; i<string.length(); i++){
//            if (map.containsKey(string.charAt(i)) == true){
//                map.put(string.charAt(i),map.get(string.charAt(i))+1);
//            }else if(string.charAt(i) != ' ') {
//                map.put(string.charAt(i),1);
//            }
//        }
//        System.out.println(map);

    }
}
