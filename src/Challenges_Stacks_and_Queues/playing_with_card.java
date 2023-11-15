package Challenges_Stacks_and_Queues;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class playing_with_card {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scn.nextInt();
        int iterate = scn.nextInt();
        Stack<Integer> arr = array(length);
        Stack<Integer> s1 = new Stack<>();
        playing(arr,iterate);
    }
    public static Stack<Integer> array(int length){
        Stack<Integer> arr = new Stack<>();
        for (int i = 0; i <length ; i++) {
            arr.push(scn.nextInt());
        }
        return arr;
    }
    public static void playing(Stack<Integer> arr,int iterate){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (int i = 1; i <= iterate; i++) {
            while (!arr.isEmpty()){
                if(arr.peek()%(nextprime(i))==0){
                    s1.push(arr.pop());
                }
                else{
                    s2.push(arr.pop());
                }
            }
            while (!s1.isEmpty()){
                System.out.println(s1.pop());
            }
            if(i==iterate){
                while (!s2.isEmpty()){
                    System.out.println(s2.pop());
                }
            }
            else{
                Stack<Integer> temp = s2;
                s2 = arr;
                arr = temp;
            }
        }
    }
    public static boolean[] SOE(int n){
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
        return primes;
    }
    public static int nextprime(int i){
        boolean[] primes = SOE(100000);
        int n = 0;
        for (int j = 2; j <primes.length && i>0 ; j++) {
            if(primes[j]){
                i--;
                n = j;
            }
        }
        return n;
    }
}
