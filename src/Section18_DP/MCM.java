package Section18_DP;

public class MCM {
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
        int[] arr = {4,2,3,5,1};
        int[][] strg = new int[arr.length][arr.length];
        startAlgo();
        System.out.println(MCMRecursion(arr,0,arr.length-1));
        System.out.println("mazepath normal "+endAlgo()+" ms");

        startAlgo();
        System.out.println(MCMDP(arr,0,arr.length-1,strg));
        System.out.println("mazepath dp "+endAlgo()+" ms");

        startAlgo();
        System.out.println(MCMIterative(arr));
        System.out.println("mazepath IS "+endAlgo()+" ms");

    }
    public static int MCMRecursion(int[] arr,int si,int ei){
        if(si+1 == ei){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = si+1; k < ei; k++) {
            int fp = MCMRecursion(arr,si,k);
            int sp = MCMRecursion(arr,k,ei);
            int sw = arr[si] * arr[k] * arr[ei];
            int total = fp + sp + sw;
            if(total<min){
                min = total;
            }

        }
        return min;
    }
    public static int MCMDP(int[] arr,int si,int ei,int[][] strg){
        if(si+1 == ei){
            return 0;
        }
        if(strg[si][ei] != 0){
            return strg[si][ei];
        }
        int min = Integer.MAX_VALUE;
        for (int k = si+1; k < ei; k++) {
            int fp = MCMDP(arr,si,k,strg);
            int sp = MCMDP(arr,k,ei,strg);
            int sw = arr[si] * arr[k] * arr[ei];
            int total = fp + sp + sw;
            if(total<min){
                min = total;
            }
        }
        strg[si][ei] = min;
        return min;
    }
    public static int MCMIterative(int[] arr){
        int n = arr.length;
        int[][] strg = new int[n][n];
        for (int slide = 1; slide <n ; slide++) {
            for (int si = 0; si < n-slide; si++) {
                int ei = si+slide;
                if(si+1 == ei){
                    strg[si][ei] = 0;
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for (int k = si+1; k < ei; k++) {
                        int fp = strg[si][k];
                        int sp = strg[k][ei];
                        int sw = arr[si]*arr[k]*arr[ei];
                        int total = fp+sp+sw;
                        if(total<min){
                            min = total;
                        }
                    }
                    strg[si][ei] = min;
                }
            }
        }
        for (int i = 0; i < strg.length; i++) {
            for (int j = 0; j < strg.length; j++) {
                System.out.print(strg[i][j]+ " ");
            }
            System.out.println();
        }
        return strg[0][n-1];
    }
}
