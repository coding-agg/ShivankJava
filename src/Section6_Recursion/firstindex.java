package Section6_Recursion;

import java.util.Scanner;

public class firstindex {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        int data = scn.nextInt() ;
        System.out.println(firstindex(arr,0,data));
    }
    public static int firstindex(int[] arr,int si,int data){
        if(si==arr.length){
            return -1 ;
        }
        if(arr[si] == data){
            return si ;
        }
        else{
            int ans = firstindex(arr,si+1,data) ;
            return ans ;
        }
    }
}
