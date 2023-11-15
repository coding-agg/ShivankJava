package Challenges_Stacks_and_Queues;

import Queues.Circular_Queue;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class next_greatest {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = array();
        next_great(arr);
    }
    public static void next_great(int[] arr){

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
