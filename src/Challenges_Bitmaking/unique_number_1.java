package Challenges_Bitmaking;

import java.util.Scanner;

public class unique_number_1 {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int len = scn.nextInt();
        int[] arr = array(len);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = ans^arr[i];
        }
        System.out.println(ans);
    }
    public static int[] array(int len){
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scn.nextInt();
        }
        return array;
    }
}
