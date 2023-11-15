package Challenges_Hashing_and_tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class highest_frequency {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int length = scn.nextInt();
        int[] arr = array(length);
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int num:arr){
            if(hash.containsKey(num)){
                hash.put(num,hash.get(num)+1);
            }
            else{
                hash.put(num,1);
            }
        }
        int ans = 0;
        int freq = 0;
        Set<Map.Entry<Integer,Integer>> entries = hash.entrySet();
        for (Map.Entry<Integer,Integer> entry : entries){
            if(entry.getValue()>freq){
                freq = entry.getValue();
                ans = entry.getKey();
            }
        }
        System.out.println(ans);
    }
    public static int[] array(int length){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }

}
