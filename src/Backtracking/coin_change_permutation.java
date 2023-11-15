package Backtracking;

import java.util.Scanner;

public class coin_change_permutation {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scn.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        coin_change(arr,"",0,scn.nextInt());
    }
    public static void coin_change(int[] arr,String str,int sum,int result){
        if(sum==result){
            System.out.println(str);
            return;
        }
        if(sum>result){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            coin_change(arr,str+arr[i],sum+arr[i],result);
        }
    }
}
