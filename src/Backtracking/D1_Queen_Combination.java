package Backtracking;

import java.util.Scanner;

public class D1_Queen_Combination {
    public static int num = 0 ;
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        boolean[] arr = new boolean[scn.nextInt()];
        D1_Queens(0,2,arr,"");
        D1_Queens_teacher(0,2,arr,"",-1);
    }
    public static void D1_Queens(int tqp,int tq,boolean[] arr,String ans){
        if(tqp==tq){
            num++;
            System.out.println(num+ans);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == false){
                for (int j = 0; j <=i; j++) {
                    arr[j] = true;
                }
                D1_Queens(tqp+1,tq,arr,ans+" "+"q"+tqp+" at " +i+",");
                for (int j = 0; j <=i; j++) {
                    arr[j] = false;
                }
            }
        }
    }
    public static void D1_Queens_teacher(int tqp,int tq,boolean[] arr,String ans,int lastbox){
        if(tqp==tq){
            System.out.println(ans);
            return;
        }
        for (int i = lastbox+1; i < arr.length; i++) {
            arr[i] = true;
            D1_Queens_teacher(tqp+1,tq,arr,ans+"q"+tqp+" at " +i+", ",i);
            arr[i] = false;
        }
    }
}
