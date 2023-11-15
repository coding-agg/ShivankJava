package Challenges_Trees;

import java.util.Scanner;

public class preopder_inorder {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        preopder_inorder m = new preopder_inorder();
        int[] pre = takeInput();
        int[] in = takeInput();
        BinaryTree bt = m.new BinaryTree(pre, in);
        bt.display();
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
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree(int[] pre, int[] in) {
            this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }

        private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
            if(plo > phi){
                return null;
            }
            int index = 0;
            for (int i = ilo; i <=ihi ; i++) {
                if(pre[plo] == in[i]){
                    index = i;
                    break;
                }
            }
            Node leftr = construct(pre,plo+1,plo+index-ilo,in,ilo,index-1);
            Node rightr = construct(pre,plo+1+index-ilo,phi,in,index+1,ihi);
            Node root_main = new Node();
            root_main.left = leftr;
            root_main.right = rightr;
            root_main.data = pre[plo];
            return root_main;
        }

        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
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
