package Section9_Time_and_Space_Complexity;

import java.util.Scanner;

public class power_function_in_logN {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int x = scn.nextInt();
        int n = scn.nextInt();
        int result = power(x,n);
        System.out.println(result);
    }
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        int ans = 0 ;
        int result = 0 ;
        ans = power( x, n/2);
        if(n%2==0){
            result = ans*ans;
        }
        else{
            result = ans*ans*x;
        }
        return result;
    }
}
