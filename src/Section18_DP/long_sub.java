package Section18_DP;

public class long_sub {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(longest(arr));
    }
    public static int longest(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int strg[] = new int[arr.length];
        strg[0] = 1;
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            strg[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    if(strg[i]<strg[j]+1){
                        strg[i] = strg[j]+1;
                    }
                }
            }
            if(strg[i]>ans){
                ans = strg[i];
            }
        }
        return ans;
    }
}
