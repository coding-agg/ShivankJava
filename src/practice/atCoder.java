package practice;

import java.util.*;

public class atCoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the grid (N)
        int N = scanner.nextInt();
        char[][] grid = new char[N][N];

        // Read the grid input
        for (int i = 0; i < N; i++) {
            String line = scanner.next();
            grid[i] = line.toCharArray();
        }

        // Perform the operations for i = 1 to N/2
        for (int i = 1; i <= N / 2; i++) {
            // Determine the range for x and y
            int start = i;
            int end = N + 1 - i;

            for (int x = start; x <= end; x++) {
                for (int y = start; y <= end; y++) {
                    // Calculate the corresponding positions
                    int targetX = y - 1; // converting to 0-indexed
                    int targetY = N - x; // converting to 0-indexed

                    // Swap colors
                    char temp = grid[targetY][targetX];
                    grid[targetY][targetX] = grid[x - 1][y - 1];
                    grid[x - 1][y - 1] = temp;
                }
            }
        }

        // Print the final state of the grid
        for (int i = 0; i < N; i++) {
            System.out.println(grid[i]);
        }

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