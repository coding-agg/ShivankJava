package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class patternmountain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        int nd = 1 ;
        int ns = N*2-3 ;
        int nd2 = 1 ;
        int i = 1 ;
        while(A<=N){
            for (int cd = 1 ; cd<=nd ; cd = cd+1){
                System.out.print(cd+" ");
            }
            for(int cs = 1 ; cs<=ns ; cs = cs+1){
                System.out.print("  ");
            }
            for(int cd2 = 1 ; cd2<=nd2 ; cd2 = cd2+1) {
                System.out.print(i + " ");
                i = i - 1;
            }
            A = A+1 ;
            if(A<N){
                nd = nd+1 ;
                ns = ns-2 ;
                nd2 = nd2+1 ;
                i = A ;
            }
            else{
                nd = nd+1 ;
                ns = ns-2 ;
                nd2 = N-1 ;
                i = N-1 ;
            }
            System.out.println();
        }
    }
}
