package Section18_DP;

public class count_board_path {
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
        int n = 30;
        int[] strg = new int[n+1];
        startAlgo();
        System.out.println(cbp(n,0));
        System.out.println("cbp normal "+endAlgo()+" ms");

        startAlgo();
        System.out.println(cbpRS(n,0,strg));
        System.out.println("cbp DP "+endAlgo()+" ms");

        startAlgo();
        System.out.println(cbpIS(n,0));
        System.out.println("cbp IS "+endAlgo()+" ms");
    }
    public static int cbp(int end,int curr){
        if(end == curr){
            return 1;
        }
        if(curr>end){
            return 0;
        }
        int count = 0;
        for (int dice = 1; dice <=6 ; dice++) {
            count = count + cbp(end,curr+dice);
        }
        return count;
    }
    public static int cbpRS(int end,int curr,int[] strg){
        if(end == curr){
            return 1;
        }
        if(curr>end){
            return 0;
        }
        if(strg[curr]!=0){
            return strg[curr];
        }
        int count = 0;
        for (int dice = 1; dice <=6 ; dice++) {
            count = count + cbpRS(end,curr+dice,strg);
        }
        strg[curr] = count;
        return count;
    }
    public static int cbpIS(int end,int curr){
        int[] strg = new int[end+1];
        strg[end] = 1;
        for (int i = end-1; i >=curr ; i--) {
            int count = 0;
            for (int dice = 1; dice <=6 && dice+i<strg.length; dice++) {
                count = count+strg[dice+i];
            }
            strg[i] = count;
        }
        return strg[curr];
    }
}
