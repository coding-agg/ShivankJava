package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class patterntriangle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int A = 1;
        int B = N;
        int D = N;
        int E = 1;
        int F = 1;
        while (A <= N) {
            int C = 1;
            E = F;
            while (C <= N * 2 - 1) {
                if (C >= B && C <= D) {
                    System.out.print(E + " ");
                    if (C < N) {
                        E = E + 1;
                    } else {
                        E = E - 1;
                    }
                } else {
                    System.out.print("  ");
                }
                C = C + 1;
            }
            B = B - 1;
            D = D + 1;
            A = A + 1;
            F = F + 1;
            System.out.println();
        }
    }
}
