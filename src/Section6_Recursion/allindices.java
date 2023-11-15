package Section6_Recursion;

import java.util.Scanner;

public class allindices {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[] arr = array() ;
        int data = scn.nextInt() ;
        int[] newarr = indices(arr,0,data,0) ;
        for (int i = 0; i < newarr.length; i++) {
            System.out.print(newarr[i]+" ");
        }
    }
    public static int[] indices(int[] arr,int si,int data,int count){
        if(si==arr.length){
            int[] base = new int[count] ;
            return base ;
        }
        int[] indice = null;
        if(arr[si] == data){
            indice = indices(arr,si+1,data,count+1);
        }
        else{
            indice = indices(arr,si+1,data,count);
        }
        if(arr[si] == data){
            indice[count] = si ;
        }
        return indice ;
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        return arr;
    }
}
