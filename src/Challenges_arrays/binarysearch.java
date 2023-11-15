package Challenges_arrays;

import java.util.Scanner;

public class binarysearch {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[] arr = array() ;
        arr = bubble(arr) ;
        int result = binary(arr,scn.nextInt()) ;
        System.out.println(result);

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
    public static int binary(int[] arr,int item){
        int low = 0 ;
        int high = arr.length-1 ;
        while(low<=high){
            int mid = (low+high)/2 ;
            if(arr[mid]>item){
                high-- ;
            }
            else if(arr[mid]<item){
                low++ ;
            }
            else{
                return mid ;
            }
        }
        return -1 ;
    }
}
