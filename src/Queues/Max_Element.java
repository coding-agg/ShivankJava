package Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Max_Element {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = {1,3,2,1,4,5,2,3,6};
        int k = scn.nextInt();
        max_element(arr,k);

    }
    public static void max_element(int[] arr,int k){
        Deque<Integer> q = new LinkedList<>();
        int i;
        for (i = 0; i <k ; i++) {
            while(!q.isEmpty() && arr[i]>arr[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        for (; i <arr.length ; i++) {
            System.out.println(arr[q.getFirst()]+" ");
            while (!q.isEmpty() && q.getFirst()<=i-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && arr[i]>arr[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        System.out.println(arr[q.getFirst()]);
    }
}
