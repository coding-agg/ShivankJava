package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class Hollowrhombuspattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        int ns = N-1 ;
        int nd = N ;
        while(A<=N){
            for(int cs = 1 ; cs<=ns ; cs = cs+1){
                System.out.print(" ");
            }
            for(int cd = 1 ; cd<=nd ; cd = cd+1){
                if(A == 1 || A == N){
                    System.out.print("*");
                }
                else{
                    if(cd == 1 || cd == nd){
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
            }
            A = A+1 ;
            ns = ns-1 ;
            System.out.println();
        }
    }
}
