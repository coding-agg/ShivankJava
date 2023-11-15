package Section15_Hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class duplicate_values {
    public static void main(String[] args) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        int[] list1 = {5,1,3,4,7};
        int[] list2 = {2,4,3,5,7,10,15};
        for (int value:list1){
            map.put(value,false);
        }
        for (int value:list2){
            if(map.containsKey(value)){
                map.put(value,true);
            }
        }
        int len = 0;
        Collection<Boolean> values = map.values();
        for (boolean value:values){
            if(value){
                len++;
            }
        }
        int[] list = new int[len];
        int i = 0;
        Set<Map.Entry<Integer,Boolean>> entries = map.entrySet();
        for(Map.Entry<Integer,Boolean> entry:entries){
            if(entry.getValue()){
                list[i] = entry.getKey();
                i++;
            }
        }
        for (int value:list){
            System.out.print(value+" ");
        }
    }
}
