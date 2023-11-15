package Challenges_Hashing_and_tries;

import java.util.*;

public class arrays_intersection {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        int length = scn.nextInt();
        int[] arr1 = array(length);
        int[] arr2 = array(length);
        HashMap<Integer,Integer> hash1 = hash(arr1);
        HashMap<Integer,Integer> hash2 = hash(arr2);
        Set<Map.Entry<Integer,Integer>> entries = hash1.entrySet();
        for (Map.Entry<Integer,Integer> entry:entries){
            while(hash2.containsKey(entry.getKey()) && entry.getValue()!=0){
                array.add(entry.getKey());
                if(hash2.get(entry.getKey())>1){
                    hash2.put(entry.getKey(),hash2.get(entry.getKey())-1);
                }
                else{
                    hash2.remove(entry.getKey());
                }
                entry.setValue(entry.getValue()-1);
            }
        }
        System.out.println(array);
    }
    public static int[] array(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
    public static HashMap<Integer,Integer> hash(int[] arr){
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int num:arr){
            if(hash.containsKey(num)){
                hash.put(num,hash.get(num)+1);
            }
            else{
                hash.put(num,1);
            }
        }
        return hash;
    }

}
