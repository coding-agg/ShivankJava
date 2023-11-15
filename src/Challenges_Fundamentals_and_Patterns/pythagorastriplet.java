package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class pythagorastriplet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        long N = scn.nextInt() ;
        long A = 1, B=1 ;
//        int B = 0 ;
//        int D = 0 ;
//        while((N*N)+(B*B) != (D*D)){
//            int C = 1 ;
//            while(C<=A){
//                if((N*N) + (C*C) == (A*A)){
//                    B = C ;
//                    D = A ;
//                    break ;
//                }
//                C = C+1 ;
//            }
//            A = A+1 ;
//        }

        while(B <= N){

            long temp = B*B + N*N;
            double root = Math.pow(temp, 0.5);
            System.out.println(root);
            if( root == (long) root ){
                A = (long) root;
                break;
            }
            B++;
        }

        if (B !=0 && A != 0){
            System.out.print(B+" "+A);
        }
        else{
            System.out.print(-1);
        }
    }
}
