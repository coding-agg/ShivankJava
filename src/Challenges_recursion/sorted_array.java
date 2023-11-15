package Challenges_recursion;

import java.util.Scanner;

public class sorted_array {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = array();
        boolean result = sorted(arr);
        System.out.println(result);
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
    public static boolean sorted(int[] arr){
        if(arr.length==1){
            return true;
        }
        int[] newar = new int[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            newar[i-1] = arr[i];
        }
        boolean result = sorted(newar);

        if(arr[0]<=arr[1] && result == true){
            return true;
        }
        return false;
    }
}
