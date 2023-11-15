package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class patterninvertedhourglass {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        int nd = 1 ;
        int nd2 = 1 ;
        int ns = N*2-1 ;
        int f = N ;
        int j =N ;
        int k = 1 ;
        int l = N ;
        while(A<=N*2+1){
            int i = N ;
            for(int cd = 1 ; cd<=nd ; cd = cd+1){
                System.out.print(i+" ");
                i = i-1 ;
            }
            for(int cs = 1; cs<=ns ; cs = cs+1){
                System.out.print("  ");
            }
            for(int cd2 = 1 ; cd2<=nd2 ; cd2 = cd2+1){
                System.out.print(f+" ");
                f = f+1 ;
            }
            if(A<N){
                f = j-A ;
                nd = nd+1 ;
                ns = ns-2 ;
                nd2 = nd2+1 ;
            }
            else if(A == N){
                f = 1 ;
                nd = nd+1 ;
                ns = ns - 2 ;
            }
            else{
                f = k ;
                k = k+1 ;
                nd = nd-1 ;
                ns = ns+2 ;
                nd2 = l ;
                l = l-1 ;
            }
            A = A+1 ;
            System.out.println();
        }
    }
}
