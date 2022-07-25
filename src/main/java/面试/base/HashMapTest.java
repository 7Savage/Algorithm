package 面试.base;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("敖丙","520");
        map.put("丙敖","love");

        // Iterating entries using a For Each loop
        for (Map.Entry<String,String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

    }
}
