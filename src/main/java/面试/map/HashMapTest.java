package 面试.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < 17; i++) {
            map.put(i,i);
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            if (iterator.next()%2==0){
                iterator.remove();
            }
        }

    }
}
