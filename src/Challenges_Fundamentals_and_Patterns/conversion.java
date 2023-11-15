package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class conversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int F = scn.nextInt() ;
        int B = scn.nextInt() ;
        int C = 0 ;
        while(N <=F){
            System.out.print(N+" ");
            C = (N-32)*5/9 ;
            N = N+B ;
            System.out.print(C) ;
            System.out.println() ;
        }
    }
}
