package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class armstrongnumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = N ;
        int B = 0 ;
        int C = 0 ;
        int D = N ;
        int E = 0 ;
        while(D!=0){
            D = D/10 ;
            E = E+1 ;
        }
        while(A>0){
            B = A%10 ;
            A = A/10 ;
            C = C + (int)Math.pow(B,E) ;
        }
        if (C == N){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}
