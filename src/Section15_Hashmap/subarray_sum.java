package Section15_Hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class subarray_sum {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int length = scn.nextInt();
        int[] arr = array(length);
        System.out.println(subarray(arr));
    }
    public static int[] array(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
    public static boolean subarray(int[] arr){
        HashMap<Integer,Boolean> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum==0 || map.containsKey(sum)){
                return true;
            }
            else{
                map.put(sum,true);
            }
        }
        return false;
    }
}
