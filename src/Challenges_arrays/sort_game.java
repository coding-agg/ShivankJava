package Challenges_arrays;

import java.util.Scanner;

public class sort_game {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int search = scn.nextInt();
        int test = scn.nextInt();
        String[][] newarr = new String[test][2];
        for (int i = 0; i < newarr.length; i++) {
            newarr[i][0] = scn.next();
            newarr[i][1] = scn.next();
        }
        for (int i = 0; i < newarr.length; i++) {
        }
    }
    public static String[] sort(String[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i].compareTo(arr[j])>0){
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                else if(arr[i].compareTo(arr[j])<0 && arr[j].contains(arr[i])){
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
