package Challenges_recursion;

import java.util.Scanner;

public class Optimal_Game_Strategy_1 {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = array();

    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
