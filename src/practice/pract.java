package practice;
import java.util.*;

public class pract {
    public static void main(String[] args) {
        int[] arr = {7,6,5,9,8,0};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
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

}