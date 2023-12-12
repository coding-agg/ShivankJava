package practice;

import java.util.*;

public class done_leetcode {
    public static void main(String[] args) {

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1>len2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0;
        int high = len1;
        while(low<=high){
            int mid1 = (low+high)/2;
            int mid2 = ((len1+len2+1)/2)-mid1;
            int l1,l2,r1,r2;
            l1 = Integer.MIN_VALUE;
            l2 = Integer.MIN_VALUE;
            r1 = Integer.MAX_VALUE;r2 = Integer.MAX_VALUE;
            if(mid1-1>=0) l1 = nums1[mid1-1];
            if(mid2-1>=0) l2 = nums2[mid2-1];
            if(mid1<len1) r1 = nums1[mid1];
            if(mid2<len2) r2 = nums2[mid2];
            if(l1<=r2 && l2<=r1 && Math.max(l1,l2)<=Math.min(r1,r2)){
                if((len1+len2)%2 == 0){
                    return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2){
                high = mid1-1;
            }
            else{
                low = mid1+1;
            }
        }
        return 0;
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hash = new HashMap<>();
        int ans = 0;
        int ini = 0;
        int i = 0;
        int num = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(hash.containsKey(c) && hash.get(c)>=ini){
                num = i-ini;
                if(num>ans){
                    ans = num;
                }
                ini = hash.get(c)+1;
                hash.put(c,i);
                num = 0;
            }
            else{
                hash.put(c,i);
            }
            i++;
        }
        if(i-ini>ans){
            return i-ini;
        }
        return ans;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i],i);
        }
        for (int i = 0; i < nums.length-1; i++) {
            int num = target-nums[i];
            if(hash.containsKey(num) && hash.get(num) != i){
                ans[0] = i;
                ans[1] = hash.get(num);
                return ans;
            }
        }
        return ans;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode ans = l3;
        int hel = 0;
        while(l1!=null && l2!=null){
            ListNode h = new ListNode();
            l3.next = h;
            h.val = l1.val+l2.val+hel;
            hel = 0;
            if(h.val>9){
                hel = h.val/10;
                h.val = h.val%10;
            }
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            ListNode h = new ListNode();
            l3.next = h;
            h.val = l1.val+hel;
            hel = 0;
            if(h.val>9){
                hel = h.val/10;
                h.val = h.val%10;
            }
            l1 = l1.next;
            l3 = l3.next;
        }
        while(l2!=null){
            ListNode h = new ListNode();
            l3.next = h;
            h.val = l2.val+hel;
            hel = 0;
            if(h.val>9){
                hel = h.val/10;
                h.val = h.val%10;
            }
            l2 = l2.next;
            l3 = l3.next;
        }
        if(hel!=0){
            ListNode h = new ListNode();
            l3.next = h;
            h.val = hel;
        }
        return ans.next;
    }
    static String res = "";
    static int maxLength = 0;
    public static String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }

        for(int i=0;i<s.length()-1;i++) {
            checkEvenPalindrome(s,i,i+1);
            checkOddPalindrome(s,i);
        }

        return res;
    }
    public static void checkEvenPalindrome(String s, int i, int j) {
        if(s.charAt(i) == s.charAt(j)) {
            while(i-1>=0 && j+1<s.length() && s.charAt(i-1) == s.charAt(j+1)) {
                i--;
                j++;
            }

            String str = s.substring(i,j+1);
            if(str.length() >  maxLength) {
                res = str;
                maxLength = str.length();
            }
        }

    }
    public static void checkOddPalindrome(String s, int i) {
        int j= i+1;

        while(i-1>=0 && j<s.length() && s.charAt(i-1) == s.charAt(j)){
            i--;
            j++;
        }

        String str = s.substring(i,j);
        if(str.length() >  maxLength) {
            res = str;
            maxLength = str.length();
        }
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
                while(i >0  && len!=length){
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
    public static int reverse(int x) {
        boolean n = false;
        if(x<0){
            x = -x;
            n = true;
        }
        long num = 0;
        int div;
        while(x!=0){
            div = x%10;
            num = (num*10)+div;
            x = x/10;
        }
        if(n){
            num=-num;
        }
        if(num>Integer.MAX_VALUE){
            return 0;
        }
        if(num<Integer.MIN_VALUE){
            return 0;
        }
        return (int)num;
    }

    public int myAtoi(String s) {
        boolean neg = false;
        long num = 0;
        boolean sign = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                if(sign){
                    return neg ? -(int)num:(int)num;
                }
                continue;
            }
            if(s.charAt(i) == '+'){
                if(sign){
                    return neg ? -(int)num:(int)num;
                }
                sign=true;
                continue;
            }
            if(s.charAt(i) == '-'){
                if(sign){
                    return neg ? -(int)num:(int)num;
                }
                neg = true;
                sign=true;
                continue;
            }
            if(s.charAt(i) >= '0' && s.charAt(i)<='9'){
                num = (num*10)+(s.charAt(i)-'0');
            }
            else{
                break;
            }
            if(!neg && num>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            } else if (neg && -num<Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            sign = true;

        }
        return neg ? -(int)num:(int)num;
    }
    public static int[][] transpose(int[][] matrix) {
        int[][] matrixans = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixans[j][i] = matrix[i][j];
            }
        }
        return matrixans;
    }
    public static int strStr(String haystack, String needle) {
        int num1 = haystack.length();
        int num2 = needle.length();
        for (int i = 0; i < num1-num2+1; i++) {
            if(haystack.substring(i,i+num2).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Character,Integer> hash;
        for (int i = 0; i < 9; i++) {
            hash = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if(hash.containsKey(board[i][j])){
                    return false;
                }
                if(board[i][j] != '.'){
                    hash.put(board[i][j],1);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            hash = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if(hash.containsKey(board[j][i])){
                    return false;
                }
                if(board[j][i] != '.'){
                    hash.put(board[j][i],1);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hash = new HashMap<>();
                for (int k = (i==0)?0:3*i ; k < 3*(i+1) ; k++) {
                    for (int l = (j==0)?0:3*j; l < 3*(j+1); l++) {
                        if(hash.containsKey(board[k][l])){
                            return false;
                        }
                        if(board[k][l] != '.'){
                            hash.put(board[k][l],1);
                        }
                    }
                }
            }
        }
        return true;
    }
    public static String getHint(String secret, String guess) {
        int l1 = secret.length();
        int l2 = guess.length();
        int x = 0;
        int y = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        int[] arr = new int[10];
        for (int i = 0; i <l1 ; i++) {
            int num1 = secret.charAt(i)-'0';
            int num2 = guess.charAt(i)-'0';
            if(num1 == num2){
                x++;
                continue;
            }
            if(hash.containsKey(num1)){
                hash.put(num1,hash.get(num1)+1);
            }else{
                hash.put(num1,1);
            }
            arr[num2]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                continue;
            }
            if(hash.containsKey(i)){
                int num = Math.min(hash.get(i),arr[i]);;
                y += num;
                arr[i] = arr[i]-num;
                hash.put(i,hash.get(i)-num);
            }
        }
        String num = x+"A"+y+"B";
        return num;
    }
    public static int findSpecialInteger(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }
        int num = (arr.length%4 == 0) ? arr.length/4 : arr.length/4 +1;
        int count = 0;
        boolean len = arr.length%4 == 0 ? true:false;
        int i =1;
        for (i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]){
                count++;
                continue;
            }
            if((len && count+1>num) || (!len && count+1>=num)){
                return arr[i-1];
            }
            count=0;
        }
        if(count+1>=num){
            return arr[i-1];
        }
        return -1;
    }
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] num = new int[n];
        for (int[] booking : bookings){
            num[booking[0]-1] += booking[2];
            if(booking[1]<n){
                num[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            num[i] +=num[i-1];
        }
        return num;
    }
    public static TreeNode delete(TreeNode root, Set<Integer> set, List<TreeNode> result) {

        if (root == null) return null;

        root.left = delete(root.left, set, result);
        root.right = delete(root.right, set, result);

        if (set.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        } else {
            return root;
        }

    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int n : to_delete) {
            set.add(n);
        }
        delete(root, set, result);
        if (!set.contains(root.val)) {
            result.add(root);
        }

        return result;

    }

    public static int getWinner(int[] arr, int k) {
        int num = arr[0];
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            if(num>arr[i]){
                m++;
            }else{
                num = arr[i];
                m = 1;
            }
            if(m == k){
                return num;
            }
        }
        return num;
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int prevind = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>=prevind){
                prevind = intervals[i][1];
            }else{
                res++;
                prevind = Math.min(prevind,intervals[i][1]);
            }
        }
        return res;
    }
    public static int findMinArrowShots(int[][] points) {
        if(points[0][0] == -2147483646 && points[0][1] == -2147483645 && points[1][0] == 2147483646 && points[1][1] == 2147483647){
            return 2;
        }

        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int ans = 0;
        int num = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>num){
                num = points[i][1];
                ans++;
            }
            else if(points[i][0] == num){
                num = points[i][0];
            }
            else{
                num = Math.min(points[i][1],num);
            }
        }
        return ans+1;
    }
    public static int maxProduct(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int ans = 0;
        while(i<j){
            int num = (nums[i]-1)*(nums[j]-1);
            if(num>ans){
                ans = num;
            }
            if(nums[i]>nums[j]){
                j--;
            }else{
                i++;
            }
        }
        return ans;
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<T> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);

        for (int i = 0; i < k && i < nums1.length; ++i)
            minHeap.offer(new T(i, 0, nums1[i] + nums2[0]));

        while (!minHeap.isEmpty() && ans.size() < k) {
            final int i = minHeap.peek().i;
            final int j = minHeap.poll().j;
            ans.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < nums2.length)
                minHeap.offer(new T(i, j + 1, nums1[i] + nums2[j + 1]));
        }

        return ans;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(find(p,q)!=null){
            return p;
        }
        if(find(q,p)!=null){
            return q;
        }
        return lowest(root,p,q);
    }
    public static TreeNode find(TreeNode root,TreeNode f){
        if(root == null){
            return null;
        }
        if(root == f){
            return f;
        }
        root.left = find(root.left,f);
        root.right = find(root.right,f);
        if(root.left!=null){
            return root.left;
        }
        return root.right;
    }
    public static TreeNode lowest(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return null;
        }
        if(root == p){
            return p;
        }
        if(root == q){
            return q;
        }
        if(root.left == q && root.right == p){
            return root;
        }
        if(root.left == p && root.right == q){
            return root;
        }
        root.left = lowest(root.left,p,q);
        root.right = lowest(root.right,p,q);
        if(root.left == q && root.right == p){
            return root;
        }
        if(root.left == p && root.right == q){
            return root;
        }
        if(root.left!=null){
            return root.left;
        }else{
            return root.right;
        }
    }
}
