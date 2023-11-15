package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class checkprime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int a = 2;
        boolean b = true;
        while (a < N) {
            if (N % a == 0) {
                b = false;

            } else {
            }
            a = a + 1;
        }
        if (b == true) {
            System.out.println("Prime");
        } else if (b == false) {
            System.out.println("Not Prime");
        }
    }
}
