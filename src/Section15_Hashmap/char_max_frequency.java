package Section15_Hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class char_max_frequency {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        String str = scn.next();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        char maxchar = '\0';
        int max = 0;
        Set<Map.Entry<Character,Integer>> entries = map.entrySet();
        for (Map.Entry<Character,Integer> entry:entries){
            if(entry.getValue()>max) {
                max = entry.getValue();
                maxchar = entry.getKey();
            }
        }
        System.out.println(maxchar);
    }
}
