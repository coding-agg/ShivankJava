package Section18_DP;

import java.util.Scanner;

public class wine_problem {
    static Scanner scn = new Scanner(System.in);
    public static long start;
    public static long end;
    public static void startAlgo(){
        start = System.currentTimeMillis();
    }
    public static long endAlgo(){
        end = System.currentTimeMillis();
        return end-start;
    }
    public static void main(String[] args) {
        int length = scn.nextInt();
        int[] arr = array(length);
        int[][] strg = new int[length+1][length+1];
        startAlgo();
        System.out.println(wine(arr,0,arr.length-1,1));
        System.out.println("wine normal "+endAlgo()+" ms");

        startAlgo();
        System.out.println(wineDP(arr,0,arr.length-1,strg));
        System.out.println("wine dp "+endAlgo()+" ms");
//
//        startAlgo();
//        System.out.println();
//        System.out.println("wine IS "+endAlgo()+" ms");

    }
    public static int[] array(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
    public static int wine(int[] arr,int ini,int fi,int year){
        if(ini==fi){
            return arr[ini]*year;
        }
        int ans1 = wine(arr,ini+1,fi,year+1) + arr[ini]*year;
        int ans2 = wine(arr,ini,fi-1,year+1) + arr[fi]*year;
        int ans = Math.max(ans1,ans2);
        return ans;
    }
    public static int wineDP(int[] arr,int ini,int fi,int[][] strg){
        int year = arr.length-(fi-ini+1)+1;
        if(ini==fi){
            return arr[ini]*year;
        }
        if(strg[ini][fi]!=0){
            return strg[ini][fi];
        }
        int ans1 = wineDP(arr,ini+1,fi,strg) + arr[ini]*year;
        int ans2 = wineDP(arr,ini,fi-1,strg) + arr[fi]*year;
        int ans = Math.max(ans1,ans2);
        strg[ini][fi] = ans;
        return ans;
    }
    public static int wineIT(int[] arr){
        int n = arr.length;
        int[][] strg = new int[n][n];
        for (int slide = 0; slide <=n-1 ; slide++) {
            for (int si = 0; si <=n-slide-1; si++) {
                int ei = si+slide;

                int yr = arr.length-(ei-si+1)+1;
                if(si == ei){
                    strg[si][ei] = arr[si]*yr;
                }
                else{
                    int start = strg[si+1][ei] + arr[si]*yr;
                    int end = strg[si][ei-1] + arr[ei]*yr;
                    int ans = Math.max(start,end);
                    strg[si][ei] = ans;
                }
            }
        }
        return strg[0][n-1];
    }

}
