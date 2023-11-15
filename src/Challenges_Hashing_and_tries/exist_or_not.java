package Challenges_Hashing_and_tries;

import java.util.HashMap;
import java.util.Scanner;

public class exist_or_not {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int test = scn.nextInt();
            int[] arr = array(test);
            HashMap<Integer, Boolean> hash = new HashMap<>();
            for (int num : arr) {
                hash.put(num, true);
            }
            int test2 = scn.nextInt();
            for (int j = 0; j < test2; j++) {
                int num2 = scn.nextInt();
                if (hash.containsKey(num2)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
    public static int[] array(int length){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
