package Section6_Recursion;

import java.util.Scanner;

public class power {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int x = scn.nextInt() ;
        int n = scn.nextInt() ;
        int result = power(x,n) ;
        System.out.println(result);
    }
    public static int power(int x, int n){
        if(n==0){
            return 1 ;
        }
        int power1 = power(x,n-1) ;
        int result = x*power1 ;
        return result ;
    }

}
