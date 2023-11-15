package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class mex_array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int test = scn.nextInt();
        while(test-->0){
            int num = scn.nextInt();
            int[] arr = new int[num];
            int max = 0;
            for (int i = 0; i < num; i++) {
                arr[i] = scn.nextInt();
                if(arr[i]>max){
                    max = arr[i];
                }
            }
            int[] newarr = new int[max+1];
            for (int i = 0; i <num ; i++) {
                newarr[arr[i]]++;
            }
            int[] min = new int[max+1];
            min[0] = newarr[0];
            for (int i = 1; i <max+1 ; i++) {
                min[i] = Math.min(min[i-1],newarr[i]);
            }
            ArrayList<Integer> array = new ArrayList<>();
            int sum = 0;
            while(min[0]!=0){
                for (int i = 0; i < max+1; i++) {
                    if(min[i]==0){
                        array.add(i);
                        sum+=i;
                        break;
                    }
                    if(i == max){
                        if(min[i]!=0){
                            array.add(i+1);
                            sum+=i+1;
                        }
                    }
                    min[i]--;
                }
            }
            for (int i = 0; i < num-sum; i++) {
                array.add(0);
            }
            int size = array.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                System.out.print(array.get(i)+" ");
            }
            System.out.println();
        }
    }

}
