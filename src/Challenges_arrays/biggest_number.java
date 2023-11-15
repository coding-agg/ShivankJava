package Challenges_arrays;

import java.util.Scanner;

public class biggest_number {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int test = scn.nextInt();
        for (int k = 0; k < test; k++) {
            int[] arr = array();
            String[] array = s_array(arr);
            for (int i = 0; i < arr.length-1; i++) {
                for (int j = i+1; j <arr.length ; j++) {
                    String str1 = array[i]+array[j];
                    String str2 = array[j]+array[i];
                    if(str1.compareTo(str2)<0){
                        String temp1 = array[i];
                        array[i] = array[j];
                        array[j] = temp1;

                        int temp2 = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp2;
                    }
                }
            }
            String finalstr = "";
            for (int j = 0; j < arr.length; j++) {
                finalstr+=array[j];
            }
            System.out.println(finalstr);
        }
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
    public static String[] s_array(int[] arr){
        String[] array = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i]+"";
        }
        return array;
    }
}
