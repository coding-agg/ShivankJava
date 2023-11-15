package Section18_DP;

import java.util.Scanner;

public class count_binary {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int test = scn.nextInt();
        for (int i = 0; i < test; i++) {
            int n = scn.nextInt();
            System.out.println(count(n));
        }
    }
    public static long count(int n){
        long[] zero = new long[n];
        long[] one = new long[n];
        one[0] = 1;
        zero[0] = 1;
        for (int i = 1; i < n; i++) {
            zero[i] = zero[i-1]+one[i-1];
            one[i] = zero[i-1];
        }
        return one[n-1]+zero[n-1];
    }
}
