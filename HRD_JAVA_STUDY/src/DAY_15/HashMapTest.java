package DAY_15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("name", "KONG");
        map.put("age", 20);
        System.out.println("size = " + map.size());

        System.out.println("name = " + map.get("name"));
        System.out.println("age = " + map.get("age"));

        System.out.println("-----------------------------");
        HashMap<String, String> map2 = new HashMap<String, String>();
        String[] keys = {"name", "age", "address"};
        String[] values = {"KONG", "20", "수원시"};

        for (int i = 0; i < keys.length; i++) {
            map2.put(keys[i], values[i]);
        }

        Set<String> kset = map2.keySet();
        Iterator<String> ie = kset.iterator();
        while (ie.hasNext()) {
            String key = ie.next();
            System.out.println(key + " = " + map2.get(key));
        }
    }
}
