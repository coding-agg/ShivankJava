package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class quadratic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        double a = scn.nextInt() ;
        double b = scn.nextInt() ;
        double c = scn.nextInt() ;
        double D = Math.pow(b,2) - (4*a*c) ;
        int root1 = (int)((-b + Math.pow(D,0.5))/(2*a)) ;
        int root2 = (int)((-b - Math.pow(D,0.5))/(2*a)) ;
        if(D>0){
            System.out.println("Real and Distinct");
            if(root1>root2){
                System.out.println(root2+" "+root1);
            }
            else{
                System.out.println(root1+" "+root2);
            }
        }
        else if(D == 0){
            System.out.println("Real and Equal");
            System.out.println(root1+" "+root2);
        }
        else{
            System.out.println("Imaginary");
        }
    }
}
