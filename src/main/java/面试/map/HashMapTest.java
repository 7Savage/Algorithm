package 面试.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HashMapTest {
    @Test
    public void test(){
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

    @Test
    public void test2(){
        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(1,2);
        map.put(1,3);
        for (Map.Entry<Integer,Integer> entry:
                map.entrySet() ) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
