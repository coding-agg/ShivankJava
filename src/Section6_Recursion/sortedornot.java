package Section6_Recursion;

import java.util.Scanner;

public class sortedornot {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        System.out.println(issorted(arr,0));
    }
    public static boolean issorted(int[] arr,int si){
        if(si==arr.length-1){
            return true ;
        }
        if(arr[si]>arr[si+1]){
            return false ;
        }
        else{
            boolean ans = issorted(arr,si+1) ;
            return ans ;
        }
    }
}
