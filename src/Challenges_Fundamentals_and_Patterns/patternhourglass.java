package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class patternhourglass {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        int ns = 0 ;
        int nd = N*2+1 ;
        int D = N ;
        int i = 1 ;
        while(A<=N*2+1){
            for(int cs = 1 ; cs<=ns ; cs = cs+1){
                System.out.print("  ");
            }
            for(int cd = 1 ; cd<=nd ; cd = cd+1){
                System.out.print(D+" ");
                if(cd<(nd+1)/2){
                    D = D-1 ;
                }
                else{
                    D = D+1 ;
                }
            }

            if (A<=(N*2+1)/2){
                D = N-A ;
                ns = ns+1 ;
                nd = nd-2 ;
            }
            else{
                D = i;
                i = i+1 ;
                ns  = ns-1 ;
                nd = nd+2 ;
            }
            System.out.println();
            A = A+1 ;
        }
    }
}
