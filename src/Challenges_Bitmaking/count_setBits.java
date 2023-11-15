package Challenges_Bitmaking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class count_setBits {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int test = scn.nextInt();
        for (int i = 0; i <test ; i++) {
            int num = scn.nextInt();
            System.out.println(count_set(num));
        }
    }
    public static int count_set(int n){
        int ans = 0;
        while(n !=0){
            if((n & 1) == 1){
                ans++;
            }
            n = n>>1;
        }
        return ans;
    }
}
