package Challenges_arrays;

import java.util.Scanner;

public class countingsort {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[] arr = array() ;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] array(){
        int large = (int)Float.NEGATIVE_INFINITY;
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
            if(arr[i]>large){
                large = arr[i] ;
            }
        }
        int[] demoarr = new int[large+1] ;
        for (int i = 0; i < arr.length; i++) {
            demoarr[arr[i]]++ ;
        }
        for (int i = 0; i < demoarr.length-1; i++) {
            demoarr[i+1] = demoarr[i]+demoarr[i+1] ;
        }
        int[] newarr = new int[arr.length] ;
        for (int i = 0; i < arr.length; i++) {
            newarr[demoarr[arr[i]]-1] = arr[i] ;
            demoarr[arr[i]]--;
        }
        return newarr ;
    }
}
