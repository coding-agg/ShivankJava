package Section15_Hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class hashmap_demo {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("USA",200);
        map.put("UK",175);
        map.put("India",300);
        map.put("China",350);
        System.out.println(map);

        map.put("Swedan",100);
        System.out.println(map);

        map.put("India",325);
        System.out.println(map);

        System.out.println(map.get("India"));
        System.out.println(map.get("RSA"));

        System.out.println(map.remove("USA"));
        System.out.println(map);

        System.out.println(map.containsKey("India"));
        System.out.println(map.containsKey("USA"));

        Set<String> keys = map.keySet();
        for (String key:keys){
            System.out.println(key);
        }

        Collection<Integer> values = map.values();
        for (int value:values){
            System.out.println(value);
        }

        Set<Map.Entry<String,Integer>> entryset = map.entrySet();
        for (Map.Entry<String,Integer> entry:entryset){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
