package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class hollowdiamondpattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int A = 1;
        int B = (N + 1) / 2;
        int D = (N + 1) / 2;
        while (A <= N) {
            int C = 1;
            while (C <= N) {
                if (C > B && C < D) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
                C = C + 1;
            }
            if (A < (N + 1) / 2) {
                B = B - 1;
                D = D + 1;
            } else {
                B = B + 1;
                D = D - 1;
            }
            A = A + 1;
            System.out.println();
        }
    }
}
