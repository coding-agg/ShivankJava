package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class patternwithzeroes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        while(A<=N){
            int C = 1 ;
            while(C <=A){
                if(C == 1 || C == A){
                    System.out.print(A+" ");
                }
                else{
                    System.out.print(0+" ");
                }
                C = C+1 ;
            }
            A = A+1 ;
            System.out.println();
        }
    }
}
