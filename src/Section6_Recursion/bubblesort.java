package Section6_Recursion;

import java.util.Scanner;

public class bubblesort {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        bubble(arr,0,arr.length-1) ;
    }
    public static void bubble(int[] arr, int si, int li){
        if(li==0){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            return;
        }
        if(si==li){
            bubble(arr,0,li-1) ;
        }

        if(si<li){
            if(arr[si]>arr[si+1]) {
                int temp = arr[si];
                arr[si] = arr[si + 1];
                arr[si + 1] = temp;
            }
            bubble(arr,si+1,li) ;
        }
    }
}