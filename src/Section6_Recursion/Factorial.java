package Section6_Recursion;

import java.util.Scanner;

public class Factorial {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        int result = PDFactorial(scn.nextInt()) ;
        System.out.println(result);
    }
    public static int PDFactorial(int n){
        if(n==0){
            return 1;
        }
        int fnm1 = PDFactorial(n-1) ;
        int fn = fnm1*n ;
        return fn;
    }
}
