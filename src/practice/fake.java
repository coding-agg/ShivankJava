package practice;

import com.sun.source.tree.Tree;

import java.util.*;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class TrieNode{
    TrieNode[] children;
    int num;
    TrieNode(){
        children = new TrieNode[26];
        num = 1;
    }
}
class T{
    public int i;
    public int j;
    public int sum; // nums1[i] + nums2[j]
    public T(int i, int j, int sum) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
}
class sparse{
    public int i;
    public int j;
    public sparse(int i,int j){
        this.i = i;
        this.j = j;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val , ListNode next){
        this.val = val;
        this.next = next;
    }
    public ListNode arrayToList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for(int i = 1; i < arr.length; i++){
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }



public class fake{
    public static void main(String[] args) {
        String s = "bxj##tw";
        String t = "bxo#j##tw";
        System.out.println(backspaceCompare(s,t));
    }

    public static boolean backspaceCompare(String s, String t) {
        int num = 0;
        while(num<s.length()){
            if(s.charAt(num) == '#'){
                if(num == 0){
                    s = s.substring(num+1);
                    continue;
                }
                s = s.substring(0,num-1)+s.substring(num+1);
                num--;
                continue;
            }
            num++;
        }
        num = 0;
        while(num<t.length()){
            if(t.charAt(num) == '#'){
                if(num == 0){
                    t = t.substring(num+1);
                    continue;
                }
                t = t.substring(0,num-1)+t.substring(num+1);
                num--;
                continue;
            }
            num++;
        }
        return s.compareTo(t)==0;
    }
    public static int maxnum(int[] arr,int start,int end){
        int num = Integer.MIN_VALUE;
        for (int i = start; i <end ; i++) {
            if(arr[i]>num){
                num = arr[i];
            }
        }
        return num;
    }


    public static int removeDuplicates(int[] nums) {
        int i=0;
        int num=0;
        while(i<nums.length-1){
            if(nums[i] == nums[i+1]){
                num++;
                for (int j = i+1; j <=nums.length-num ; j++) {
                    nums[j] = nums[j+1];
                }
            }
        }
        return num;
    }
    public int shortestBridge(int[][] grid) {
        markGridTwo(grid);

        for (int color = 2;; ++color)
            for (int i = 0; i < grid.length; ++i)
                for (int j = 0; j < grid[0].length; ++j)
                    if (grid[i][j] == color)
                        if (expand(grid, i + 1, j, color) || expand(grid, i - 1, j, color) ||
                                expand(grid, i, j + 1, color) || expand(grid, i, j - 1, color))
                            return color - 2;
    }
    private void markGridTwo(int[][] grid) {
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 1) {
                    markGridTwo(grid, i, j);
                    return;
                }
    }

    private void markGridTwo(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
            return;
        if (grid[i][j] != 1)
            return;
        grid[i][j] = 2;
        markGridTwo(grid, i + 1, j);
        markGridTwo(grid, i - 1, j);
        markGridTwo(grid, i, j + 1);
        markGridTwo(grid, i, j - 1);
    }
    private boolean expand(int[][] grid, int i, int j, int color) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
            return false;
        if (grid[i][j] == 0)
            grid[i][j] = color + 1;
        return grid[i][j] == 1;
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode hello1 = head;
        ListNode helloans = head;
        ListNode hello2 = head;
        for (int i = 0; i < 5; i++) {
            helloans = helloans.next;
            hello2 = hello2.next;
        }
        while(hello2.next != null){
            hello1 = hello1.next;
            hello2 = hello2.next;
        }
        int temp = helloans.val;
        helloans.val = hello1.val;
        hello1.val = temp;
        return head;

    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        final int kMod = 1_000_000_007;
        int ans = 0;
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for (int i = 1; i <= high; ++i) {
            if (i >= zero)
                dp[i] = (dp[i] + dp[i - zero]) % kMod;
            if (i >= one)
                dp[i] = (dp[i] + dp[i - one]) % kMod;
            if (i >= low)
                ans = (ans + dp[i]) % kMod;
        }

        return ans;
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int p = questions[i][0], b = questions[i][1];
            int j = i + b + 1;
            f[i] = Math.max(f[i + 1], p + (j > n ? 0 : f[j]));
        }
        return f[0];
    }

    public static int[][] generateMatrix(int n) {
        int number = 1;
        int[][] matrix = new int[n][n];
        int top = 0 ;
        int bottom = n-1 ;
        int left = 0 ;
        int right = n-1 ;
        int count = 1 ;
        int num = (bottom+1)*(right+1) ;
        while(bottom>=top && right>=left){
            if(num>0){
                if(count==1){
                    for (int i = left; i <= right; i++) {
                        matrix[top][i] = number;
                        number++;
                        num-- ;
                    }
                    top++ ;
                    count=2 ;
                }
            }
            if(num>0){
                if(count==2){
                    for (int i = top; i <= bottom; i++) {
                        matrix[i][right] = number;
                        number++;
                        num-- ;
                    }
                    right-- ;
                    count=3 ;
                }
            }
            if(num>0){
                if(count==3){
                    for (int i = right; i >=left ; i--) {
                        matrix[bottom][i] = number;
                        number++;
                        num-- ;
                    }
                    bottom-- ;
                    count=4 ;
                }
            }
            if(num>0){
                if(count==4){
                    for (int i = bottom; i >=top ; i--) {
                        matrix[i][left] = number;
                        number++;
                        num-- ;
                    }
                    left++ ;
                    count=1 ;
                }
            }
        }
        return matrix;
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0 ;
        int bottom = matrix.length-1 ;
        int left = 0 ;
        int right = matrix[0].length-1 ;
        int count = 1 ;
        int num = (bottom+1)*(right+1) ;
        while(bottom>=top && right>=left){
            if(num>0){
                if(count==1){
                    for (int i = left; i <= right; i++) {
                        ans.add(matrix[top][i]);
                        num-- ;
                    }
                    top++ ;
                    count=2 ;
                }
            }
            if(num>0){
                if(count==2){
                    for (int i = top; i <= bottom; i++) {
                        ans.add(matrix[i][right]);
                        num-- ;
                    }
                    right-- ;
                    count=3 ;
                }
            }
            if(num>0){
                if(count==3){
                    for (int i = right; i >=left ; i--) {
                        ans.add(matrix[bottom][i]);
                        num-- ;
                    }
                    bottom-- ;
                    count=4 ;
                }
            }
            if(num>0){
                if(count==4){
                    for (int i = bottom; i >=top ; i--) {
                        ans.add(matrix[i][left]);
                        num-- ;
                    }
                    left++ ;
                    count=1 ;
                }
            }
        }
        return ans;
    }
    public static int diagonalSum(int[][] mat) {
        int num = mat.length;
        int sum = 0;
        for (int j=0; j < mat.length; j++) {
            if(num-j-1 == j){
                sum+=mat[j][j];
                continue;
            }
            sum+=mat[j][j];
            sum+=mat[num-j-1][j];
        }
        return sum;
    }
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int length = obstacles.length;
        int[] longest = new int[length];
        longest[0] = 1;
        int len = 1;
        int[] d = new int[length + 1];
        d[len] = obstacles[0];
        for (int i = 1; i < length; ++i) {
            if (obstacles[i] >= d[len]) {
                d[++len] = obstacles[i];
                longest[i] = len;
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] <= obstacles[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = obstacles[i];
                longest[i] = pos + 1;
            }
        }
        return longest;
    }


    long pow(long x, long y, long p) {
        long res = 1;

        x = x % p;

        if (x == 0)
            return 0;

        while (y > 0)
        {
            if ((y & 1) != 0)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    public int numSubseq(int[] nums, int target) {
        int n=nums.length,i;
        Arrays.sort(nums);
        long mod=(long)1e9+7;
        long sum=0;
        for(i=0;i<n;i++)
        {
            int l=i,r=n-1,mid,ans=-1;
            while(l<=r)
            {
                mid=l+(r-l)/2;
                if(nums[i]+nums[mid]<=target)
                {
                    l=mid+1;
                    ans=mid;
                }
                else
                    r=mid-1;
            }
            if(ans!=-1)
            {

                long len=ans-i+1;

                long yo=pow(2,len,mod);

                long yo1=pow(2,len-1,mod);
                sum+=(yo-yo1);
                sum=sum%mod;
                if(sum<0)sum+=mod;
            }

        }

        return (int)sum;
    }

    public static int maxVowels(String s, int k) {
        int num = 0;
        int[] string = new int[s.length()];
        HashMap<Character,Boolean> hash = new HashMap<>();
        hash.put('a',true);
        hash.put('e',true);
        hash.put('i',true);
        hash.put('o',true);
        hash.put('u',true);
        for (int i = 0; i < s.length(); i++) {
            if(hash.containsKey(s.charAt(i))){
                num++;
            }
            string[i] = num;
        }
        int ans = string[k-1];
        int i = 0;
        int j = k;
        while(j<s.length()){
            if(string[j]-string[i]>ans){
                ans = string[j]-string[i];
            }
            i++;
            j++;
        }
        return ans;
    }
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int x:nums1){
            mp.put(x,1);
        }

        for(int x:nums2){
            if(mp.getOrDefault(x,0) == 1)
                mp.put(x,3);
            else if(mp.getOrDefault(x,0) == 0)
                mp.put(x,2);
        }

        List<Integer> f1 = new ArrayList<>();
        List<Integer> f2 = new ArrayList<>();
        for(int x:nums1){
            if(mp.getOrDefault(x,0) == 1){
                mp.put(x,0);
                f1.add(x);
            }

        }

        ans.add(f1);
        for(int x:nums2){
            if(mp.getOrDefault(x,0) == 2){
                mp.put(x,0);
                f2.add(x);
            }
        }


        ans.add(f2);

        return ans;
    }

    public static int arraySign(int[] nums) {
        int num = 1;
        for (int sum : nums){
            if(sum == 0){
                return 0;
            }
            if(sum<0){
                num *=-1;
            }
        }
        return num;
    }
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int r,sum = 0;
        int temp=x;
        while(x>0){
            r=x%10;  //getting remainder
            sum=(sum*10)+r;
            x=x/10;
        }
        if(temp==sum)
            return true;
        else
            return false;
    }

    public static int bulbSwitch(int n) {
        int ans = 0;
        int num = 1;
        boolean[] light = new boolean[n];
        for (int i = 0; num<n; i = i+num) {
            if(i>=n){
                num++;
                i = num-1;
                if(num>n){
                    return ans;
                }
            }
            if(!light[i]){
                ans++;
                light[i] = true;
            }
            else{
                ans--;
                light[i] = false;
            }

        }
        return ans;
    }
    public static int addDigits(int num) {
        int sum = 0;
        while(num!=0){
            sum = sum + num%10;
            num = num/10;
            if(num == 0 && sum>9){
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }

    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int)1e9 + 7, p = group.length;
        long[][] dp = new long[1 + minProfit][1 + n];
        dp[0][0] = 1;

        for(int i = 0; i < p; i++) {
            long[][] next = new long[1 + minProfit][];
            for(int idx = 0; idx <= minProfit; idx++) {
                next[idx] = Arrays.copyOf(dp[idx], 1 + n);
            }
            for(int j = 0; j <= minProfit; j++) {
                for(int k = 0; k <= n - group[i]; k++) {
                    int newP = Math.min(j + profit[i], minProfit);
                    int newG = k + group[i];
                    next[newP][newG] = (next[newP][newG] + dp[j][k]) % mod;
                }
            }
            dp = next;
        }

        long ans = 0;
        for(int j = 0; j <= n; j++) {
            ans = (ans + dp[minProfit][j]) % mod;
        }
        return (int)ans;
    }
    public int longestZigZag(TreeNode root) {
        if(root == null){
            return -1;
        }
        boolean hello = true;
        int res = 0;
        if(hello) {
            res = longestZigZag(root.left);
            hello = false;
        }
        if(!hello){
            res = longestZigZag(root.right);
        }
        return res+1;
    }
    public static int minInsertions(String s) {
        return (s.length()-getLCS(s,reverse(s)));
    }
    public static String reverse(String str){
        String ans="";
        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            ans+=ch;
        }
        return ans;
    }

    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);

        ArrayList<Integer> array = new ArrayList<>();
        for (int stone : stones){
            array.add(stone);
        }
        Collections.reverse(array);
        while(!array.isEmpty()){
            if(array.size() == 1){
                return array.get(0);
            }
            if(array.get(0) == array.get(1)){
                array.remove(0);
                array.remove(0);
            }
            else{
                int num = Math.abs(array.remove(0)-array.remove(0));
                int left = 0;
                int right = array.size()-1;
                while(left<=right){
                    int mid = (left+right)/2;
                    if(array.get(mid)>num){
                        left = mid+1;
                    }
                    else if(array.get(mid)<num){
                        right = mid-1;
                    }
                    else{
                        array.add(mid,num);
                        break;
                    }
                }
                if(left>right) {
                    array.add(left, num);
                }
            }
        }
        return 0;
    }
    public static int getLCS(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }

    public static String mergeAlternately(String word1, String word2) {
        String ans = "";
        for (int i = 0; i <Math.min(word1.length(),word2.length()) ; i++) {
            ans = ans + word1.charAt(i);
            ans = ans + word2.charAt(i);
        }
        if(word1.length() == word2.length()){
            return ans;
        }
        if(word1.length()>word2.length()){
            ans = ans + word1.substring(word2.length(),word1.length());
            return ans;
        }
        else{
            ans = ans + word2.substring(word1.length(),word2.length());
            return ans;
        }
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int num = 0;
        for (int candy : candies){
            if(candy>num){
                num = candy;
            }
        }
        List<Boolean> answer = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if((candies[i]+extraCandies)>=num){
                answer.add(true);
            }
            else{
                answer.add(false);
            }
        }
        return answer;
    }
    public static int numWays(String[] words, String target) {
        final int MODULO = 1000000007;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int targetLength = target.length();
        int wordLength = words[0].length();
        if (targetLength > wordLength)
            return 0;
        for (String word : words) {
            for (int i = 0; i < wordLength; i++) {
                int letterIndex = word.charAt(i) - 'a';
                int key = i * 26 + letterIndex;
                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);
            }
        }
        long[][] dp = new long[targetLength][wordLength];
        int letterIndex0 = target.charAt(0) - 'a';
        int maxStart0 = wordLength - targetLength;
        for (int j = 0; j <= maxStart0; j++) {
            int key = j * 26 + letterIndex0;
            dp[0][j] = map.getOrDefault(key, 0);
            if (j > 0)
                dp[0][j] = (dp[0][j - 1] + dp[0][j]) % MODULO;
        }
        for (int i = 1; i < targetLength; i++) {
            int letterIndex = target.charAt(i) - 'a';
            int maxStart = wordLength - targetLength + i;
            for (int j = i; j <= maxStart; j++) {
                int key = j * 26 + letterIndex;
                long curCount = map.getOrDefault(key, 0);
                if (curCount > 0)
                    dp[i][j] = dp[i - 1][j - 1] * curCount % MODULO;
                if (j > i)
                    dp[i][j] = (dp[i][j - 1] + dp[i][j]) % MODULO;
            }
        }
        return (int) dp[targetLength - 1][wordLength - 1];
    }
    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        List<int[]> presum = new ArrayList<>();
        for (List<Integer> p : piles) {
            int m = p.size();
            int[] s = new int[m + 1];
            for (int i = 0; i < m; ++i) {
                s[i + 1] = s[i] + p.get(i);
            }
            presum.add(s);
        }
        int[] dp = new int[k + 1];
        for (int[] s : presum) {
            for (int j = k; j >= 0; --j) {
                for (int idx = 0; idx < s.length; ++idx) {
                    if (j >= idx) {
                        dp[j] = Math.max(dp[j], dp[j - idx] + s[idx]);
                    }
                }
            }
        }
        return dp[k];
    }
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][dp.length-1];
    }
    public static String longestPalindrome(String s){
        int[] ans = new int[2];
        int num = 1;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i)==s.charAt(j) && (dp[i+1][j-1]!=0 || j-i<=1)){
                    dp[i][j] = dp[i+1][j-1]+2;
                    if(num<dp[i][j]){
                        num = dp[i][j];
                        ans[0] = i;
                        ans[1] = j;
                    }
                }
            }
        }
        return s.substring(ans[0],ans[1]+1);
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while(i<pushed.length){
            stack.push(pushed[i]);
            while(j<pushed.length && !stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            i++;
        }
        return true ? stack.isEmpty() : false;
    }

    public static int minSteps(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if(i != 0 && str.charAt(i) != str.charAt(0) && str.charAt(i) != str.charAt(i-1)){
                ans = (-(~ans));
            }
        }
        return ans+1;
    }
    public static ArrayList<String> partitionString(String s) {
        int num = s.length()-1;
        int i = 0;
        HashMap<Character,Boolean> hash = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        while(i<=num){
            String hello = "";
            while(i<=num && !hash.containsKey(s.charAt(i))){
                hash.put(s.charAt(i),true);
                hello = hello + s.charAt(i);
                i++;
            }
            if(i<=num && hash.containsKey(s.charAt(i))){
                hash.clear();
            }
            ans.add(hello);
        }
        return ans;
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() <= 1){
            return false;
        }
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                stack.push(s.charAt(i));
            }
            else{
                if(s.charAt(i) == '(' && !stack.isEmpty() && stack.peek() == ')'){
                    stack.pop();
                }
                else if(s.charAt(i) == '[' && !stack.isEmpty() && stack.peek() == ']'){
                    stack.pop();
                }
                else if(s.charAt(i) == '{' && !stack.isEmpty() && stack.peek() == '}'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return true ? stack.isEmpty() : false;
    }


}
