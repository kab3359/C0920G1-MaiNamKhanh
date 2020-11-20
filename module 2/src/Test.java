import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(0, "One");
        hashMap.put(2, "Two");
        hashMap.put(4, "Four");
        hashMap.put(21, "Twenty first");
        hashMap.put(5, "Five");
        System.out.println(hashMap);
    }
}
