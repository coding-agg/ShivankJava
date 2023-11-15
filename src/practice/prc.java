package practice;

import java.util.*;

public class prc {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int test = scn.nextInt();
        while(test-->0) {
            int mod = 1000000007;
            int num;
            int N = scn.nextInt();
            String S = scn.next();
            long ans = 0;
            for (int i = 2; i <N ; i=i+2) {
                num = 0;
                int x = S.charAt(i-2)-'0',y = S.charAt(i-1)-'0',z = S.charAt(i)-'0';
                if((x|y) == z){
                    num++;
                }
                if((x&y) == z){
                    num++;
                }
                if((x^y) == z){
                    num++;
                }
                if(ans == 0 && i == 2){
                    ans = num;
                }
                else{
                    ans = (ans*num)%mod;
                }
                if(num == 0){
                    break;
                }
            }
            System.out.println(ans);
        }
    }



    public static int minimumRightShifts(List<Integer> nums) {
        int num = nums.size();
        int ans = 0;
        int flag = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num-1; j++) {
                if(nums.get(j)>nums.get(j+1)){
                    nums.add(0,nums.remove(num-1));
                    ans++;
                    break;
                }
                if(j == num-2){
                    flag = 1;
                }
            }
            if(flag == 1){
                break;
            }
        }
        if(flag == 1){
            return ans;
        }
        for (int j = 0; j < num-1; j++) {
            if(nums.get(j)>nums.get(j+1)){
                return -1;
            }
        }
        return ans;
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int len = nums.size();
        boolean[] num = new boolean[len];
        for (int i = 0; i < len; i++) {
            num[i] = false;
        }
        for (int i = 0; i <len ; i++) {
            String str = Integer.toBinaryString(i);
            int ans = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '1'){
                    ans++;
                }
            }
            if(ans == k){
                num[i] = true;
            }
        }
        int sum=0;
        for (int i = 0; i <len ; i++) {
            if(num[i]){
                sum+=nums.get(i);
            }
        }
        return sum;
    }

    public int countWays(List<Integer> nums) {
        int num = nums.size();
        HashSet<Integer> hash = new HashSet<>();
        for (int val:nums){
            hash.add(val);
        }
        Collections.sort(nums);
        HashMap<Integer,Integer> hashm = new HashMap<>();
        for (int i = 0; i < num; i++) {
            if(hashm.containsKey(nums.get(i))){
                continue;
            }
            if(nums.get(i)>nums.get(i-1)){
                hashm.put(nums.get(i),i);
            }
        }
        long sum=0;
        for (int values : hash){
            if(hashm.get(values)==0){
                continue;
            }
            if(hashm.get(values)<=values){
                sum+=hashm.get(values);
            }

        }
        return (int)sum;
    }

    public static int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <=high ; i++) {
            int num = i;
            int len = (i+"").length();
            int sum1 = 0;
            int sum2 = 0;
            if(len%2!=0){
                continue;
            }
            for (int j = 0; j < len/2; j++) {
                sum1+=num%10;
                num/=10;
            }
            for (int j = 0; j < len/2; j++) {
                sum2+=num%10;
                num/=10;
            }
            if(sum1 == sum2){
                ans++;
            }
        }
        return ans;
    }


    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        String array[] = new String[numRows];
        int length = s.length();
        int len = 0;
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            array[j] = "";
        }
        while(length!=len){
            if(i == 0){
                while(i!=numRows && len!=length){
                    array[i] += s.charAt(len);
                    len++;
                    i++;
                }
            }
            if(i == numRows){
                i = i-2;
                while(i >0 && len!=length){
                    array[i] += s.charAt(len);
                    i--;
                    len++;
                }
            }
        }
        String ans = "";
        for (String a : array){
            ans+=a;
        }
        return ans;

    }

    public static int minimumMoves(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ans+=check0(i,j,grid);
            }
        }
        return ans;
    }
    public static int check0(int x,int y,int[][] grid){
        int ans = 0;
        while(grid[x][y]>1) {
            if(x-1>=0 && grid[x-1][y] == 0){
                grid[x-1][y] = 1;
                grid[x][y]--;
            }
            else if(x+11<=2 && grid[x+1][y] == 0){
                grid[x+1][y] = 1;
                grid[x][y]--;
            }
            else if(y-1>=0 && grid[x][y-1] == 0){
                grid[x][y-1] = 1;
                grid[x][y]--;
            }
            else if(y+1<=2 && grid[x][y+1] == 0){
                grid[x][y+1] = 1;
                grid[x][y]--;
            }
            ans++;
        }return ans;
    }

    public static int minimumOperations(String num) {
        int n = num.length();
        int cnt1 = 0;
        int flag = 0;
        //25
        for (int i = n-1; i >=0; i--) {
            if(num.charAt(i) == '5' && flag == 0){
                flag = 1;
            }
            else if(num.charAt(i) == '2' && flag == 1){
                flag = 2;
                break;
            }
            else{
                cnt1++;
            }
        }
        if(flag!=2){
            cnt1 = n;
        }

        //50
        int cnt2 = 0;
        flag = 0;
        for (int i = n-1; i >=0; i--) {
            if(num.charAt(i) == '0' && flag == 0){
                flag = 1;
            }
            else if(num.charAt(i) == '5' && flag == 1){
                flag = 2;
                break;
            }
            else{
                cnt2++;
            }
        }
        if(flag!=2){
            cnt2 = n;
        }

        //75
        int cnt3 = 0;
        flag = 0;
        for (int i = n-1; i >=0; i--) {
            if(num.charAt(i) == '5' && flag == 0){
                flag = 1;
            }
            else if(num.charAt(i) == '7' && flag == 1){
                flag = 2;
                break;
            }
            else{
                cnt3++;
            }
        }
        if(flag!=2){
            cnt3 = n;
        }

        //00
        int cnt4 = 0;
        flag = 0;
        for (int i = n-1; i >=0; i--) {
            if(num.charAt(i) == '0' && flag == 0){
                flag = 1;
            }
            else if(num.charAt(i) == '0' && flag == 1){
                flag = 2;
                break;
            }
            else{
                cnt4++;
            }
        }
        return Math.min(cnt1,Math.min(cnt2,Math.min(cnt3,cnt4)));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < numRows; i++) {
            List<Integer> array = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                if(j == 0 || j == num-1){
                    array.add(1);
                }
                else{
                    array.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
            ans.add(array);
            num++;
        }
        return ans;
    }
    public static int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                arr[i][j] = arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m-1][n-1];

    }
    public static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i < ans.length; i++) {
            int num = i;
            int fin = 0;
            while(num!=0){
                if(num%2!=0){
                    fin++;
                }
                num/=2;
            }
            ans[i] = fin;
        }
        return ans;
    }
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length() / 2; i ++) {
            int count = i + 1;
            if (s.length() % count != 0) {
                continue;
            }
            boolean same = true;
            for (int k = count; k + count <= s.length() && same; k+=count) {
                for (int j = 0; j <= i && same; j ++) {
                    if (s.charAt(j) != s.charAt(j + k)) {
                        same = false;
                    }
                }
            }
            if (same == true) {
                return true;
            }
        }
        return false;
    }

    public int ccountWays(List<Integer> nums) {
        int len = nums.size();
        int ans = 0;
        Collections.sort(nums);
        for (int i = 0; i < len; i++) {
            if(nums.get(i)<i+1 && i+1<len && nums.get(i+1)>i+1){
                ans++;
            }
            else if(nums.get(i)<i+1 && i+1==nums.size()){
                ans++;
            }
        }
        if(nums.get(0)>0){
            ans++;
        }
        return ans;
    }
    public static boolean isSubsequence(String s, String t) {
        int sle = s.length();
        int tle = t.length();
        int i = 0;
        int j = 0;
        while(i<sle && j<tle){
            char ch = s.charAt(i);
            if(ch == t.charAt(j)){
                i++;
                j++;
                continue;
            }
            j++;
        }
        if(i==sle){
            return true;
        }
        return false;
    }
}
