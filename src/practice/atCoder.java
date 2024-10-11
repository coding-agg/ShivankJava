package practice;

import java.util.*;

public class atCoder {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        String str = scn.next();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(i) - 'a';
        }
        Arrays.sort(arr);
        int ans = 0;
        ans += check_pal(arr, n, k);
        while (nextp(arr)) {
            ans += check_pal(arr, n, k);
        }
        System.out.println(ans);
    }

    public static boolean pallindrome(int[] arr, int start, int end) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int check_pal(int[] arr, int n, int k) {
        for (int i = 0; i <= n - k; i++) {
            if (pallindrome(arr, i, i + k - 1)) {
                return 0;
            }
        }
        return 1;
    }

    public static boolean nextp(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1, n - 1);
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}