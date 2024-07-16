package practice;

import java.util.*;

public class done_geeksforgeeks {
    public static void main(String[] args) {
        System.out.println(reversedBits((long)5));
    }
    public static Long reversedBits(Long x) {
        String num = Long.toBinaryString(x);
        int len = num.length();
        long two = 2147483647;
        two++;
        long ans = 0;
        for (int i = len-1; i >= 0; i--) {
            if(num.charAt(i) == '1'){
                ans += two;
            }
            two /= 2;
        }
        return ans;
    }
    public static ArrayList<Integer> noSibling(Node node)
    {
        ArrayList<Integer> arr = noFSibling(node);
        Collections.sort(arr);
        return arr;
    }

    public static ArrayList<Integer> noFSibling(Node node)
    {
        if(node == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> arrcur = new ArrayList<>();
        ArrayList<Integer> arrleft = noFSibling(node.left);
        ArrayList<Integer> arrright = noFSibling(node.right);

        if(node.left != null && node.right == null){
            arrcur.add(node.left.data);
        }else if(node.left == null && node.right != null){
            arrcur.add(node.right.data);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : arrleft){
            arr.add(num);
        }
        for(int num : arrcur){
            arr.add(num);
        }
        for(int num : arrright){
            arr.add(num);
        }
        return arr;
    }
    public static String func(String s){
        for (int i = 1; i <16 ; i+=2) {
            if(s.charAt(i) == '1'){
                return "No";
            }
        }
        return "Yes";
    }

    public static boolean isAnagram(String a,String b) {
        int len1 = a.length();
        int len2 = b.length();
        int[] arr = new int[26];
        for (int i = 0; i < len1; i++) {
            arr[a.charAt(i)-'a'] +=1;
        }
        for (int i = 0; i < len2; i++) {
            arr[b.charAt(i)-'a'] -=1;
        }
        for (int i = 0; i < 26; i++) {
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static int[] matrixDiagonally(int[][] mat) {
        boolean diag = true;
        int row = 0;
        int col = 0;
        int rowlen = mat.length;
        int collen = mat[0].length;
        int[] ans = new int[rowlen*collen];
        int i = 0;
        int length = rowlen*collen;
        while(i<length){
            ans[i] = mat[row][col];
            i++;
            if(diag){
                row--;
                col++;
            }else{
                row++;
                col--;
            }
            if(row == rowlen && col == -1){
                row = rowlen-1;
                col = 1;
                diag = true;
                continue;
            }
            if(row == -1 && col == collen){
                row = 1;
                col = collen-1;
                diag = false;
                continue;
            }
            if(row<0 || row>=rowlen){
                if(row<0){
                    row = 0;
                    diag = false;
                }
                else{
                    row = rowlen-1;
                    col+=2;
                    diag = true;
                }
            }
            if(col<0 || col>= collen){
                if(col<0){
                    col = 0;
                    diag = true;
                }
                else{
                    row+=2;
                    col = collen-1;
                    diag = false;
                }
            }
        }
        return ans;
    }

    public static int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int r1 = 0;
        int r2 = n-1;
        int c1 = 0;
        int c2 = n-1;
        int ans = 0;
        while(r1!=n && r2!=-1){
            int num = mat1[r1][c1]+mat2[r2][c2];
            if(num>x){
                c2--;
            }else if(num<x){
                c1++;
            }else{
                ans++;
                c1++;
                c2--;
            }
            if(c1>n-1){
                r1++;
                c1 = 0;
            }
            if(c2<0){
                r2--;
                c2 = n-1;
            }
        }
        return ans;
    }
    public static ArrayList <Integer> levelOrder(Node root)
    {
        ArrayList<Integer> array = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            array.add(node.data);
        }
        return array;
    }
    public static String removeDuplicates(String str) {
        Queue<Character> queue = new ArrayDeque<>();
        HashSet<Character> set = new HashSet<>();
        int len = str.length();
        for (int i = 0; i <len ; i++) {
            char s = str.charAt(i);
            if(!set.contains(s)){
                queue.add(s);
            }
            set.add(s);
        }
        String string = "";
        while(!queue.isEmpty()){
            string += queue.remove();
        }
        return string;
    }
    public char nthCharacter(String s, int r, int n) {
        int num = n>r ? n/r : 1;
        StringBuilder str = new StringBuilder(s.substring(0,num));
        for (int i = 0; i < r; i++) {
            int point = 0;
            while(point<str.length()){
                if(str.charAt(point) == '0'){
                    str.insert(point+1,1);
                }
                else{
                    str.insert(point+1,0);
                }
                point +=2;
            }
        }
        return str.charAt(n);

    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> arr1 = subsetSums(arr,0,0,arr.size());
        Collections.sort(arr1);
        return arr1;
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr,int num,int sum,int N){
        if(num>=N){
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(sum);
            return ar;
        }
        ArrayList<Integer> arr1 = subsetSums(arr,num+1,sum,N);
        ArrayList<Integer> arr2 = subsetSums(arr,num+1,sum+arr.get(num),N);
        arr1.addAll(arr2);
        return arr1;
    }

}
