package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class simpleinput {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int Sum = 0 ;
        int N = 0 ;
        while(Sum>=0){
            N = scn.nextInt() ;
            Sum = Sum+N ;
            if(Sum>=0){
                System.out.println(N);
            }else{
            }
        }
    }
}
