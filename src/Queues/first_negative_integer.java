package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class first_negative_integer {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = {12,-1,-7,8,-15,30,16,28};
        int k = 4;
        first_negative(arr,k);
    }
    public static void first_negative(int[] arr,int k){
        Queue<Integer> s1 = new LinkedList<>();
        int i = 0;
        for (; i <k ; i++) {
            if(arr[i]<0){
                s1.add(i);
            }
        }
        for (; i <arr.length ; i++) {
            if(s1.isEmpty()){
                System.out.print(0+" ");
            }
            else {
                System.out.print(arr[s1.peek()] + " ");
            }
            while(!s1.isEmpty() && s1.peek()<=i-k){
                s1.remove();
            }
            if(arr[i]<0){
                s1.add(i);
            }
        }
        if(!s1.isEmpty()){
            System.out.print(arr[s1.peek()]+" ");
        }
        else{
            System.out.println(0+" ");
        }
    }
}
