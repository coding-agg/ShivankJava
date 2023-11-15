package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class calculatereverse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int B = N ;
        int E = N ;
        int C = 1 ;
        int D = 0 ;
        while(B>0){
            C = B%10 ;
            B = B/10 ;
            D = (D*10)+C ;
            E = E-1 ;
        }
        System.out.print(D) ;
    }
}
