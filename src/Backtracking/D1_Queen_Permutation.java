package Backtracking;

import java.util.Scanner;

public class D1_Queen_Permutation {
    static Scanner scn = new Scanner(System.in);
    public static int num = 0;

    public static void main(String[] args) {
        boolean[] arr = new boolean[scn.nextInt()];
        D1_Queens(0,2,arr,"");
    }
    public static void D1_Queens(int tqp,int tq,boolean[] arr,String ans){
        if(tqp==tq){
            num++;
            System.out.println(num+" "+ans);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == false){
                arr[i] = true;
                D1_Queens(tqp+1,tq,arr,ans+"q"+tqp+" at " +i+",");
                arr[i] = false;
            }
        }
    }
}
