package practice;

import java.util.LinkedList;
import java.util.Scanner;

public class sorting_techniques {

    public static void main(String[] args) {
        int[] arr = {1,5,4,3,7,8,9};
        quick(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void bubble(int[] arr){
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selection(int[] arr){
        for (int i = arr.length-1; i >0 ; i--) {
            int num = arr[0];
            int ind = 0;
            for (int j = 0; j <= i; j++) {
                if(arr[j]>num){
                    num = arr[j];
                    ind = j;
                }
            }
            int temp = arr[i];
            arr[i] = num;
            arr[ind] = temp;
        }
    }
    public static void insertion(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int current = arr[i];
            while(j>0 && current<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = current;
        }
    }
    public static void mergesort(int[] arr){
        int[] arr1 = mergesort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr1[i];
        }
    }
    public static int[] mergesort(int[] arr,int lo,int hi){
        if(lo == hi){
            int[] array = {arr[hi]};
            return array;
        }
        int mid = (lo+hi)/2;
        int[] arr1 = mergesort(arr,lo,mid);
        int[] arr2 = mergesort(arr,mid+1,hi);
        return merge(arr1,arr2);
    }
    public static int[] merge(int[] arr1,int[] arr2){
        int[] arr = new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>arr2[j]){
                arr[k] = arr2[j];
                k++;
                j++;
            }
            else{
                arr[k] = arr1[i];
                i++;
                k++;
            }
        }
        while(i<arr1.length){
            arr[k] = arr1[i];
            k++;
            i++;
        }
        while(j<arr2.length){
            arr[k] = arr2[j];
            j++;
            k++;
        }
        return arr;
    }
    public static void quick(int[] arr){
        quick(arr,0,arr.length-1);
    }
    public static void quick(int[] arr,int ini,int fin){
        if(ini<fin) {
            int partind = partition(arr, ini, fin);
            quick(arr, ini, partind - 1);
            quick(arr, partind + 1, fin);
        }
    }
    public static int partition(int[] arr,int ini,int fin){
        int part = arr[fin];
        int i = ini-1;
        for (int j = ini; j <fin ; j++) {
            if(arr[j]<part){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[fin];
        arr[fin] = temp;
        return i+1;
    }
    LinkedList<Integer> lk = new LinkedList<>();
}
