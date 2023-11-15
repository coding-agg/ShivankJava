package Challenges_arrays;

import java.util.Scanner;

public class sumoftwoarrays {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[] arr1 = array() ;
        int[] arr2 = array() ;
        int[] sumarr = sum(arr1,arr2) ;
        for (int i = 0; i < sumarr.length; i++) {
            if(i==0 && sumarr[i]==0){
            }
            else{
                System.out.print(sumarr[i]+", ");
            }
        }
        System.out.print("END");
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        return arr ;
    }
    public static int[] sum(int[] array1,int[] array2){
        int length;
        int longest ;
        if(array1.length>array2.length){
            length = array2.length ;
            longest = array2.length ;
        }
        else{
            length = array1.length ;
            longest = array2.length ;
        }
        int[] arr = new int[longest+1] ;
        for (int i = 0; i < longest; i++) {
            if(i<length){
                if(array1[array1.length-i-1]+array2[array2.length-i-1]<10){
                    arr[arr.length-i-1] += array1[array1.length-i-1]+array2[array2.length-i-1] ;
                }
                else{
                    arr[arr.length-i-1] += array1[array1.length-i-1]+array2[array2.length-i-1]-10;
                    arr[arr.length-i-2]+=1 ;
                }
            }
            else{
                if(array1.length>array2.length){
                    arr[arr.length-i-1] += array1[array1.length-i-1] ;
                }
                else{
                    arr[arr.length-i-1] += array2[array2.length-i-1] ;
                }
            }
        }
        return arr ;
    }
}
