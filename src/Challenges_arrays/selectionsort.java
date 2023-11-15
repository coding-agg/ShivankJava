package Challenges_arrays;

import java.util.Scanner;

public class selectionsort {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = selection();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] selection() {
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int val = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[val]) {
                    val = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[val];
            arr[val] = temp;
        }
        return arr;
    }
}