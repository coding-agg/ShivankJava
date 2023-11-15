package Challenges_DP;

import java.util.Scanner;

public class ugly_numbers_incomplete {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        boolean[] array = prime();
        int test = scn.nextInt();
        for (int i = 0; i < test; i++) {
            int num = scn.nextInt();
            int ans = 1;
            for (int j = 1; j <= num; j++) {
                while(!array[ans]){
                    ans++;
                }
                if(j == num){
                    continue;
                }
                ans++;
            }
            System.out.println(ans);
        }
    }
    public static boolean[] prime(){
        boolean[] array = new boolean[100001];
        array[1] = true;
        for (int i = 2; i <=100000 ; i = i+2) {
            array[i] = true;
        }
        for (int i = 3; i <100000 ; i = i+3) {
            array[i] = true;
        }
        for (int i = 5; i <100000 ; i = i+5) {
            array[i] = true;
        }
        return array;
    }
}
