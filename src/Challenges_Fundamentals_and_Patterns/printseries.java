package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class printseries {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int n = scn.nextInt() ;
        int A = 1 ;
        int B = 0 ;
        while(A<=N){
            B = 3*A + 2 ;
            if(B%n == 0){
                N = N+1 ;
            }
            else{
                System.out.print(B);
                System.out.println();
            }
            A = A+1 ;
        }
    }
}
