package Section18_DP;

import java.util.Scanner;

public class fibonacci {
    public static long start;
    public static long end;
    public static void startAlgo(){
        start = System.currentTimeMillis();
    }
    public static long endAlgo(){
        end = System.currentTimeMillis();
        return end-start;
    }
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] strg = new int[n+1];

        startAlgo();
        System.out.println(fb(n));
        System.out.println("Fib normal "+endAlgo()+" ms");

        startAlgo();
        System.out.println(fibRS(n,strg));
        System.out.println("Fib DP "+endAlgo()+" ms");

        startAlgo();
        System.out.println(fibIS(n));
        System.out.println("Fib IS "+endAlgo()+" ms");
    }
    public static int fb(int n){
        if(n==1){
            return n;
        }
        if(n==0){
            return n;
        }
        int fb1 = fb(n-1);
        int fb2 = fb(n-2);
        return fb1+fb2;
    }
    public static int fibRS(int n,int[] strg){
        if(n==1){
            return n;
        }
        if(n==0){
            return n;
        }
        if(strg[n]!=0){
            return strg[n];
        }
        int fb1 = fibRS(n-1,strg);
        int fb2 = fibRS(n-2,strg);
        int fn = fb1+fb2;
        strg[n] = fn;
        return fn;
    }
    public static int fibIS(int n){
        int[] strg = new int[n+1];
        strg[0] = 0;
        strg[1] = 1;
        for (int i = 2; i <=n ; i++) {
            strg[i] = strg[i-1]+strg[i-2];
        }
        return strg[n];
    }
}
