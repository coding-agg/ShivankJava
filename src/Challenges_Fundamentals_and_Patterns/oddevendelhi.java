package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class oddevendelhi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        int N = scn.nextInt() ;
        int A = 1 ;
        int B = 0 ;
        int D = 0 ;
        int E = 0 ;
        int Sumodd = 0 ;
        int Sumeven = 0 ;
        while(A<=N){
            B = scn.nextInt() ;
            D = B ;
            E = 0 ;
            Sumodd = 0 ;
            Sumeven = 0 ;
            while(D!=0){
                E = D%10 ;
                D = D/10 ;
                if(E%2 == 0){
                    Sumeven = Sumeven+E ;
                }
                else{
                    Sumodd = Sumodd+E ;
                }
            }
            if(Sumeven%4==0 || Sumodd%3==0){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            A = A+1 ;
        }
    }
}
