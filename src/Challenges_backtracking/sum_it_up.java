package Challenges_backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class sum_it_up {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int sum = scn.nextInt();
        arr = mergesort(arr,0,arr.length-1);
        sum(arr,0,sum,"",arr.length,sum);

    }
    public static void sum(int[] arr,int ini,int sum,String str,int fin,int sum2){
        if(sum==0){
            System.out.println(str);
            return;
        }
        if(ini>=fin || sum<0){
            return;
        }
        sum(arr, ini + 1, sum - arr[ini], str + arr[ini] + " ", fin,sum2);
        if(sum==sum2 && ini<fin-1 && arr[ini+1]==arr[ini]) {
            sum(arr, ini + 2, sum, str, fin, sum2);
        }
        else{
            sum(arr, ini + 1, sum, str, fin, sum2);
        }
    }
    public static int[] mergesort(int[] arr,int low,int high){
        if(low==high){
            int[] l = {arr[low]};
            return l;
        }
        int mid = (low+high)/2;
        int[] arr1 = mergesort(arr,low,mid);
        int[] arr2 = mergesort(arr,mid+1,high);
        int[] mainarr = merge(arr1,arr2);
        return mainarr;
    }
    public static int[] merge(int[] arr1,int[] arr2){
        int[] arr = new int[arr1.length+arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(k<arr.length){
            if(i<arr1.length && j<arr2.length && arr1[i]<arr2[j]){
                arr[k] = arr1[i];
                i++;
                k++;
            }
            if(i<arr1.length && j<arr2.length && arr1[i]>=arr2[j]){
                arr[k] = arr2[j];
                j++;
                k++;
            }
            if(i==arr1.length){
                while(j<arr2.length){
                    arr[k] = arr2[j];
                    j++;
                    k++;
                }
            }
            if(j==arr2.length){
                while(i<arr1.length){
                    arr[k] = arr1[i];
                    i++;
                    k++;
                }
            }
        }
        return arr;
    }
}
