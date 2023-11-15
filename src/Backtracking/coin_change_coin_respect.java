package Backtracking;

import java.util.Scanner;

public class coin_change_coin_respect {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = array();
        int sum = scn.nextInt();
        coin("",arr,sum);
    }
    public static void coin(String str, int[] arr, int sum){
        if(sum==0){
            System.out.println(str);
            return;
        }
        if(arr.length==0 || sum<0){
            return;
        }
        coin(str+arr[0],arr,sum-arr[0]);
        int[] array = new int[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            array[i-1] = arr[i];
        }
        arr = array;
        coin(str,arr,sum);
    }
    public static int[] array(){
        int num = scn.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
    public static void coin_new(String str, int[] arr, int sum ,int vitind){
        if(sum==0){
            System.out.println(str);
            return;
        }
        if(vitind==arr.length || sum<0){
            return;
        }
        coin_new(str+arr[vitind],arr,sum-arr[vitind],vitind);
        coin_new(str,arr,sum,vitind+1);
    }
}
