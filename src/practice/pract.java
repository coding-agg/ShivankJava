package practice;
import com.sun.source.tree.Tree;

import java.util.*;

public class pract {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
    }
    public static void display(ListNode node){
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
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
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1]){
                left++;
                nums[left] = nums[i];
            }
        }
        return left+1;
    }
    public static String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder("");
        dfs(root,str);
        return str.toString();

    }
    public static void dfs(TreeNode root,StringBuilder str){
        if(root == null){
            return;
        }
        str.append(root.val);
        if(root.left == null && root.right == null){
            return;
        }
        str.append("(");
        dfs(root.left,str);
        str.append(")");
        if(root.right!=null){
            str.append("(");
            dfs(root.right,str);
            str.append(")");
        }
    }



    public static int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        if(dividend == 1<<31 && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean neg = (dividend>0) ^ (divisor>0) ? true : false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int ans=0;
        while(dividend-divisor>=0){
            int count = 0;
            while(dividend - (divisor<<1<<count)>=0){
                count++;
            }
            ans+=1<<count;
            dividend = dividend-(divisor<<count);
        }
        return neg ? -ans:ans;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fir;
        ListNode sec;
        fir = head;
        sec = head;
        for (int i = 0; i < n; i++) {
            sec = sec.next;
        }
        if(sec.next == null){
            head = head.next;
            return head;
        }
        while(sec.next != null){
            fir = fir.next;
            sec = sec.next;
        }
        fir.next = fir.next.next;
        return fir;
    }
    public static List<String> letterCombinations(String digits) {
        List<String> array = new ArrayList<>();
        part(array,0,"",digits);
        return array;
    }
    public static String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void part(List<String> array,int i,String s,String length){
        if(length.length() == 0){
            return;
        }
        if(s.length() == length.length()){
            array.add(s);
            return;
        }
        for(char num : str[length.charAt(i)-'0'].toCharArray()){
            s+=num;
            part(array,i+1,s,length);
            s = s.substring(0,s.length()-1);
        }
    }
    public static String largestOddNumber(String num) {
        int start = 0;
        for (int i = 0; i < num.length(); i++) {
            if(num.charAt(i)!='0'){
                start = i;
                break;
            }
        }
        for (int i = num.length()-1; i >=start ; i--) {
            if((num.charAt(i)-'0' )%2 !=0){
                return num.substring(start,i+1);
            }
        }
        return "";
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int num = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int hel = nums[i]+nums[left]+nums[right];
                if(target == hel){
                    return target;
                }
                if(Math.abs(target-num)>Math.abs(target-hel)){
                    num = hel;
                }
                if(hel>target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return num;
    }
    public static int totalMoney(int n) {
        int x = n/7;
        int day = n-(x*7);
        int ans = 0;
        ans += 7*(4*x+(x-1)*x/2);
        ans += ((x)*day) + (day*(day+1)/2);
        return ans;
    }
    public static int numberOfMatches(int n) {
        int ans = 0;
        while(n!=1){
            if(n%2 == 0){
                n = n/2;
                ans+=n;
            }
            else{
                n = n/2;
                ans+=n;
                n++;
            }
        }
        return ans;
    }
    public static String largestGoodInteger(String num) {
        int n = 0;
        int ind = 0;
        char c = num.charAt(0);
        ArrayList<String> array = new ArrayList<>();
        for (int i = 1; i < num.length(); i++) {
            if(n == 2){
                array.add(num.substring(ind-2,ind+1));
            }
            if(c == num.charAt(i)){
                n++;
                ind = i;
                continue;
            }
            n=0;
            c = num.charAt(i);
        }
        if(n == 2){
            array.add(num.substring(ind-2,ind+1));
        }
        if(array.size()==0){
            return "";
        }
        System.out.println(array);
        String hel = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if(hel.compareTo(array.get(i))<0){
                hel = array.get(i);
            }
        }
        return hel;
    }
    public static int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x1 = Math.abs(points[i][0] - points[i + 1][0]);
            int y1 = Math.abs(points[i][1] - points[i + 1][1]);
            ans += Math.max(x1, y1);
        }
        return ans;
    }
    public static String intToRoman(int num) {
        String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thousands = {"","M","MM","MMM"};
        String ans = "";
        char[] numbers = (num+"").toCharArray();
        if(numbers.length == 4){
            ans = thousands[numbers[0]-'0']+hundreds[numbers[1]-'0']+tens[numbers[2]-'0']+ones[numbers[3]-'0'];
        } else if (numbers.length == 3) {
            ans = hundreds[numbers[0]-'0']+tens[numbers[1]-'0']+ones[numbers[2]-'0'];
        }else if(numbers.length == 2){
            ans = tens[numbers[0]-'0']+ones[numbers[1]-'0'];
        }else{
            ans = ones[numbers[0]-'0'];
        }
        return ans;
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while(left<right){
            int num = Math.min(height[left],height[right])*(right-left);
            if(num>ans){
                ans = num;
            }
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }
    public static int countCharacters(String[] words, String chars) {
        int[] arr = new int[26];
        for(char ch : chars.toCharArray()){
            arr[ch-'a']++;
        }
        int ans = 0;
        for (String word : words){
            int[] array = arr.clone();
            for (char ch : word.toCharArray()){
                if(--array[ch-'a']<0){
                    ans-=word.length();
                    break;
                }
            }
            ans+=word.length();
        }
        return ans;
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int num = 0;
        int count = 0;
        for (int value : nums){
            if(value == 1){
                count++;
                continue;
            }
            if(value == 0){
                if(count>num){
                    num = count;
                }
                count = 0;
            }
        }
        if(count>num){
            num = count;
        }
        return num;
    }

    public static int findMinimumOperations(String s1, String s2, String s3) {
        int num = Math.min(s1.length(),Math.min(s2.length(),s3.length()));
        int ans = s1.length()+s2.length()+s3.length()-3*num;
        s1 = s1.substring(0,num);
        s2 = s2.substring(0,num);
        s3 = s3.substring(0,num);
        while((s1.length()>=2 && s2.length()>=2 && s3.length()>=2) && !s1.equals(s2) || !s2.equals(s3)){
            if(!s1.equals(s2)){
                s1 = s1.substring(0,s1.length()-1);
                s2 = s2.substring(0,s2.length()-1);
                s3 = s3.substring(0,s3.length()-1);
                ans = ans+3;
            }
            if(!s2.equals(s3)){
                s1 = s1.substring(0,s1.length()-1);
                s2 = s2.substring(0,s2.length()-1);
                s3 = s3.substring(0,s3.length()-1);
                ans = ans+3;
            }
        }
        if(s1.equals(s2) && s2.equals(s3) && s1.length()>=1){
            return ans;
        }
        return -1;
    }
    public static long minimumSteps(String s){
        int[] black = new int[s.length()];
        int bcount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                bcount++;
            }
            black[i] = bcount;
        }
        int[] white = new int[s.length()];
        int wcount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                wcount++;
            }
            white[i] = wcount;
        }
        long msteps = Long.MAX_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            long steps = (long) black[i] + white[i + 1];
            msteps = Math.min(msteps, steps);
        }

        return msteps;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1){
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2){
            if(set1.contains(num)){
                set2.add(num);
            }
        }

        int[] arr = new int[set2.size()];
        int i = 0;
        for (int num : set2){
            arr[i++] = num;
        }
        return arr;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = searchless(nums,target);
        ans[1] = searchmore(nums,target);
        return ans;
    }
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],true);
        }
        ArrayList<Integer> array = new ArrayList<>(map.keySet());
        System.out.println(array);
        return -1;
    }
    public static int searchless(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>=target){
                right = mid-1;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
        }
        if(right+1<nums.length && nums[right+1] == target){
            return right+1;
        }
        return -1;
    }

    public static boolean binary(int[] nums,int target)
    {
        int low = 0;
        int high = nums[nums.length-1];
        while(low<=high){
            int mid = low + (high-low)/2; //(low+high)/2

            if(target<nums[mid]){
                high = mid-1;
            }
            else if(target>nums[mid]){
                low = mid+1;
            }
            else{
                if(target==nums[mid]){
                    return true;
                }
            }
        }
        return false;
        }

    public static int searchmore(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>target){
                right = mid-1;
            }
            else if(nums[mid]<=target){
                left = mid+1;
            }
        }
        if(left-1>=0 && nums[left-1] == target){
            return left-1;
        }
        return -1;
    }
    public static int MEX(ArrayList<Integer> arr){
        int num = arr.size();
        int low = Integer.MAX_VALUE;
        HashMap<Integer,Boolean> hash = new HashMap<>();
        for (int i = 0; i < num; i++) {
            hash.put(arr.get(i),true);
            if(low>arr.get(i)){
                low = arr.get(i);
            }
        }
        if(low>0){
            return 0;
        }
        else{
            while (hash.containsKey(low)){
                low++;
            }
            return low;
        }
    }

    public static List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> store = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for (String num : words){
            if(num.equals("prev")){
                count++;
                if(store.size()-count<0){
                    ans.add(-1);
                    continue;
                }
                ans.add(store.get(store.size()-count));
            }
            else{
                count=0;
                store.add(Integer.parseInt(num));
            }
        }
        return ans;
    }
    public static int minimumSum(int[] nums) {
        int[] minleft = new int[nums.length];
        int[] minright = new int[nums.length];
        minleft[0] = nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            minleft[i] = Math.min(minleft[i-1],nums[i]);
        }
        minright[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >0 ; i--) {
            minright[i] = Math.min(minright[i+1],nums[i]);
        }
        int sum = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i]>minleft[i] && nums[i]>minright[i]) sum = Math.min(sum,nums[i]+minleft[i]+minright[i]);
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
    public static int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hash.containsKey(nums[i])){
                hash.put(nums[i],hash.get(nums[i])+1);
                continue;
            }
            hash.put(nums[i],1);
        }
        ArrayList<Integer> array = new ArrayList<>(hash.values());
        for (int i = 0; i < array.size(); i++) {
            if(Math.abs(array.get(i)-array.get(i+1))>1){
                int num = array.get(i)-array.get(i+1);
            }
        }
        return -1;
    }
    public static void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int num : row){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[num][i] = 0;
            }
        }
        for (int num : col){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][num] = 0;
            }
        }
    }
    public static boolean isPowerOfFour(int n) {
        if(n!=0 && n == (int)Math.pow(4,Math.log(n)/Math.log(4)) && Math.log(n)/Math.log(4)%1 == 0){
            return true;
        }
        return false;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> l1 = new ArrayList<>();
        levelOrder(queue,new ArrayDeque<>(),l1);
        return l1;
    }
    public static void levelOrder(Queue<TreeNode> q1,Queue<TreeNode> q2,List<List<Integer>> l1) {
        if(q1.isEmpty()){
            return;
        }
        List<Integer> l = new ArrayList<>();
        while(!q1.isEmpty()){
            TreeNode r = q1.remove();
            l.add(r.val);
            if(r.left!=null){
                q2.add(r.left);
            }
            if(r.right!=null){
                q2.add(r.right);
            }
        }
        l1.add(l);
        levelOrder(q2,q1,l1);
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        rightside(root,l,0);
        return l;
    }
    public static void rightside(TreeNode root,List<Integer> arr,int level){
        if(root == null){
            return;
        }
        if(arr.size() < level){
            arr.add(root.val);
        }
        rightside(root.right,arr,level+1);
        rightside(root.left,arr,level+1);
    }
}