package Section18_DP;

public class edit_distance {
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
        String str1 = "agbggghyythhgt";
        String str2 = "acgbhhyttghcbhdg";
        startAlgo();
        System.out.println(editDistance(str1,str2));
        System.out.println("ed normal "+endAlgo()+" ms");

        startAlgo();
        System.out.println(editDistanceIterative(str1,str2));
        System.out.println("ed IS "+endAlgo()+" ms");
    }
    public static int editDistance(String s1,String s2){
        if(s1.length() == 0){
            return s2.length();
        }
        if(s2.length() == 0){
            return s1.length();
        }
        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);
        int ans = 0;
        if(s1.charAt(0) == s2.charAt(0)){
            ans = editDistance(ros1,ros2);
        }
        else{
            int f1 = 1+editDistance(ros1,ros2);
            int f2 = 1+editDistance(ros1,s2);
            int f3 = 1+editDistance(s1,ros2);
            ans = Math.min(f1,Math.min(f2,f3));
        }
        return ans;
    }
    public static int editDistanceIterative(String s1,String s2){
        int[][] ans = new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i <= s1.length(); i++) {
            ans[i][s2.length()] = s1.length()-i;
        }
        for (int i = 0; i <=s2.length(); i++) {
            ans[s1.length()][i] = s2.length()-i;
        }
        for (int i = s1.length()-1; i >=0; i--) {
            for (int j = s2.length()-1; j >=0; j--) {
                if(s1.charAt(i) == s2.charAt(j)){
                    ans[i][j] = ans[i+1][j+1];
                }
                else{
                    ans[i][j] = 1+Math.min(ans[i+1][j],Math.min(ans[i][j+1],ans[i+1][j+1]));
                }
            }
        }
        return ans[0][0];
    }
}
