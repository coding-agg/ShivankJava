package Challenges_Fundamentals_and_Patterns;
import java.lang.Math;

import java.util.Scanner;

public class binarytodecimal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 0 ;
        int C = 0 ;
        int B = N ;
        int Sum = 0 ;
        while(B!=0){
            C = B%10;
            B = B/10 ;
            Sum = Sum + (C*(int)(Math.pow(2,A))) ;
            A = A+1 ;
        }
        System.out.print(Sum);

    }
}
