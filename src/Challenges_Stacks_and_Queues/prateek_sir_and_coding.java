package Challenges_Stacks_and_Queues;

import java.util.Scanner;
import java.util.Stack;

public class prateek_sir_and_coding {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int test = s.nextInt();
        Stack<Integer> s1 = new Stack<>();
        for (int i = 0; i < test; i++) {
            int input = s.nextInt();
            if(input==1){
                if(s1.isEmpty()){
                    System.out.println("No Code");
                }
                else{
                    System.out.println(s1.pop());
                }
            }
            else if (input == 2) {
                s1.push(s.nextInt());
            }
        }
    }
}
