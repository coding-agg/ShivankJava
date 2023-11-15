package Challenges_backtracking;

import java.util.Scanner;

public class generate_paranthesis {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = scn.nextInt();
        paranthesis(0,0,num,"");
    }
    public static void paranthesis(int num1,int num2,int num,String str){
        if(str.length() == num*2){
            System.out.println(str);
            return;
        }
        if(num2<num1){
            paranthesis(num1,num2+1,num,str+")");
        }
        if(num1<num){
            paranthesis(num1+1,num2,num,str+"(");
        }
    }
}
