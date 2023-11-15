package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class ManmohanLovesPattern1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        while(A<=N){
            int C = 1 ;
            while(C<=A){
                if (C==1 || C==A){
                    System.out.print(1);
                }
                else{
                    if(A%2==0){
                        System.out.print(0);
                    }
                    else{
                        System.out.print(1);
                    }
                }
                C = C+1 ;
            }
            A = A+1 ;
            System.out.println();
        }
    }
}
