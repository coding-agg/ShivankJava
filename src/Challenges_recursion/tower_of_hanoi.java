package Challenges_recursion;

import java.util.Scanner;

public class tower_of_hanoi {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int num = scn.nextInt();
        toh(num,"T1","T2","T3");
        int n = (int)Math.pow(2,num)-1;
        System.out.println(n);
    }
    public static void toh(int num,String t1,String t2,String t3){
        if(num==0){
            return;
        }
        toh(num-1,t1,t3,t2);
        System.out.println("Move "+num+"th disc from "+t1+" to "+t2);
        toh(num-1,t3,t2,t1);
    }
}
