package Challenges_Stacks_and_Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class strongest_fighter {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Deque<Integer> s1 = new LinkedList<>();
        int[] arr = array();
        int k = scn.nextInt();
        int i;
        for (i=0; i < k; i++) {
            while(!s1.isEmpty() && arr[i]>arr[s1.getLast()]){
                s1.removeLast();
            }
            s1.addLast(i);
        }
        for (; i <arr.length ; i++) {
            System.out.print(arr[s1.getFirst()]+" ");
            while(!s1.isEmpty() && s1.getFirst()<=i-k){
                s1.removeFirst();
            }
            while (!s1.isEmpty() && arr[i]>arr[s1.getLast()]){
                s1.removeLast();
            }
            s1.addLast(i);
        }
        System.out.print(arr[s1.peek()]+" ");
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
