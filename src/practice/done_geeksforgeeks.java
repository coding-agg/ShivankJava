package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class done_geeksforgeeks {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        System.out.println(subsetSums(arr,arr.size()));
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> arr1 = subsetSums(arr,0,0,arr.size());
        Collections.sort(arr1);
        return arr1;
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr,int num,int sum,int N){
        if(num>=N){
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(sum);
            return ar;
        }
        ArrayList<Integer> arr1 = subsetSums(arr,num+1,sum,N);
        ArrayList<Integer> arr2 = subsetSums(arr,num+1,sum+arr.get(num),N);
        arr1.addAll(arr2);
        return arr1;
    }

}
