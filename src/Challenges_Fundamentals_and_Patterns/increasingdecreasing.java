package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class increasingdecreasing {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int n = scn.nextInt() ;
        boolean result = increasedecrease(n) ;
        System.out.println(result);
    }
    public static boolean increasedecrease(int n){
        int prev = scn.nextInt() ;
        boolean isvalid = true ;
        int count = 1 ;
        boolean goingup = false ;
        while(count<n){
            int current = scn.nextInt() ;
            int diff = current-prev ;
            if(diff == 0){
                isvalid = false ;
            }
            else if(diff>0){
                goingup = true ;
            }
            else if(goingup && diff<0){
                isvalid = false ;
            }
            count++ ;
            prev = current ;
        }
        return isvalid ;
    }
}
