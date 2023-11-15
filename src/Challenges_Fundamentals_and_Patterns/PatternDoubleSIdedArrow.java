package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class PatternDoubleSIdedArrow {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        int ns = N-1 ;
        int nd = 1 ;
        int ns2 = -1 ;
        int nd2 = 1 ;
        int B = (N+1)/2 ;
        int D = 1 ;
        int i = (N-1)/2 ;
        while(A<=N){
            for (int cs = 1 ; cs<=ns ; cs = cs+1){
                System.out.print("  ");
            }
            for (int cd = 1 ; cd<=nd ; cd=cd+1){
                System.out.print(D+" ");
                D = D-1 ;
            }
            for(int cs2 = 1; cs2<=ns2 ;cs2=cs2+1){
                if(A>1 && A<N){
                    System.out.print("  ");
                }
                else{
                }
            }
            for(int cd2 = 1 ; cd2<=nd2 ; cd2 = cd2+1){
                if(A>1 && A<N){
                    System.out.print(cd2+" ");
                }
                else{
                }
            }
            if(A<B){
                D = A+1 ;
                ns = ns-2 ;
                nd = nd+1 ;
                ns2 = ns2+2 ;
                nd2 = nd2+1 ;
            }
            else{
                D = i ;
                ns = ns+2 ;
                nd = nd-1 ;
                ns2 = ns2-2 ;
                nd2 = nd2-1 ;
                i = i-1 ;
            }
            A = A+1 ;
            System.out.println();
        }
    }
}
