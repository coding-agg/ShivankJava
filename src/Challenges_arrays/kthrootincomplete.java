package Challenges_arrays;

import java.util.Scanner;

public class kthrootincomplete {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        long[] arr = null ;
        long result = 0 ;
        for (int i = 0; i < scn.nextInt(); i++) {
            arr = array() ;
            result = kth(arr) ;
            System.out.println(result);
        }
    }
    public static long kth(long[] arr){
        long x = 0 ;
        long result = 0 ;
        while(Math.pow(x,arr[1])<=arr[0]){
            result = x ;
            x++ ;
        }
        return result ;
    }
    public static long[] array(){
        long[] arr = new long[2] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextLong() ;
        }
        return arr ;
    }
}
