package Challenges_recursion;

import java.util.Scanner;

public class all_indices {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = array();
        int[] result = indices(arr,scn.nextInt(),arr.length-1);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
    public static int[] indices(int[] arr,int search,int num){
        if(arr.length==0){
            int[] l = {};
            return l;
        }
        int[] hello = new int[arr.length-1];
        for (int i = 0; i < arr.length-1; i++) {
            hello[i] = arr[i];
        }
        int[] array = indices(hello,search,num-1);
        int[] result = {};
        if(arr[arr.length-1] == search){
            result = new int[array.length+1];
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i];
            }
            result[array.length] = num;
            return result;
        }
        result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result ;
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
