package Section6_Recursion;

import java.util.Scanner;

public class fibonacci {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int n = scn.nextInt() ;
        System.out.println(fibonnaci(n));
    }
    public static int fibonnaci(int n){
        if(n==0){
            return 0 ;
        }
        if(n==1){
            return 1 ;
        }
        int fib1 = fibonnaci(n-1) ;
        int fib2 = fibonnaci(n-2) ;
        int fib = fib1+fib2 ;
        return fib ;
    }
}
