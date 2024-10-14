package practice;

import java.util.*;

import static practice.quicksort.*;


public class done_leetcode {
    public static void main(String[] args) {
        int[] nums = {1,10,3,3,3};
        System.out.println(maxKelements(nums,3));
    }
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int i : nums){
            queue.add(i);
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            int num = queue.poll();
            ans += num;
            queue.add((int)Math.ceil((double) num /3));
        }
        return ans;
    }
    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i).get(0);
            max = Math.max(max, num);
            queue.add(new int[]{num, i,0});
        }
        int min = queue.peek()[0];
        int size = max-min;
        int high = max;
        int low = min;
        while(queue.size() == nums.size()){
            int[] arr = queue.poll();
            int index = arr[1];
            int pos = arr[2];
            if(pos == nums.get(index).size()-1){
                return new int[]{min,max};
            }
            int[] sum = new int[3];
            sum[0] = nums.get(index).get(pos+1);
            sum[1] = index;
            sum[2] = pos+1;
            high = Math.max(high, sum[0]);
            queue.add(sum);

            low = queue.peek()[0];

            if(high-low<max-min){
                max = high;
                min = low;
            }
        }
        return new int[]{min,max};
    }
    public static int minGroups(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if(pq.peek() < intervals[i][0]){
                pq.poll();
                pq.add(intervals[i][1]);
                continue;
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
    public static int smallestChair(int[][] times, int targetFriend) {
        int[][] nums = new int[times.length][3];
        for (int i = 0; i < times.length; i++) {
            nums[i][0] = times[i][0];
            nums[i][1] = times[i][1];
            nums[i][2] = i;
        }
        Arrays.sort(nums,(a,b)->a[0]-b[0]);

        PriorityQueue<Integer> pri = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            pri.add(i);
        }
        PriorityQueue<Integer> freechairs = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            freechairs.add(i);
        }
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int[] num : nums){
            int start = num[0];
            int end = num[1];
            int ind = num[2];

            while(!occupied.isEmpty() && occupied.peek()[0]<=start){
                freechairs.add(occupied.poll()[1]);
            }
            int freechair = freechairs.poll();
            occupied.add(new int[]{end,freechair});
            if(ind == targetFriend){
                return freechair;
            }
        }
        return -1;
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> set  = new HashSet<>();
        int len = graph.length;
        for (int i = 0; i < len; i++) {
            if(graph[i].length == 0){
                set.add(i);
            }
        }
        if(set.size() == 0){
            return new ArrayList<>();
        }
        boolean[] vis = new boolean[len];
        for (int i = 0; i < len; i++) {
            if(set.contains(i) || vis[i]){
                continue;
            }
            runIt(graph,i,vis,set);
        }
        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);
        return arr;
    }
    public static int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int left = 1;
        while(left<len){
            if(arr[left]<arr[left-1]){
                break;
            }
            left++;
        }
        if(left == len){
            return 0;
        }
        left--;
        int right = len-1;
        while(right>0){
            if(arr[right]<arr[right-1]){
                break;
            }
            right--;
        }
        int ans = Math.min(right,len-left-1);
        int i = 0;
        while(i<=left && right<len){
            if(arr[i]<=arr[right]){
                ans = Math.min(ans,right-i-1);
                i++;
            }else{
                right++;
            }
        }
        return ans;
    }
    public static boolean runIt(int[][] graph,int curr,boolean[] vis,Set<Integer> set){
        if(set.contains(curr)){
            vis[curr] = true;
            return true;
        }
        if(vis[curr])
            return false;
        vis[curr] = true;
        boolean ans = true;
        for (int i = 0; i < graph[curr].length; i++) {
            ans &= runIt(graph,graph[curr][i],vis,set);
        }
        if(ans){
            set.add(curr);
        }
        return ans;
    }
    public int maxWidthRamp(int[] nums) {
        int len = nums.length;
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if(nums[stk.peek()]>nums[i]){
                stk.add(i);
            }
        }
        for (int i = len-1; i >=0 ; i--) {
            while(!stk.isEmpty() && nums[i]>=nums[stk.peek()]){
                ans = Math.max(ans,i-stk.pop());
            }
            if(stk.isEmpty()){
                break;
            }
        }
        return ans;
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] tape = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(cycle(graph,new boolean[numCourses],i,tape)){
                return false;
            }
        }
        return true;

    }
    public static boolean cycle(ArrayList<Integer>[] graph,boolean[] stk,int curr,boolean[] tape){
        if(stk[curr]){
            return true;
        }
        if(tape[curr]){
            return false;
        }
        stk[curr] = true;
        tape[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            if(cycle(graph,stk,graph[curr].get(i),tape)){
                return true;
            }
        }
        stk[curr] = false;
        return false;
    }

    public static int minSwaps(String s) {
        int i = 0;
        int len = s.length();
        Stack<Character> stk = new Stack<>();
        int num = 0;
        while(i != len){
            if(s.charAt(i) == '['){
                stk.push('[');
            }
            else if(s.charAt(i) == ']'){
                if(stk.isEmpty()){
                    num ++;
                }else{
                    stk.pop();
                }
            }
            i++;
        }
        int rem = num%2;
        num = num/2;
        return num+rem;
    }

    public static int numIslands(char[][] grid) {
        boolean[][] arr = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !arr[i][j]){
                    ans++;
                    dowork(arr,grid,i,j);
                }
            }
        }
        return ans;
    }

    public static void dowork(boolean[][] arr,char[][] grid,int i,int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length){
            return;
        }
        if(arr[i][j]){
            return;
        }
        if(grid[i][j] == '1'){
            arr[i][j] = true;
        }else{
            return;
        }
        dowork(arr,grid,i-1,j);
        dowork(arr,grid,i+1,j);
        dowork(arr,grid,i,j-1);
        dowork(arr,grid,i,j+1);

    }
    public static int minLength(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0;
        while(i<str.length()-1){
            String ss = str.substring(i,i+2);
            if(ss.equals("AB") || ss.equals("CD")){
                str.delete(i,i+2);
                if(i == 0){
                    continue;
                }
                i--;
                continue;
            }
            i++;
        }
        return str.length();
    }
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.compareTo(sentence2) == 0){
            return true;
        }
        if(sentence1.length()<sentence2.length()){
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }
        int j = sentence1.length()-sentence2.length();
        if(j == 0){
            return false;
        }
        for (int i = 0; j <= sentence1.length() ; i++) {
            String str = sentence1.substring(0,i)+sentence1.substring(j);
            if(str.compareTo(sentence2) == 0){
                if(i == 0){
                    if(sentence1.charAt(j-1) == ' '){
                        return true;
                    }
                }
                else if(j == sentence1.length()){
                    if(sentence1.charAt(i) == ' '){
                        return true;
                    }
                }else{
                    if(sentence1.charAt(j) == ' ' && sentence1.charAt(i) == ' '){
                        return true;
                    }
                }
            }
            j++;
        }
        return false;
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (char c : s1.toCharArray()) {
            arr1[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            arr2[s2.charAt(i) - 'a']++;
        }

        if (matches(arr1, arr2)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            int num1 = s2.charAt(i)-'a';
            int num2 = s2.charAt(i-s1.length()) - 'a';

            arr2[num1]++;

            arr2[num2]--;


            if (matches(arr1, arr2)) {
                return true;
            }
        }

        return false;
    }


    private static boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }



    public static long dividePlayers(int[] skill) {
        long sum = Arrays.stream(skill).sum();
        int n = skill.length/2;
        if(sum%n !=0){
            return -1;
        }
        sum = sum/n;
        int[] sk = new int[(int)sum];
        for (int i = 0; i < skill.length; i++) {
            if(skill[i] >= sum){
                return -1;
            }
            sk[skill[i]]++;

        }
        long ans = 0;
        int fin = sum%2==0 ? (int)sum/2 : (int)(sum+1)/2;
        for (int i = 1; i < fin ; i++) {
            if(sk[i] != sk[(int)(sum)-i]){
                return -1;
            }
            ans += Math.multiplyExact((long)sk[i],Math.multiplyExact((long)i,(long)(sum-i)));
        }
        if(sum%2 ==0){
            int s = (int)sum/2;
            if(sk[s]%2 !=0){
                return -1;
            }
            ans += Math.multiplyExact((long)(sk[s]/2),Math.multiplyExact((long)s,(long)s));
        }
        return ans;
    }

    public static int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2){
                    queue1.add(new int[]{i,j});
                }
            }
        }
        int count = 0;
        while (!queue1.isEmpty()) {
            int[] arr = queue1.remove();
            int i = arr[0];
            int j = arr[1];
            if(visited[i][j]){
                continue;
            }
            visited[i][j] = true;
            if(i-1>=0 && grid[i-1][j]==1){
                grid[i-1][j] = 2;
                queue2.add(new int[]{i-1,j});
            }
            if(j-1>=0 && grid[i][j-1]==1){
                grid[i][j-1] = 2;
                queue2.add(new int[]{i,j-1});
            }
            if(i+1<grid.length && grid[i+1][j]==1){
                grid[i+1][j] = 2;
                queue2.add(new int[]{i+1,j});
            }
            if(j+1<grid[0].length && grid[i][j+1]==1){
                grid[i][j+1] = 2;
                queue2.add(new int[]{i,j+1});
            }
            if(queue1.isEmpty()){
                if(queue2.isEmpty()){
                    break;
                }else{
                    queue1 = new LinkedList<>(queue2);
                    queue2 = new LinkedList<>();
                    count++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return count;
    }
    public static long countCompleteDayPairs(int[] hours) {
        long ans = 0;
        int[] arr = new int[24];
        for (int i : hours){
            ans += arr[(24-(i%24))%24];
            arr[i%24]++;
        }
        return ans;
    }
    public static int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[] newarr = new int[len];
        for (int i = 0; i < len; i++) {
            newarr[i] = arr[i];
        }
        Arrays.sort(newarr);
        HashMap<Integer,Integer> map = new HashMap<>();
        int num = 1;
        for (int i = 0; i < len; i++) {
            if(map.containsKey(newarr[i])){
                continue;
            }
            map.put(newarr[i],num);
            num++;
        }
        for (int i = 0; i < len; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
    public static boolean canArrange(int[] arr, int k) {
        int[] newarr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i]%k;
            if(x<0){
                x = k+x;
            }
            if(x==0){
                if(newarr[x]==0){
                    newarr[x] ++;
                }
                else{
                    newarr[x]--;
                }
            }
            else{
                if(newarr[k-x]==0){
                    newarr[x] += 1;
                }
                else{
                    newarr[k-x]--;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            if(newarr[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        for (String word : words){
            root = cur;
            for(char c : word.toCharArray()){
                if(root.children[c-'a'] == null){
                    TrieNode newNode = new TrieNode();
                    root.children[c-'a'] = newNode;
                    root = newNode;
                }
                else{
                    root = root.children[c-'a'];
                    root.num++;
                }
            }
        }
        int i = 0;
        for(String word : words){
            int num = 0;
            root = cur;
            for(char c : word.toCharArray()) {
                root = root.children[c - 'a'];
                num += root.num;
            }
            res[i] = num;
            i++;
        }
        return res;
    }

    public static int findKthNumber(int n, int k) {
        long curr = 1;
        k--;
        while(k>0){
            int count = count_num(n,curr,curr+1);
            if(count<=k){
                k -=count;
                curr ++;
            }
            else{
                curr *= 10;
                k--;
            }
        }
        return (int)curr;
    }

    public static int count_num(int n,long curr, long next) {
        int count = 0;
        while(curr<=n){
            count += Math.min(next,n+1)-curr;
            curr *= 10;
            next *= 10;
        }
        return count;
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        answer(res,0,n);
        return res;
    }
    public static void answer(List<Integer> ls,int num,int n){
        if(num>n){
            return;
        }
        for(int i = num ; i <= Math.min(num+9,n);i++){
            if(i == 0){
                continue;
            }
            ls.add(i);
            answer(ls,i*10,n);
        }
    }
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                String a = expression.substring(0,i);
                String b = expression.substring(i+1);
                List<Integer> left = diffWaysToCompute(a);
                List<Integer> right = diffWaysToCompute(b);
                for(int x : left){
                    for(int y : right){
                        if(c == '-'){
                            res.add(x-y);
                        }
                        if(c == '*'){
                            res.add(x*y);
                        }
                        if(c == '+'){
                            res.add(x+y);
                        }
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.valueOf(expression));
        }
        return res;
    }
    public static String shortestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }
        int left = 0;
        for (int right = length - 1; right >= 0; right--) {
            if (s.charAt(right) == s.charAt(left)) {
                left++;
            }
        }
        if (left == length) {
            return s;
        }
        String nonPalindromeSuffix = s.substring(left);
        StringBuilder reverseSuffix = new StringBuilder(nonPalindromeSuffix)
                .reverse();
        return reverseSuffix
                .append(shortestPalindrome(s.substring(0, left)))
                .append(nonPalindromeSuffix)
                .toString();
    }

    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int curr = 1;
        int ans = curr;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == max){
                curr++;
                ans = Math.max(ans, curr);
            }else{
                curr = 1;
            }
        }
        return ans;
    }
    public int findTheLongestSubstring(String s) {
        int len = s.length();
        HashMap<Character,Integer> hash = new HashMap<>();
        hash.put('a',1);
        hash.put('e',2);
        hash.put('i',4);
        hash.put('o',8);
        hash.put('u',16);
        int mask = 0;
        int[] seen = new int[32];
        int max = 0;
        Arrays.fill(seen,-1);
        for (int i = 0; i < len; i++) {
            char chr = s.charAt(i);
            mask = mask^(hash.containsKey(chr) ? hash.get(chr):0);
            if(mask !=0 && seen[mask] == -1){
                seen[mask] = i;
            }
            max = Math.max(max,i-seen[mask]);
        }
        return max;
    }
    public static String largestNumber(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return String.valueOf(nums[0]);
        }
        for (int i = 0; i < len; i++) {
            for (int j = len-1; j > i; j--) {
                int len1 = findHeight(nums[j]);
                int len2 = findHeight(nums[j-1]);
                long num1 = nums[j];
                num1 = num1*(int)Math.pow(10,len2);
                num1 += nums[j-1];
                long num2 = nums[j-1];
                num2 = num2*(int)Math.pow(10,len1);
                num2 += nums[j];
                if(num1>num2){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        String str = "";
        for (int i = 0; i < len; i++) {
            if(str.equals("0")){
                return str;
            }
            str+=nums[i];
        }
        return str;
    }
    public static int findHeight(int number) {
        if(number == 0){
            return 1;
        }
        int height = 0;
        while (number != 0) {
            number = number / 10;
            height++;
        }
        return height;
    }
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int hr = ((timePoints.get(i).charAt(0)-'0')*10) + (timePoints.get(i).charAt(1)-'0');
            int min = ((timePoints.get(i).charAt(3)-'0')*10) + (timePoints.get(i).charAt(4)-'0');
            arr[i] = hr*60+min;
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            min = Math.min(min, arr[i]-arr[i-1]);
        }
        min = Math.min(min, arr[0]+(1440-arr[len-1]));
        return min;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int count = 0;
        for(String str : words) {
            int len = str.length();
            boolean found = false;
            for (int i = 0; i < len; i++) {
                if(!set.contains(str.charAt(i))){
                    found = true;
                    break;
                }
            }
            if(!found){
                count++;
            }
        }
        return count;
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if(a == 0){
                ans[i] = arr[b];
                continue;
            }
            ans[i] = arr[b]^arr[a-1];
        }
        return ans;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ahead = head.next;
        ListNode ans = head;
        while (ahead != null) {
            ListNode ls = gcd(head.val, ahead.val);
            head.next = ls;
            head = head.next;
            head.next = ahead;
            head = head.next;
            ahead = ahead.next;
        }
        return ans;
    }
    public ListNode gcd(int a,int b){
        if (b == 0) {
            return new ListNode(a);
        }
        return gcd(b, a % b);
    }
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for(int[] row : matrix)
            Arrays.fill(row , -1);

        if(head == null)
            return matrix;


        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        ListNode current = head;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            for (int j = colBegin; j <= colEnd; j ++) {
                if(current != null){
                    matrix[rowBegin][j] = current.val;
                    current = current.next;
                }
            }
            rowBegin++;

            for (int j = rowBegin; j <= rowEnd; j ++) {
                if(current != null){
                    matrix[j][colEnd] = current.val;
                    current = current.next;
                }
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j --) {
                    if(current != null){
                        matrix[rowEnd][j] = current.val;
                        current = current.next;
                    }
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j --) {
                    if(current != null){
                        matrix[j][colBegin] = current.val;
                        current = current.next;
                    }
                }
            }
            colBegin ++;
        }
        return matrix;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        if(head == null){
            return new ListNode[k];
        }
        ListNode[] ans = new ListNode[k];
        ListNode abc = head;
        int len = 0;
        while (abc!=null){
            abc = abc.next;
            len++;
        }
        int size = len/k;
        int extra = size>0?len%k:0;
        int n = 0;
        while(head!=null){
            ans[n] = head;
            int i = 0;
            if(extra>0){
                while(i<size){
                    head = head.next;
                    i++;
                }
                extra--;
            }
            else {
                while (i < size - 1) {
                    head = head.next;
                    i++;
                }
            }
            ListNode help = head.next;
            head.next = null;
            head = help;
            n++;
        }
        return ans;
    }

    public int chalkReplacer(int[] chalk, int k) {
        long ki = k;
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum+=chalk[i];
        }
        ki = ki%sum;
        if(ki<chalk[0]){
            return 0;
        }
        for (int i = 0; i < chalk.length; i++) {
            if(chalk[i]<=ki){
                ki-=chalk[i];
                continue;
            }
            return i;
        }
        return 0;
    }
    public static int numTeams(int[] rating) {
        int len = rating.length;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            int low1 = 0;
            int high1 = 0;
            int low2 = 0;
            int high2 = 0;
            for (int j = 0; j < len; j++) {
                if(rating[i] > rating[j]){
                    if(j<i){
                        high1++;
                    }
                    else{
                        high2++;
                    }
                }
                if(rating[i] < rating[j]){
                    if(j<i){
                        low1++;
                    }
                    else{
                        low2++;
                    }
                }
            }
            ans+= low1*high2 + low2*high1;
        }
        return ans;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode ans = head;
        int i = 1;
        while (i<k) {
            if(head.next == null){
                return ans;
            }
            head = head.next;
            i++;
        }
        ListNode next = head.next;
        reverse(ans,head);
        ans.next = next;
        ListNode prev = ans;
        ans = head;
        ListNode curr = next;
        next = next.next;
        head = next;
        next = next.next;
        while(head!=null){
            int j = 1;
            while(j<k){
                prev = prev.next;
                curr = curr.next;
                head = head.next;
                if(head == null){
                    return ans;
                }
                next = next.next;
                j++;
            }
            reverse(curr,head);
            prev.next = head;
            curr.next = next;
            prev = curr;
            curr = next;
            if(curr.next == null){
                return ans;
            }
            head = curr.next;
            next = head.next;
        }
        return ans;
    }

    public static void reverse(ListNode init,ListNode fin){
        ListNode temp = init.next;
        ListNode temp2;
        while(init!= fin){
            temp2 = temp.next;
            temp.next = init;
            init = temp;
            temp = temp2;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    public static ListNode merge(ListNode[] lists,int start,int end){
        if (start > end) {
            return null;
        }
        if(start == end){
            return lists[end];
        }
        int mid = (start+end)/2;
        ListNode a = merge(lists,start,mid);
        ListNode b = merge(lists,mid+1,end);
        return join(a,b);
    }
    public static ListNode join(ListNode a,ListNode b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        if(a.val>b.val){
            return join(b,a);
        }
        ListNode ans = a;
        ListNode head = a;
        a = a.next;
        while(a != null && b!= null){
            if(a.val<b.val){
                head.next = a;
                a = a.next;
                head = head.next;
            }
            else{
                head.next = b;
                b = b.next;
                head = head.next;
            }
        }
        if(a == null){
            while(b!= null){
                head.next = b;
                b = b.next;
                head = head.next;
            }
        }
        if(b == null){
            while(a!=null){
                head.next = a;
                a = a.next;
                head = head.next;
            }
        }
        return ans;
    }
    public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];
        //dp[0] represents nums1 values
        //dp[1] represents nums2 values
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        int ans = 1;
        for (int i = 1; i < nums1.length; i++) {
            if(nums1[i]>=nums1[i-1]){
                dp[i][0] = Math.max(dp[i-1][0]+1,dp[i][0]);
            }
            if(nums1[i]>=nums2[i-1]){
                dp[i][0] = Math.max(dp[i-1][1]+1,dp[i][0]);
            }
            if(nums2[i]>=nums2[i-1]){
                dp[i][1] = Math.max(dp[i-1][1]+1,dp[i][1]);
            }
            if(nums2[i]>=nums1[i-1]){
                dp[i][1] = Math.max(dp[i-1][0]+1,dp[i][1]);
            }
            ans = Math.max(ans,Math.max(dp[i][0],dp[i][1]));
        }
        return ans;
    }
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            long fin = 0;
            int n = 0;
            if(num == 0){
                fin = mapping[num];
            }
            while (num!=0) {
                int left = num%10;
                left = mapping[left];
                fin += (long)left*(long)(Math.pow(10,n));
                num = num/10;
                n++;
            }
            arr[i] = fin;
        }
        quick(nums,arr,0,nums.length-1);
        return nums;
    }
    public static int bestTeamScore(int[] scores, int[] ages) {
        int length = scores.length;
        quick(scores,ages,0,length-1);
        int abc = 0;
        while(abc<length-1){
            if(ages[abc] == ages[abc+1]){
                int a = abc;
                while(abc<length-1 && ages[abc] == ages[abc+1]){
                    abc++;
                }
                quicksingle(scores,a,abc);
                continue;
            }
            abc++;
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scores[i];
        }
        int max = arr[0];
        for(int i = 1;i<length;i++){
            for (int j = 0; j < i; j++) {
                if(scores[j]>scores[i]){
                    if(ages[i] == ages[j]){
                        arr[i] = Math.max(arr[i],arr[j]+scores[i]);
                        max = Math.max(max,arr[i]);
                    }
                }
                else{
                    arr[i] = Math.max(arr[i],arr[j]+scores[i]);
                    max = Math.max(max,arr[i]);
                }
            }
        }
        return max;
    }
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(strs.length == 1){
            return strs[0];
        }
        int num = 0;
        char[] str = strs[0].toCharArray();
        char[] str2 = strs[1].toCharArray();
        for (int i = 0; i < Math.min(str.length,str2.length); i++) {
            if(str[i]!=str2[i]){
                break;
            }
            num++;
        }
        for (int i = 2; i <length ; i++) {
            int n = 0;
            int len = strs[i].length();
            for (int k = 0; k < Math.min(num,len); k++) {
                if(str[k] != strs[i].charAt(k)){
                    break;
                }
                n++;
            }
            num = n;
        }
        return strs[0].substring(0,num);
    }
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] ans = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
        }
        Arrays.sort(ans, (o1, o2) -> {
            if(map.get(o1) == map.get(o2)){
                return Integer.compare(o2,o1);
            }
            return Integer.compare(map.get(o1), map.get(o2));
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
        return nums;
    }
    public static void reverse(int[][] num,int i,int j){
        while(i<j){
            int temp1 = num[0][i];
            num[0][i] = num[0][j];
            num[0][j] = temp1;
            i++;
            j--;
        }
    }
    public static String[] sortPeople(String[] names, int[] heights) {
        quickcenter(names, heights, 0, heights.length - 1);
        return names;
    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode dum = dummyHead;
        head = head.next;
        while(head!=null){
            int num = 0;
            while(head.val!=0){
                num+= head.val;
                head=head.next;
            }
            ListNode n = new ListNode(num);
            dummyHead.next = n;
            dummyHead = dummyHead.next;
            head = head.next;
        }
        return dum.next;
    }
    public int lengthOfLIS(int[] nums) {
        return answer(nums,nums.length);
    }
    public static int answer(int[] nums,int j){
//        int num = 1;
//        for (int i = j-1; i >=0 ; i--) {
//            if(nums[i]<nums[j]) {
//                num = Math.max(answer(nums, i)+1, num);
//            }
//            else{
//                num = Math.max(answer(nums,i),num);
//            }
//        }
//        return num;
        int max = 1;
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int k = 0; k < i; k++) {
                if(nums[i]>nums[k]){
                    arr[i] = Math.max(arr[i],arr[k]+1);
                }
                max = Math.max(max,arr[i]);
            }
        }
        return max;
    }
    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int empbottle = 0;
        while(numBottles>0){
            ans+=numBottles;
            int temp = numBottles;
            numBottles = (numBottles+empbottle)/numExchange;
            empbottle = (temp+empbottle)%numExchange;
        }
        return ans;
    }
    public static int passThePillow(int n, int time) {
        if(time<n){
            return time+1;
        }
        if(n == 2){
            return time%2==0 ? 1:2;
        }
        time = time+1;
        int row = 1;
        int abc = time-n;
        int col = abc%(n-1);
        row += abc/(n-1);
        if(col>0){
            row++;
        }
        if(row%2==0){
            if(col==0){
                return 1;
            }
            return n-col;
        }
        else{
            if(col==0){
                return n;
            }
            return col+1;
        }
    }
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int num = 1;
        int dis = -1;
        int pr = -1;
        int first = -1;
        int last = -1;
        ListNode prev = head;
        ListNode after = head.next.next;
        if(after==null){
            return new int[]{-1,-1};
        }
        head = head.next;
        while(after!=null){
            int num1 = prev.val;
            int num2 = after.val;
            if((head.val>num1 && head.val>num2) || (head.val<num1 && head.val<num2)){
                if(first!=-1){
                    last = num;
                }
                else{
                    first = num;
                }
                if(dis!=-1){
                    dis = Math.min(last-pr,dis);
                    pr = last;
                }else{
                    if(pr == -1){
                        pr = first;
                    }
                    else{
                        dis = last-first;
                        pr = last;
                    }
                }
            }
            prev = head;
            head = after;
            after = after.next;
            num++;
        }
        if(dis==-1){
            return new int[]{-1,-1};
        }else{
            return new int[]{dis,last-first};
        }
    }
    public static ListNode removeNodes(ListNode head) {
        if(head == null){
            return null;
        }
        head.next = removeNodes(head.next);
        return head.next != null && head.val<head.next.val ? head.next : head;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        sub(nums,0,ans,new ArrayList<>());
        return ans;
    }
    public static void sub(int[] nums,int ind,List<List<Integer>> subsets,List<Integer> subs){
        if(ind == nums.length){
            subsets.add(subs);
            return;
        }
        sub(nums,ind+1,subsets,subs);
        List<Integer> abc = new ArrayList<>(subs);
        abc.add(nums[ind]);
        sub(nums,ind+1,subsets,abc);
    }

    public static int scoreOfString(String s) {
        int ans = 0;
        for (int i = 0; i < s.length()-1; i++) {
            ans += Math.abs(s.charAt(i)-s.charAt(i+1));
        }
        return ans;
    }

    public static ListNode doubleIt(ListNode head){
        if(head == null){
            return null;
        }
        head = doublesIt(head);
        if(head.val > 9){
            ListNode head1 = new ListNode(head.val/10);
            head.val = head.val%10;
            head1.next = head;
            head = head1;
        }
        return head;
    }
    public boolean evaluateTree(TreeNode root) {
        //0 - false 1-true
        //2 - OR 3-AND
        if(root.val == 0){
            return false;
        }
        if(root.val == 1){
            return true;
        }
        if(root.val == 2){
            return evaluateTree(root.left) | evaluateTree(root.right);
        }else{
            return evaluateTree(root.left) & evaluateTree(root.right);
        }
    }

    public static ListNode doublesIt(ListNode head) {
        if(head == null){
            return null;
        }
        head.next = doublesIt(head.next);
        head.val = head.val*2;
        if(head.next == null){
            return head;
        }
        if(head.next.val>9){
            head.val = head.val + head.next.val/10;
            head.next.val = head.next.val%10;
        }
        return head;
    }
    public static int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        Arrays.sort(people);
        int left = 0;
        int right = len-1;
        int ans = 0;
        while(right>=left){
            if(people[right]+people[left]>limit){
                right--;
            }else{
                right--;
                left++;
            }
            ans++;
        }
        return ans;
    }

    public static int findPeakElement(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums[0]);
        return 0;
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        return sumof(root,false);
    }
    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return numberfin(root,0);
    }
    public static int numberfin(TreeNode root,int sum){
        if(root.left == null && root.right == null){
            return sum*10+root.val;
        }
        if(root == null){
            return sum;
        }
        int left = numberfin(root.left,(sum*10)+root.val);
        int right = numberfin(root.right,(sum*10)+root.val);
        return left+right;
    }
    public static int sumof(TreeNode root,boolean left){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            if(left){
                return root.val;
            }
            return 0;
        }
        int root1 = sumof(root.left,true);
        int root2 = sumof(root.right,false);
        return root1+root2;
    }
    public static long countSubarrays(int[] nums, int k) {
        int max = 0;
        int len = nums.length;
        for(int num : nums){
            if(num>max){
                max = num;
            }
        }
        int l = 0;
        int r = 0;
        int count = 0;
        long ans = 0;
        for (; r<len ; r++) {
            if(nums[r] == max){
                count++;
            }
            while(count == k){
                if(nums[l++] == max){
                    count--;
                }
            }
            ans +=l;
        }
        return ans;
    }
    public static String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder(s);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '('){
                stk.add(i);
            }
            if(str.charAt(i) == ')'){
                if(stk.isEmpty()){
                    str.deleteCharAt(i);
                    i--;
                    continue;
                }
                stk.pop();
            }
        }
        while(!stk.isEmpty()){
            str.deleteCharAt(stk.pop());
        }
        return str.toString();
    }
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int len = tickets.length;
        int sum = 0;
        for (int i = 0; i <len ; i++) {
            if(i<k){
                if(tickets[i]<=tickets[k]){
                    sum += tickets[i];
                }
                else{
                    sum+=tickets[k];
                }
            }
            else if(i == k){
                sum+=tickets[i];
            }
            else{
                if(tickets[i]>=tickets[k]){
                    sum+=tickets[k]-1;
                }
                else{
                    sum+=tickets[i];
                }

            }
        }
        return sum;
    }
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode abc = null;
        if(a == 0){
            head = list2;
            abc = list1;

        }
        else{
            for (int i = 1; i <= a; i++) {
                if(i == a){
                    abc = list1.next;
                    list1.next = list2;
                    break;
                }
                list1 = list1.next;
            }
        }
        for (int i = 1; i <=b-a ; i++) {
            abc = abc.next;
        }
        while(list2.next!=null){
            list2 = list2.next;
        }
        list2.next = abc.next;
        return head;
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            nums[Math.abs(num)-1] *= -1;
            if(nums[Math.abs(num)-1]>0){
                list.add(num);
            }
        }
        return list;
    }
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int i : nums){
            if(i<k){
                ans++;
            }
        }
        return ans;
    }
    public static int maxSubarrayLength(int[] nums, int k) {
        int len = nums.length;
        if(len == 1){
            return 1;
        }
        HashMap<Integer,Integer> hash = new HashMap<>();
        int left = 0;
        int right = 1;
        int ans = 0;
        hash.put(nums[0],1);
        while(right<len){
            if(hash.containsKey(nums[right]) && hash.get(nums[right])==k){
                while(left<right){
                    hash.put(nums[left],hash.get(nums[left])-1);
                    if(nums[left] == nums[right]){
                        left++;
                        break;
                    }
                    left++;
                }
            }
            if(hash.containsKey(nums[right])){
                hash.put(nums[right],hash.get(nums[right])+1);
            }else{
                hash.put(nums[right],1);
            }
            if(right-left+1>ans){
                ans = right-left+1;
            }
            right++;
        }
        return ans;
    }
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int num = 0;
        for (int i = 0; i <len ; i++) {
            if(nums[i] == 1){
                num = 1;
            }
            if(nums[i]<=0){
                nums[i] = 1;
            }
        }
        if(num == 0){
            return 1;
        }
        for (int i = 0; i < len; i++) {
            num = Math.abs(nums[i]);
            if(num>len || num == 0){
                continue;
            }
            nums[num-1] = -1*Math.abs(nums[num-1]);
        }
        for (int i = 0; i < len; i++) {
            if(nums[i] >0){
                return i+1;
            }
        }
        return len+1;
    }
    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        while(head != null){
            stk.add(head);
            head = head.next;
        }
        if(stk.isEmpty()){
            return null;
        }
        ListNode head2 = stk.peek();
        ListNode num = stk.pop();
        while(!stk.isEmpty()){
            num.next = stk.pop();
            num = num.next;
        }
        num.next = null;
        return head2;
    }

    public static int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        arr[0] = true;
        arr[1] = true;
        int ans = 0;
        for (int i = 2; i <n ; i++) {
            if(!arr[i]) {
                for (int j = i*2; j<n; j = j+i) {
                    arr[j] = true;
                }
            }
        }
        for (int i = 2; i <n ; i++) {
            if(arr[i]){
                ans++;
            }
        }
        return ans;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == target){
                    return true;
                }
                if(matrix[i][j]>target){
                    break;
                }
            }
        }
        return false;
    }
    public String customSortString(String order, String s) {
        int len = s.length();
        int[] arr = new int[26];
        for (int i = 0; i <len ; i++) {
            arr[s.charAt(i)-'a']++;
        }
        String ans = "";
        int len2 = order.length();
        for (int i = 0; i < len2; i++) {
            char a = order.charAt(i);
            while(arr[a-'a']!=0){
                ans += a;
                arr[a-'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while(arr[i]!=0){
                ans += (char)(i+'a');
                arr[i]--;
            }
        }
        return ans;
    }
    public static int pivotInteger(int n) {
        int sum = (n*(n+1))/2;
        for (int i = n; i >=1; i--) {
            int num1 = (i*(i+1))/2;
            int num2 = sum-num1+i;
            if(num1 == num2){
                return i;
            }
        }
        return -1;
    }
    public static boolean canSplitArray(List<Integer> nums, int m) {
        int len = nums.size();
        int[] count = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum+=nums.get(i);
            count[i] = sum;
        }
        int left = 0;
        int right = len-1;
        int point = 0;
        while(left<right){
            int dig1 = count[right-1]-point;
            int dig2 = count[right]-count[left];
            if(dig1>=m || dig2>=m || right-left == 1){
                if(dig1>=dig2){
                    right--;
                    point = count[left-1];
                }else{
                    left++;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i:nums1){
            hash.add(i);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i:nums2){
            if(hash.contains(i)){
                hash.remove(i);
                arr.add(i);
            }
        }
        int[] abc = new int[arr.size()];
        for(int i=0;i<abc.length;i++){
            abc[i] = arr.get(i);
        }
        return abc;
    }
    public int getCommon(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int one = 0;
        int two = 0;
        while(one<len1 && two<len2){
            if(nums1[one] == nums2[two]){
                return nums1[one];
            }
            if(nums1[one]>nums2[two]){
                two++;
            }else{
                one++;
            }
        }
        return -1;
    }
    public static int minOper(String str) {
        Map<Character, List<Integer>> charPositions = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charPositions.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        int minOps = Integer.MAX_VALUE;
        for (List<Integer> posList : charPositions.values()) {
            int size = posList.size();
            for (int i = 1; i < size; i++) {
                minOps = Math.min(minOps, posList.get(i) - posList.get(i - 1));
            }
        }

        return minOps == Integer.MAX_VALUE ? 0 : minOps;
    }
    public static int minimumLength(String s) {
        int left = 0;
        int right = s.length()-1;
        char l = s.charAt(left);
        char r = s.charAt(right);
        while(l == r && left<right){
            left++;right--;
            while(s.charAt(left) == l && left<=right){
                left++;
            }
            while(s.charAt(right) == r && left<=right){
                right--;
            }
            l = s.charAt(left);
            r = s.charAt(right);
        }
        return (left>right) ? 0 : right-left+1;
    }
    public static int func(int n,int[] arr){
        Arrays.sort(arr);
        int ans = arr[n-1];
        for (int i = n-1; i >=0 ; i--) {
                int min = arr[i];
                if(min*(n-i)>ans){
                    ans = min*(n-1);
                }
        }
        return ans;
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int ans = 0;
        int left = 0;
        int right = tokens.length-1;
        int num = 0;
        while(left<=right){
            if(power>=tokens[left]){
                power -= tokens[left];
                num++;
                left++;
            }
            else{
                if(num>0) {
                    power += tokens[right];
                    num--;
                    right--;
                }else{
                    return ans;
                }
            }
            if(num>ans){
                ans = num;
            }
        }
        return ans;
    }
    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        int left = 0;
        int right = len-1;
        int ind = len-1;
        while(left<=right){
            int num1 = Math.abs(nums[left]);
            int num2 = Math.abs(nums[right]);
            if(num1>num2){
                arr[ind] = num1*num1;
                left++;
            }else{
                arr[ind] = num2*num2;
                right--;
            }
            ind--;
        }
        return arr;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        for (int i = 0; i < n; i++) {
            l1 = l1.next;
        }
        if(l1 == null){
            return head.next;
        }
        while(l1.next != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        l2.next = l2.next.next;
        return head;
    }
    public static String maximumOddBinaryNumber(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i <len ; i++) {
            if(s.charAt(i) == '1'){
                count++;
            }
        }
        len = len-count;
        String str = "";
        while(count!=1){
            str+='1';
            count--;
        }
        while(len!=0){
            str+='0';
            len--;
        }
        return str+'1';
    }
    public static boolean isValidBST(TreeNode root) {
        isvalidBST(root);
        int num = arr.size();
        if(arr.size() == 1){
            return true;
        }
        int val = arr.get(0);
        for (int i = 1; i <num-1 ; i++) {
            if(val>=arr.get(i)){
                return false;
            }
            val = arr.get(i);
        }
        return true;
    }
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void isvalidBST(TreeNode root){
        if(root == null){
            return;
        }
        isvalidBST(root.left);
        arr.add(root.val);
        isvalidBST(root.right);
    }


    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String str = countAndSay(n-1);
        String string = "";
        char s = 'a';
        int num = 0;
        for (int i = 0; i <str.length() ; i++) {
            if(s == str.charAt(i)){
                num++;
            }
            else{
                if(i!=0) {
                    string += num + "" + s;
                }
                num = 1;
                s = str.charAt(i);
            }
        }
        string += num+""+s;
        return string;
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;
        int num = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int i = 1;
        while(i<len && num<=bricks){
            int k = heights[i]-heights[i-1];
            if(k>0){
                num+=k;
                queue.add(k);
            }
            if(num>bricks && ladders>0){
                num-=queue.remove();
                ladders--;
            }
            if(num>bricks){
                break;
            }
            i++;
        }
        return --i;
    }
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(startRow>=m || startRow<0 || startColumn>=n || startColumn<0){
            return 1;
        }
        if(maxMove==0){
            return 0;
        }
        return findPaths(m,n,maxMove-1,startRow+1,startColumn)
                +findPaths(m,n,maxMove-1,startRow,startColumn+1)
                +findPaths(m,n,maxMove-1,startRow-1,startColumn)
                +findPaths(m,n,maxMove-1,startRow,startColumn-1);
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
    public static int numSpecial(int[][] mat) {
        ArrayList<sparse> ans = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==1){
                    sparse num = new sparse(i,j);
                    ans.add(num);
                }
            }
        }
        int ansf = 0;
        int i = 0;
        while(i!=ans.size()){
            sparse num = ans.get(i);
            if(check(ans,num.i,num.j)){
                ans.remove(num);
                ansf++;
                continue;
            }
            i++;
        }
        return ansf;
    }
    public static boolean check(ArrayList<sparse> array,int i,int j){
        for (sparse num : array){
            if(num.i == i && num.j!=j){
                return false;
            }
            if(num.i !=i && num.j == j){
                return false;
            }
        }
        return true;
    }
    public static int[] rearrangeArray(int[] nums) {
        int posIdx = 0;
        int negIdx = 1;
        int[] result = new int[nums.length];
        for (int num : nums) {
            if (num > 0) {
                result[posIdx] = num;
                posIdx += 2;
            } else {
                result[negIdx] = num;
                negIdx += 2;
            }
        }
        return result;
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int len = grid.length;
        int length = grid[0].length;
        int l = len+length;
        int[] row = new int[len];
        for (int i = 0; i < len; i++) {
            rowone(row, i, length, grid);
        }
        int[] col = new int[length];
        for (int i = 0; i < length; i++) {
            colone(col, i, len, grid);
        }
        int[][] diff = new int[len][length];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < length; j++) {
                diff[i][j] = 2 * (row[i] + col[j]) - l;
            }
        }
        return diff;
    }

    public static void rowone(int[] row, int i, int length, int[][] grid) {
        int count = 0;
        for (int j = 0; j < length; j++) {
            if (grid[i][j] == 1) {
                count++;
            }
        }
        row[i] = count;
    }

    public static void colone(int[] col, int j, int len, int[][] grid) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (grid[i][j] == 1) {
                count++;
            }
        }
        col[j] = count;
    }
    public static String defangIPaddr(String address) {
        StringBuilder add = new StringBuilder(address);
        int i =0;
        int j = 0;
        while(i<add.length()){
            int size = add.length();
            if(address.charAt(j) == '.'){
                add.insert(i,'[');
                add.insert(i+2,']');
                i = i+3;
                j++;
                continue;
            }
            i++;
            j++;
        }
        return add.toString();
    }
    public static String destCity(List<List<String>> paths) {
        HashMap<String,String> hash = new HashMap<>();
        for (List<String> path : paths){
            hash.put(path.get(0),path.get(1));
        }
        String s = paths.get(0).get(1);
        while(hash.containsKey(s)){
            s = hash.get(s);
        }
        return s;
    }
    public static int numSplits(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int[] arrleft = new int[len];
        int[] arrright = new int[len];
        char[] str = s.toCharArray();
        for (int i = 0; i <len ; i++) {
            set.add(str[i]);
            arrleft[i] = set.size();
        }
        if(arrleft[len-1] %2 !=0){
            return 0;
        }
        set = new HashSet<>();
        for (int i = len-1; i >=0 ; i--) {
            set.add(str[i]);
            arrright[i] = set.size();
        }
        int ans = 0;
        for (int i = 0; i < len-1; i++) {
            if(arrleft[i] == arrright[i+1]){
                ans++;
            }
            if(arrleft[i] > arrright[i]){
                break;
            }
        }
        return ans;
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] set = new int[26];
        for (int i = 0; i < s.length(); i++) {
            set[s.charAt(i) - 'a']++;
            set[t.charAt(i) - 'a']--;
        }
        for (int n : set) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
    public static List<String> fizzBuzz(int n) {
        List<String> l = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            if(i%3 == 0 && i%5 == 0){
                l.add("FizzBuzz");
            } else if (i % 3 == 0) {
                l.add("Fizz");
            }else if(i%5 == 0){
                l.add("Buzz");
            }else{
                l.add(i+"");
            }
        }
        return l;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        if(lenp>lens){
            return new ArrayList<>();
        }
        List<Integer> l = new ArrayList<>();
        HashMap<Character,Integer> hash = new HashMap<>();
        for (char pp : p.toCharArray()){
            if(hash.containsKey(pp)){
                hash.put(pp,hash.get(pp)+1);
                continue;
            }
            hash.put(pp,1);
        }
        for (int i = 0; i <lenp ; i++) {
            char h = s.charAt(i);
            if(hash.containsKey(h)){
                if(hash.get(h)>1){
                    hash.put(h,hash.get(h)-1);
                }else{
                    hash.remove(h);
                }
            }
        }
        for (int i = 1; i <lens-lenp+1 ; i++) {

        }
        return l;
    }
    public static int maxProductDifference(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return (nums[len-1]*nums[len-2])-(nums[0]*nums[1]);
    }
    public static int reductionOperations(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int num = nums[0];
        int ans = 0;
        int f = 0;
        for (int i = 0; i < len; i++) {
            if(num == nums[i]){
                continue;
            }
            if(nums[i] != nums[i-1]){
                f+=1;
            }
            ans+=f;
        }
        return ans;
    }
    public static boolean areOccurrencesEqual(String s) {
        int[] ch = new int[26];
        for (char i : s.toCharArray()){
            ch[i-'a']++;
        }
        int n = 0;
        for (int num : ch){
            if(num == 0){
                continue;
            }
            if(num!=0 && n == 0){
                n = num;
            }
            if(num!=n){
                return false;
            }
        }
        return true;
    }
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int num : rolls){
            sum+=num;
        }
        int number = (mean*(m+n))-sum;
        if(number<0 || number<n || number>n*6){
            return new int[0];
        }
        int carry = number%n;
        number /=n;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = number+carry;
            carry = 0;
            if(ans[i]>6){
                carry = ans[i]-6;
                ans[i] = 6;
            }
        }
        return ans;
    }
    public static int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = return_ans(img,i,j,m,n);
            }
        }
        return ans;
    }
    public static int return_ans(int[][] img,int i,int j,int m,int n){
        int count = 0;
        int sum = 0;
        for (int k = i-1; k <= i+1; k++) {
            for (int l = j-1; l <= j+1; l++) {
                if(k<0 || l<0 || k>=m || l>=n){
                    continue;
                }
                sum+=img[k][l];
                count++;
            }
        }
        return sum/count;
    }
    public static int buyChoco(int[] prices, int money) {
        int len = prices.length;
        int small = Integer.MAX_VALUE;
        int small2 = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i <len ; i++) {
            int p = prices[i];
            if(small>p){
                small = p;
                index = i;
            }
        }
        for (int i = 0; i < len; i++) {
            if(i == index){
                continue;
            }
            int p = prices[i];
            if(small2>p){
                small2 = p;
            }
        }
        return money-small-small2 >=0 ? money-small-small2 : money;
    }
    public static void nextPermutation(int[] nums) {
        int flag = -1;
        for (int i = nums.length-1; i >0 ; i--) {
            if(nums[i]>nums[i-1]){
                flag = i-1;
                break;
            }
        }
        if(flag == -1){
            Arrays.sort(nums);
            return;
        }
        int num = nums[flag];
        int ind = -1;
        int larg = Integer.MAX_VALUE;
        for (int i = flag+1; i <nums.length ; i++) {
            if(nums[i]>num && nums[i]<larg){
                larg = nums[i];
                ind = i;
            }
        }
        nums[flag] = nums[ind]+nums[flag];
        nums[ind] = nums[flag]-nums[ind];
        nums[flag] = nums[flag]-nums[ind];
        for (int i = flag+2; i <nums.length ; i++) {
            int hel = nums[i];
            int j = i-1;
            while(j>=flag+1 && hel<nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = hel;
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        int l = 1;
        for (int i = 1; i <= len; i++) {
            l*=i;
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            l1.add(nums[i]);
        }
        ans.add(l1);
        for (int i = 0; i <l-1 ; i++) {
            nextPermutation(nums);
            List<Integer> l2 = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                l2.add(nums[j]);
            }
            ans.add(l2);
        }
        return ans;
    }
    public static int maxWidthOfVerticalArea(int[][] points) {
        int len = points.length;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i <len ; i++) {
            hash.put(points[i][0],1);
        }
        int num = hash.size();
        Set<Integer> set = new HashSet<>(hash.keySet());
        int j = 0;
        int ans = 0;
        int old = 0;
        for(int i : set){
            if(j == 0){
                old = i;
                j++;
                continue;
            }
            if(i-old>ans){
                ans = i-old;
            }
            old = i;
        }
        return ans;
    }
    public static int maxScore(String s) {
        int len = s.length();
        int[] zero = new int[len];
        int[] one = new int[len];
        char[] arr = s.toCharArray();
        int num = 0;
        for (int i = 0; i < len; i++) {
            if(arr[i] == '0'){
                num++;
                zero[i] = num;
            }
        }
        num = 0;
        for (int i = len-1; i >=0 ; i--) {
            if(arr[i] == '1'){
                num++;
                one[i] = num;
            }
        }
        int max = 0;
        for (int i = 0; i < len-1; i++) {
            max = Math.max(zero[i]+one[i+1],max);
        }
        return max;
    }
    public static boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null){
            return false;
        }
        return iscontinuous(head,root)||isSubPath(head,root.left)||isSubPath(head,root.right);
    }
    public static boolean iscontinuous(ListNode head,TreeNode root){
        if(head == null){
            return true;
        }
        if(root == null){
            return false;
        }
        return (head.val == root.val)&&(iscontinuous(head.next,root.left)||iscontinuous(head.next,root.right));
    }
    public static void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
    public static boolean helper(char[][] board,int row,int col){
        if(row == board.length){
            return true;
        }
        int nrow;
        int ncol;
        if(col != board.length-1){
            nrow = row;
            ncol = col+1;
        }else{
            nrow = row+1;
            ncol = 0;
        }
        if(board[row][col]!='.'){
            if(helper(board,nrow,ncol)){
                return true;
            }
        }else{
            for (int i = 1; i <=9 ; i++) {
                if(isSafe(board,row,col,i)){
                    board[row][col] = (char)(i+'0');
                    if(helper(board,nrow,ncol)){
                        return true;
                    }else{
                        board[row][col] = '.';
                    }
                }
            }
        }
        return false;
    }
    public static boolean isSafe(char[][] board,int row,int col,int number){
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == (char)(number+'0')){
                return false;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if(board[row][i] == (char)(number+'0')){
                return false;
            }
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for (int i = sr; i <sr+3 ; i++) {
            for (int j = sc; j <sc+3 ; j++) {
                if(board[i][j] == (char)(number+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public static int maximum69Number (int num) {
        String s = Integer.toString(num);
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '6'){
                arr[i] = '9';
                break;
            }
        }
        int ans = 0;
        for (int i = arr.length-1; i >=0; i--) {
            ans+=(int)(arr[i]-'0')*(int)Math.pow(10,arr.length-i-1);
        }
        return ans;
    }
    public static boolean isPathCrossing(String path) {
        HashMap<Integer,Set<Integer>> hash = new HashMap<>();
        int i = 0;
        int j = 0;
        Set<Integer> set1 = new HashSet<>();
        set1.add(j);
        hash.put(i,set1);
        for (char h : path.toCharArray()){
            if(h == 'N'){
                j++;
            } else if (h == 'S') {
                j--;
            } else if (h == 'E') {
                i++;
            } else if (h == 'W') {
                i--;
            }
            if(!hash.containsKey(i)){
                Set<Integer> set = new HashSet<>();
                set.add(j);
                hash.put(i,set);
            }
            else{
                if(hash.get(i).contains(j)){
                    return true;
                }else{
                    hash.get(i).add(j);
                }
            }
        }
        return false;
    }
    public static int minOperations(String s) {
        int len = s.length();
        char[] ch = s.toCharArray();
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i <len ; i++) {
            if(i%2 == 0){
                if(ch[i] == '0'){
                    num2++;
                }else{
                    num1++;
                }
            }else{
                if(ch[i] == '1'){
                    num2++;
                }else{
                    num1++;
                }
            }
        }
        return Math.min(num1,num2);
    }
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        for(int num1 : arr1){
            String str1 = String.valueOf(num1);
            int len1 = str1.length();
            for(int num2 : arr2){
                String str2 = String.valueOf(num2);
                int len2 = str2.length();
                int min = Math.min(len1,len2);
                if(str1.equals(str2)){
                    ans = Math.max(ans,len1);
                }
                else{
                    for (int i = 0; i <min ; i++) {
                        if(str1.charAt(i)!=str2.charAt(i)){
                            break;
                        }
                        ans = Math.max(ans,i+1);
                    }
                }
            }
        }
        return ans;
    }
    public static long minimumCost(String s) {
        int len = s.length();
        long ans = 0;
        boolean check = false;
        char prev = s.charAt(0);
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if(check){
                c = c == '0' ? '1' : '0';
            }
            if(c != prev){
                if(i>(len-i)){
                    check = !check;
                    ans += (len-i);
                }
                else{
                    ans += i;
                    prev = prev == '0' ? '1' : '0';
                }
            }
        }
        return ans;
    }
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        int i = 0;
        int j = 0;
        for (int k = 0; k < len/2; k++) {
            for (int l = i; l < len-i-1; l++) {
                input(matrix,j,l);
            }
            i++;
            j++;
        }
    }
    public static void input(int[][] matrix,int i,int j){
        int len = matrix.length;
        int prev = matrix[i][j];
        for (int k = 0; k < 4; k++) {
            int m = i;
            i = j;
            j = len-m-1;
            int temp = matrix[i][j];
            matrix[i][j] = prev;
            prev = temp;
        }
    }
//    public static int numDecodings(String s) {
//
//    }
//    public static int numRollsToTarget(int n, int k, int target) {
//
//    }
//    public static long numRollsToTargetfun(int n,int k,int target){
//
//    }
//    public int minDifficulty(int[] jobDifficulty, int d) {
//
//    }
}
