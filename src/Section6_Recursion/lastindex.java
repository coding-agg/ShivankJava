package Section6_Recursion;

import java.util.Scanner;

public class lastindex {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        int data = scn.nextInt() ;
        System.out.println(lastindex(arr,0,data));
    }
    public static int lastindex(int[] arr,int si,int data){
        if(si==arr.length){
            return -1 ;
        }
        if(arr[arr.length-si-1] == data){
            return arr.length-si-1 ;
        }
        else{
            int ans = lastindex(arr,si+1,data);
            return ans ;
        }
    }
}
