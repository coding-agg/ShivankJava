package Challenges_Trees;

import java.util.Scanner;

public class BST {
    private class Node{
        int data;
        Node left;
        Node right;

    }
    private Node root;
    BST(int[] arr){
        this.root = construct(arr,0,arr.length-1);
    }

    private Node construct(int[] arr,int lo,int hi){
        if(lo>hi){
            return null;
        }
        int mid = (lo+hi)/2;
        Node nn = new Node();
        nn.data = arr[mid];
        nn.left = construct(arr,lo,mid-1);
        nn.right = construct(arr,mid+1,hi);
        return nn;
    }
    public void display(){
        display(this.root);
        System.out.println();
    }
    private void display(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        display(node.left);
        display(node.right);
    }
    public int max(){
        return max(this.root);
    }
    private int max(Node node){
        if(node.right == null){
            return node.data;
        }
        int ans = max(node.right);
        return ans;
    }
    public int min(){
        return min(this.root);
    }
    private int min(Node node){
        if(node.left == null){
            return node.data;
        }
        int ans = min(node.left);
        return ans;
    }
    public void delete(int item){
        delete(this.root,null,false,item);
    }
    private void delete(Node node,Node parent,boolean ilc,int item){
        if(item<node.data){
            delete(node.left,node,true,item);
        }
        else if(item>node.data){
            delete(node.right,node,false,item);
        }
        else{
            if(node.left == null && node.right == null){
                if(ilc){
                    parent.left = null;
                }
                else{
                    parent.right = null;
                }
            }
            else if(node.left == null && node.right!=null){
                if(ilc){
                    parent.left = node.right;
                }
                else{
                    parent.right = node.right;
                }
            }
            else if(node.left!=null && node.right == null){
                if(ilc){
                    parent.left = node.left;
                }
                else{
                    parent.right = node.left;
                }
            }
            else{
                int min = min(node.right);
                node.data = min;
                delete(node.right,node,false,min);
            }
        }
    }

    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int test = scn.nextInt();
        for (int i = 0; i < test; i++) {
            int[] arr = array();
            quicksort(arr,0,arr.length-1);
            BST BST = new BST(arr);
            int[] arr2 = array();
            for (int j = 0; j < arr2.length; j++) {
                BST.delete(arr2[j]);
            }
            BST.display();
        }
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
    public static void quicksort(int[] arr,int lo,int hi){
        if(lo>=hi){
            return;
        }
        int mid = (lo+hi)/2;
        int center = arr[mid] ;
        int left = lo;
        int right = hi;
        while(left<=right){
            while(arr[left]<center){
                left++;
            }
            while(arr[right]>center){
                right--;
            }
            if(left<=right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        quicksort(arr,lo,right);
        quicksort(arr,left,hi);
    }
}


