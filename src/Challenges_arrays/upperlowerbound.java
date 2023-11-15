package Challenges_arrays;

import java.util.Scanner;

public class upperlowerbound {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[] arr = array() ;
        arr = bubble(arr) ;
        int item = scn.nextInt() ;
        for (int i = 0; i < item; i++) {
            int search = scn.nextInt() ;
            lower(arr,search) ;
            upper(arr,search) ;
        }
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        return arr ;
    }
    public static void lower(int[] arr , int item){
        int low = 0 ;
        int high = arr.length-1 ;
        int lower = -1 ;
        while(low<=high){
            int mid = (low+high)/2 ;
            if(arr[mid]>item){
                high = mid-1 ;
            }
            else if(arr[mid]<item){
                low = mid+1 ;
            }
            else{
                lower = mid ;
                high = mid-1 ;
            }
        }
        System.out.print(lower+" ");
    }
    public static void upper(int[] arr , int item){
        int low = 0 ;
        int high = arr.length-1 ;
        int higher = -1 ;
        while(low<=high){
            int mid = (low+high)/2 ;
            if(arr[mid]>item){
                high = mid-1 ;
            }
            else if(arr[mid]<item){
                low = mid+1 ;
            }
            else{
                higher = mid ;
                low = mid+1 ;
            }
        }
        System.out.println(higher);
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
}
