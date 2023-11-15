package Section9_Time_and_Space_Complexity;

import java.util.Arrays;
import java.util.Scanner;

public class soe {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        SOE(scn.nextInt());
    }
    public static void SOE(int n){
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        primes[0] =primes[1]= false;
        for (int table = 2; table*table <=n; table++) {
            if(primes[table]==true) {
                for (int mult = 2; mult * table <= n; mult++) {
                    primes[table * mult] = false;
                }
            }
        }
        for (int i = 0; i < primes.length; i++) {
            if(primes[i] == true){
                System.out.print(i+" ");
            }
        }
    }
}
