package Challenges_Stacks_and_Queues;

import java.util.Scanner;
import java.util.Stack;

public class stock_span {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = array();
        arr = stock(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] stock(int[] arr){
        int[] array = new int[arr.length];
        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s1.isEmpty() && arr[s1.peek()]<=arr[i]){
                s1.pop();
            }
            if (s1.isEmpty()){
                array[i] = i+1;
            }
            else{
                array[i] = i-s1.peek();
            }
            s1.push(i);
        }
        return array;
    }
    public static int[] array(){
        int length = scn.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
