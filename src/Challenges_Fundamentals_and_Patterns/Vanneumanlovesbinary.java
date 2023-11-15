package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class Vanneumanlovesbinary {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        int Num = 0 ;
        int C = 0 ;
        int Sum = 0 ;
        int D = 0 ;
        while(A<=N){
            C = 0 ;
            Sum = 0 ;
            Num = scn.nextInt() ;
            D = 0 ;
            while(Num!=0){
                C = Num%10 ;
                Num = Num/10 ;
                Sum = Sum+(C*(int)(Math.pow(2,D))) ;
                D = D+1 ;
            }
            System.out.println(Sum);
            A = A+1 ;
        }
    }
}
