package Challenges_arrays;

import java.util.Scanner;

public class subarraysum {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int test = scn.nextInt() ;
        int[] arr = null ;
        for (int i = 0; i < test; i++) {
            arr = array() ;
            int result = sum(arr) ;
            System.out.println(result);
        }
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        return arr ;
    }
    public static int sum(int[] arr){
        double result = Float.NEGATIVE_INFINITY;;
        int sum = 0 ;
        for (int i = 0; i < arr.length; i++) {
            sum = sum+arr[i] ;
            if(arr[i]>sum){
                sum = arr[i] ;
            }
            if(sum>result) {
                result = sum;
            }
        }
        return (int)result ;
    }
}
