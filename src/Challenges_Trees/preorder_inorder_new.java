package Challenges_Trees;

import java.util.Scanner;

public class preorder_inorder_new {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int test = scn.nextInt();
        for (int i = 0; i < test; i++) {
            preorder_inorder_new m = new preorder_inorder_new();
            int[] pre = takeInput();
            int[] in = takeInput();
            preorder_inorder_new.BinaryTree bt = m.new BinaryTree(pre, in);
            bt.display();
        }
    }

    public static int[] takeInput() {
        int n = scn.nextInt();

        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }

        return rv;
    }

    private class BinaryTree {
        private class Node {
            int data;
            preorder_inorder_new.BinaryTree.Node left;
            preorder_inorder_new.BinaryTree.Node right;
        }

        private preorder_inorder_new.BinaryTree.Node root;
        private int size;

        public BinaryTree(int[] pre, int[] in) {
            this.root = this.construct(pre, in, 0, in.length - 1);
        }
        public int plo = 0;

        private preorder_inorder_new.BinaryTree.Node construct(int[] pre, int[] in, int ilo, int ihi) {
            if(plo > pre.length-1){
                return null;
            }
            if(ilo>ihi){
                return null;
            }
            int index = 0;
            for (int i = ilo; i <=ihi ; i++) {
                if(pre[plo] == in[i]){
                    index = i;
                    break;
                }
            }
            preorder_inorder_new.BinaryTree.Node root_main = new preorder_inorder_new.BinaryTree.Node();
            root_main.data = pre[plo];
            plo = plo+1;
            root_main.left = construct(pre,in,ilo,index-1);
            root_main.right = construct(pre,in,index+1,ihi);
            return root_main;
        }

        public void display() {
            this.display(this.root);
        }

        private void display(preorder_inorder_new.BinaryTree.Node node) {
            if (node == null) {
                return;
            }

            String str = "";

            if (node.left != null) {
                str += node.left.data;
            } else {
                str += "END";
            }

            str += " => " + node.data + " <= ";

            if (node.right != null) {
                str += node.right.data;
            } else {
                str += "END";
            }

            System.out.println(str);

            this.display(node.left);
            this.display(node.right);
        }

    }
}
