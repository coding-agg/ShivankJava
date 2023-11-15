package Section10_OOPS_and_Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Balanced_Paranthesis {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Character> s1 = new Stack<>();
        String str = scn.next();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='{' || str.charAt(i)=='[' || str.charAt(i)=='('){
                s1.push(str.charAt(i));
            }
            else if (str.charAt(i)=='}' || str.charAt(i)==']' || str.charAt(i)==')') {
                if(!s1.empty() && str.charAt(i)=='}' && s1.peek()=='{'){
                    s1.pop();
                }
                else if(!s1.empty() && str.charAt(i)==']' && s1.peek()=='['){
                    s1.pop();
                }
                else if(!s1.empty() && str.charAt(i)==')' && s1.peek()=='('){
                    s1.pop();
                }
                else{
                    num=1;
                    break;
                }
            }
        }
        if(num==1){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
        }
    }
}
