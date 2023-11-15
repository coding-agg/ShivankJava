package Challenges_Stacks_and_Queues;

import java.util.Scanner;
import java.util.Stack;

public class reverse_stack_using_recursion {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        int test = scn.nextInt();
        for (int i = 0; i < test; i++) {
            s1.push(scn.nextInt());
        }
    }
}
