package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class Basiccalculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in) ;
        char N = ' ' ;
        int A = 0 ;
        int B = 0 ;
        while(N != 'X' || N !='x'){
            N = scn.next().charAt(0) ;
            if(N == '+' || N == '-' || N == '*' || N == '/' || N == '%'){
                A = scn.nextInt() ;
                B = scn.nextInt() ;
                if(N == '+'){
                    System.out.print(A+B);
                }
                else if(N == '-'){
                    System.out.print(A-B);
                }
                else if(N == '*'){
                    System.out.print(A*B);
                }
                else if(N == '/'){
                    if(B>0){
                        System.out.print(A/B);
                    }
                }
                else if(N == '%'){
                    if(B>0){
                        System.out.print(A%B);
                    }
                }
            }
            else{
                if(N == 'X' || N == 'x'){
                    break ;
                }
                else{
                    System.out.print("Invalid operation. Try again.");
                }
            }
            System.out.println();
        }

    }
}
