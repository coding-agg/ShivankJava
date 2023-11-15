package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class patternnumbersandstars1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        int nd = N ;
        int ns = 0 ;
        while(A<=N){
            for(int cd = 1 ; cd<=nd ; cd = cd+1){
                System.out.print(cd+" ");
            }
            for(int cs = 1 ; cs<ns ; cs = cs+1){
                System.out.print("* ");
            }
            A = A+1 ;
            nd = nd-1 ;
            ns = ns+2 ;
            System.out.println();
        }
    }
}
