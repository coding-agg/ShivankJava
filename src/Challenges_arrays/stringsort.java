package Challenges_arrays;

import java.util.Scanner;

public class stringsort {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        String[] arr = array() ;
        arr = sort(arr) ;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static String[] array(){
        String[] arr = new String[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.next() ;
        }
        return arr ;
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
