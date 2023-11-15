package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class Ganeshapattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        int B = 1 ;
        while(A<=N){
            int C = 1 ;
            while(C<=N){
                if(A == 1){
                    if(C==1 || C>=(N+1)/2){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else if(A>1 && A<(N+1)/2){
                    if(C==1 || C == (N+1)/2){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else if(A==(N+1)/2){
                    System.out.print("*");
                }
                else if(A>(N+1)/2 && A<N){
                    if(C==(N+1)/2 || C==N){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else{
                    if(C<=(N+1)/2 || C == N){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                C = C+1 ;
            }
            A = A+1 ;
            System.out.println();
        }
    }
}
