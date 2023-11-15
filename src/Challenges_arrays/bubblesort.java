package Challenges_arrays;

import java.util.Scanner;

public class bubblesort {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[] arr = array() ;
        arr = bubble(arr) ;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static int[] bubble(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp ;
                }
            }
        }
        return arr ;
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        return arr ;
    }
}
