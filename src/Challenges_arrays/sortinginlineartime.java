package Challenges_arrays;

import java.util.Scanner;

public class sortinginlineartime {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        int[] arr = arr() ;
        arr = sort(arr) ;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static int[] sort(int[] arr){
        int initial = 0 ;
        int mid = 0 ;
        int last = arr.length-1 ;
        while(mid<=last){
            if(arr[mid] == 0){
                int temp = arr[mid] ;
                arr[mid] = arr[initial] ;
                arr[initial] = temp ;
                mid++ ;
                initial++ ;
            }else if(arr[mid] == 1){
                mid++ ;
            }else{
                int temp = arr[mid] ;
                arr[mid] = arr[last] ;
                arr[last] = temp ;
                last-- ;
            }
        }
        return arr ;
    }
    public static int[] arr(){
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        return arr ;
    }
}
