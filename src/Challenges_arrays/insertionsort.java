package Challenges_arrays;

import java.util.Scanner;

public class insertionsort {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        int[] arr = array() ;
        arr = insertion(arr) ;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        return arr ;
    }
    public static int[] insertion(int[] arr){
        for (int counter = 1; counter < arr.length; counter++) {
            int val = arr[counter] ;
            int j = counter-1 ;
            while(j>=0 && arr[j]>val){
                arr[j+1] = arr[j] ;
                j-- ;
            }
            arr[j+1] = val ;
        }
        return arr ;
    }
}
