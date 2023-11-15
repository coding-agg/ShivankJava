package Challenges_arrays;

import java.util.Scanner;

public class maxcircularsumnotcomplete {
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
        int result = (int)Float.NEGATIVE_INFINITY;
        int sum = 0 ;
        int k = 0 ;
        int index = arr.length ;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(index == j){
                    break ;
                }
                sum = sum+arr[j] ;
                k++ ;
                if(arr[j]>sum){
                    index = j ;
                    sum = arr[j] ;
                    k = 1 ;
                }
                if(sum>result && k>1) {
                    result = sum;
                }
            }
        }
        return result ;
    }
}
