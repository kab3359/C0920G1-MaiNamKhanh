package session_11.bai_tap.test_map;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);
        String element1 = capitalCities.get("USA");
        System.out.println(element1);
        Map<String, String> mapB = new HashMap<>();
        mapB.putAll(capitalCities);
        System.out.println(mapB);
        mapB.remove("Norway");
        System.out.println(mapB);
        mapB.clear();
        System.out.println(mapB);
        System.out.println(capitalCities);
        System.out.println(capitalCities.size());
        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }
        System.out.println(capitalCities.containsKey("norway"));
//        TreeMap<Integer,String> map=new TreeMap<Integer,String>();
//        map.put(100,"Amit");
//        map.put(102,"Ravi");
//        map.put(101,"Vijay");
//        map.put(103,"Rahul");
//
//        for(Map.Entry m:map.entrySet()){
//            System.out.println(m.getKey()+" "+m.getValue());
//        }
//        System.out.println("headMap: "+map.subMap(101, 105));
    }
}
