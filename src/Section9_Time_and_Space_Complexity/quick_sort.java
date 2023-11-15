package Section9_Time_and_Space_Complexity;

import java.util.Scanner;

public class quick_sort {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = array(scn.nextInt());
        quicksort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void quicksort(int[] arr,int lo,int hi){
        if(lo>=hi){
            return;
        }

        int mid = (lo+hi)/2;
        int pivot = arr[mid];
        int left = lo ;
        int right = hi ;
        while(left<=right){
            while(arr[left]<pivot){
                left++;
            }
            while(arr[right]>pivot){
                right--;
            }
            if(left<=right){
                int temp= arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
        quicksort(arr,lo,right);
        quicksort(arr,left,hi);
    }
    public static int[] array(int size){
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= scn.nextInt();
        }
        return arr;
    }
}
