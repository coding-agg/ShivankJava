package Section9_Time_and_Space_Complexity;

import java.util.Scanner;

public class dutch_national_flag {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = array(scn.nextInt());
        dutch(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
    public static int[] array(int size){
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= scn.nextInt();
        }
        return arr;
    }
    public static void dutch(int[] arr){
        int lo = 0;
        int hi = arr.length-1;
        int mid = 0;
        while(mid<=hi){
            while(mid<arr.length && arr[lo]==0){
                lo++;
                mid++;
            }
            while(arr[hi] == 2){
                hi--;
            }
            if(mid<arr.length) {
                if (arr[mid] == 0) {
                    int temp = arr[mid];
                    arr[mid] = arr[lo];
                    arr[lo] = temp;
                    mid++;
                    lo++;
                } else if (arr[mid] == 1) {
                    mid++;
                } else {
                    int temp = arr[mid];
                    arr[mid] = arr[hi];
                    arr[hi] = temp;
                    hi--;
                }
            }
        }
    }
}
