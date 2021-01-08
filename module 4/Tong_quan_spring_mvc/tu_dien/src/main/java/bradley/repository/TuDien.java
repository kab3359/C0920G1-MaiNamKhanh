package bradley.repository;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class TuDien {
    private static Map<String, String> list;

    static{
        list = new HashMap<>();
        list.put("hello", "xin chào");
        list.put("tomorrow", "ngày mai");
    }

    public String getTuDien(String name){
        if (list.get(name) != null){
            return list.get(name);
        }
        return "ko tìm thấy";
    }

}
