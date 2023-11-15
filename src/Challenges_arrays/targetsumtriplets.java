package Challenges_arrays;

import java.util.*;

public class targetsumtriplets {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[] arr = array() ;
        arr = bubble(arr) ;
        targetsum(arr) ;
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        return arr ;
    }
    public static int[] bubble(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j] ;
                    arr[j] = arr[j+1];
                    arr[j+1] = temp ;
                }
            }
        }
        return arr ;
    }
    public static void targetsum(int[] arr){
        int search = scn.nextInt() ;
        for (int i = 0; i < arr.length-2; i++) {
            int low = i+1 ;
            int high = arr.length-1 ;
            while(low<high){
                if(arr[i]+arr[low]+arr[high]>search){
                    high-- ;
                }
                else if(arr[i]+arr[low]+arr[high]<search){
                    low++ ;
                }
                else{
                    System.out.println(arr[i]+", "+arr[low]+" and "+arr[high]);
                    low++;
                    high--;
                }
            }
        }
    }

}
