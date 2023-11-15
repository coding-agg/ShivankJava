package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        int B = 0 ;
        int D = 1 ;
        int E = 0 ;
        while(A<=N){
            int C = 1 ;
            while(C <=A){
                System.out.print(B+" ");
                E = B+D ;
                B = D ;
                D = E ;
                C = C+1 ;
            }
            A = A+1 ;
            System.out.println();
        }
    }
}
