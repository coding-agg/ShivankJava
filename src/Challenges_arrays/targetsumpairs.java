package Challenges_arrays;

import java.util.Scanner;

public class targetsumpairs {
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
    public static void targetsum(int[] arr){
        int search = scn.nextInt() ;
        for (int i = 0; i < arr.length; i++) {
            int low = i+1 ;
            int high = arr.length-1 ;
            while(low<=high){
                int mid = (low+high)/2 ;
                if(arr[mid]+arr[i] > search){
                    high = mid-1 ;
                }
                else if(arr[mid]+arr[i]<search){
                    low = mid+1 ;
                }
                else{
                    System.out.print(arr[i]+" and "+arr[mid]);
                    System.out.println();
                    break ;
                }
            }
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
}
