package Section9_Time_and_Space_Complexity;

import java.util.Scanner;

public class merge_sort {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = array(scn.nextInt());
        arr = mergesort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
    public static int[] mergesort(int[] arr,int lo, int high){
        if(lo==high){
            int[] l = {arr[lo]};
            return l;
        }
        int mid = (lo+high)/2 ;
        int[] firsthalf = mergesort(arr,lo,mid);
        int[] secondhalf = mergesort(arr,mid+1,high);
        int[] merge = mergeTwoSortedArrays(firsthalf,secondhalf);
        return merge;
    }
    public static int[] mergeTwoSortedArrays(int[] arr1,int[] arr2){
        int[] merged = new int[arr1.length+arr2.length] ;
        int i=0;
        int j=0;
        int k=0;
        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]<=arr2[j]){
                merged[k]=arr1[i];
                i++;
                k++;
            }
            else{
                merged[k]=arr2[j];
                j++;
                k++;
            }
        }
        if(i==arr1.length){
            while(j<arr2.length){
                merged[k]=arr2[j];
                j++;
                k++;
            }
        }
        if(j==arr2.length){
            while(i<arr1.length){
                merged[k]=arr1[i];
                i++;
                k++;
            }
        }
        return merged;
    }
    public static int[] array(int size){
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= scn.nextInt();
        }
        return arr;
    }
}
