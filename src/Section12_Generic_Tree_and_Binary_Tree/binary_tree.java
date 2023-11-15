package Section12_Generic_Tree_and_Binary_Tree;

import Section10_OOPS_and_Stacks.Inheritance.P;

import javax.swing.*;
import java.util.*;

public class binary_tree {
    private class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    private Node root = null;
    private int size = 0;
    private int leafnodesum = 0;
    binary_tree(){
        Scanner s = new Scanner(System.in);
        this.root = takeinput(s,null,false);
    }

    private Node takeinput(Scanner s,Node parent,boolean isleft){
        if(parent == null){
            System.out.println("Enter the data for root node");
        }
        else{
            if(isleft){
                System.out.println("Enter the left data for "+parent.data);
            }
            else{
                System.out.println("Enter the right data for "+parent.data);
            }
        }
        int nodedata = s.nextInt();
        Node node = new Node(nodedata,null,null);
        this.size++;
        boolean choice = false;
        System.out.println("Do you have left child of "+node.data);
        choice = s.nextBoolean();
        if(choice){
            node.left = takeinput(s,node,true);
        }
        System.out.println("Do you have right child of "+node.data);
        choice = s.nextBoolean();
        if(choice){
            node.right = takeinput(s,node,false);
        }
        return node;
    }
    public void display(){
        this.display(this.root);
    }
    private void display(Node node){
        String str = "";
        if(node.left!=null){
            str = str+node.left.data+"=>";
        }
        else{
            str = str+"END=>";
        }
        str = str+node.data;
        if(node.right!=null){
            str = str+"<="+node.right.data;
        }
        else{
            str = str+"<=END";
        }
        System.out.println(str);
        if(node.left!=null){
            this.display(node.left);
        }
        if(node.right!=null){
            this.display(node.right);
        }
    }
    public int height(){
        return this.height(this.root);
    }
    private int height(Node node){
        if(node == null){
            return -1;
        }
        int num1 = height(node.left);
        int num2 = height(node.right);
        if(num1>num2){
            num1++;
            return num1;
        }
        num2++;
        return num2;
    }
    public void postorder(){
        this.postorder(this.root);
        System.out.println("END");
    }
    private void postorder(Node node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }
    public void preorder(){
        this.preorder(this.root);
        System.out.println("END");
    }
    private void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }
    public void inorder(){
        this.inorder(this.root);
        System.out.println("END");
    }
    private void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    public void levelorder(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while(!queue.isEmpty()){
            Node rv = queue.removeFirst();
            System.out.println(rv.data+" ");
            if(rv.left !=null){
                queue.addLast(rv.left);
            }
            if(rv.right !=null){
                queue.addLast(rv.right);
            }
        }
        System.out.println("END");
    }
    public boolean isBST(){
        return isBST(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBST(Node node,int min,int max){
        if(node == null){
            return true;
        }
        if(node.data>max || node.data<min){
            return false;
        }
        else if(!this.isBST(node.left,min,node.data)){
            return false;
        }
        else if(!this.isBST(node.right,node.data,max)){
            return false;
        }
        return true;
    }
    public List<Integer> inOrder_iteratively(){
        Node node = this.root;
        if(node == null){
            ArrayList<Integer> l1 = new ArrayList<>();
            return l1;
        }
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                list.add(node.data);
                node = node.right;
            }
        }
        return list;
    }
    public int diameter(){
        return this.diameter(this.root);
    }
    private int diameter(Node node){
        if(node==null){
            return 0;
        }
        int case1 = this.height(node.left)+this.height(node.right)+2;
        int case2 = this.diameter(node.left);
        int case3 = this.diameter(node.right);
        int myans = Math.max(case1,Math.max(case2,case3));
        return myans;
    }
    public int diameterBTR(){
        return this.diameterBTR(this.root).diameter;
    }
    private DiaPair diameterBTR(Node node){
        if(node==null){
            DiaPair bp = new DiaPair(-1,0);
            return bp;
        }
        DiaPair lp = this.diameterBTR(node.left);
        DiaPair rp = this.diameterBTR(node.right);
        DiaPair mp = new DiaPair();
        mp.height = Math.max(lp.height,rp.height)+1;
        mp.diameter = Math.max(lp.height+rp.height+2,Math.max(lp.diameter,rp.diameter));
        return mp;
    }
    public class DiaPair{
        int height;
        int diameter;
        DiaPair(){

        }
        DiaPair(int height,int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }
    public int leafsum(){
        //leafsum(this.root);
        //return leafnodesum;
        return leafsumnew(this.root);
    }
    private void leafsum(Node node){
        if(node == null){
            return;
        }
        if(node.left==null && node.right==null){
            this.leafnodesum+= node.data;
            return;
        }
        leafsum(node.left);
        leafsum(node.right);
    }
    private int leafsumnew(Node node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return node.data;
        }
        int num1 = leafsumnew(node.left);
        int num2 = leafsumnew(node.right);
        return num1+num2;
    }
    // 50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
    public boolean balanced(){
        return balanced(this.root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        if(lh-rh>1 || rh-lh>1){
            return false;
        }
        boolean left = balanced(node.left);
        boolean right = balanced(node.right);
        if(right && left){
            return true;
        }
        return false;
    }
    private class Pair{
        Node node;
        boolean sd;
        boolean ld;
        boolean rd;
    }
    public void preorderI(){
        Stack<Pair> stack = new Stack<>();
        Pair sp = new Pair();
        sp.node = this.root;
        stack.push(sp);
        while(!stack.isEmpty()){
            if(stack.peek().node == null){
                stack.pop();
            }
            Pair tp = stack.peek();
            if(!tp.sd){
                System.out.print(tp.node.data+" ");
                tp.sd = true;
            }
            else if(!tp.ld){
                Pair np = new Pair();
                np.node = tp.node.left;
                stack.push(np);
                tp.ld = true;
            }
            else if(!tp.rd){
                Pair np = new Pair();
                np.node = tp.node.right;
                stack.push(np);
                tp.rd = true;
            }
            else{
                stack.pop();
            }
        }
        System.out.println("END");
    }
    binary_tree(int[] pre_post,int[] in,int num){
        if(num == 0) {
            this.root = construct(pre_post, 0, pre_post.length - 1, in, 0, in.length - 1);
        }
        else{
            this.root = construct2(reverse(pre_post),0,pre_post.length-1,reverse(in),0,in.length-1);
        }
    }
    public Node construct(int[] pre,int plo,int phi,int[] in,int ilo,int ihi){
        if(ilo>ihi || plo>phi){
            return null;
        }
        Node nn = new Node(pre[plo],null,null);
        int si = -1;
        int nel = 0;
        for (int i = ilo; i <=ihi ; i++) {
            if(pre[plo] == in[i]){
                si = i;
                break;
            }
            nel++;
        }
        nn.left = construct(pre,plo+1,plo+nel,in,ilo,si-1);
        nn.right = construct(pre,plo+nel+1,phi,in,si+1,ihi);
        return nn;
    }
    public Node construct2(int[] pre,int plo,int phi,int[] in,int ilo,int ihi){
        if(ilo>ihi || plo>phi){
            return null;
        }
        Node nn = new Node(pre[plo],null,null);
        int si = -1;
        int nel = 0;
        for (int i = ilo; i <=ihi ; i++) {
            if(pre[plo] == in[i]){
                si = i;
                break;
            }
            nel++;
        }
        nn.right = construct2(pre,plo+1,plo+nel,in,ilo,si-1);
        nn.left = construct2(pre,plo+nel+1,phi,in,si+1,ihi);
        return nn;
    }
    static int[] reverse(int[] a)
    {
        int[] b = new int[a.length];
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }
    public boolean flipEquivalent(binary_tree other){
        return flipEquivalent(this.root,other.root);
    }
    private boolean flipEquivalent(Node node1,Node node2){
        if(node1 == null && node2 == null ){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        if(node1.data != node2.data){
            return false;
        }
        boolean ll = flipEquivalent(node1.left,node2.left);
        boolean rr = flipEquivalent(node1.right,node2.right);
        boolean lr = flipEquivalent(node1.left,node2.right);
        boolean rl = flipEquivalent(node1.right,node2.left);

        return (ll && rr) || (lr && rl);
    }
    public int sum(){
        return sum(root);
    }
    private int sum(Node node){
        if(node == null){
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        return ls+rs+node.data;
    }
    int maxSum = Integer.MIN_VALUE;
    public int maxSubTreeSum1(){
        maxSubTreeSum1(root);
        return maxSum;
    }
    private int maxSubTreeSum1(Node node){
        if(node == null){
            return 0;
        }
        int ls = maxSubTreeSum1(node.left);
        int rs = maxSubTreeSum1(node.right);
        if(ls+rs+node.data >maxSum){
            maxSum = ls+rs+node.data;
        }
        return ls+rs+node.data;
    }
    public int maxTreeSum2(){
        return maxTreeSum2(root);
    }
    private int maxTreeSum2(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int lMaxTreeSum = maxTreeSum2(node.left);
        int rMaxTreeSum = maxTreeSum2(node.right);
        int SelfSum = node.data+sum(node.left) + sum(node.right);
        return(Math.max(lMaxTreeSum,Math.max(rMaxTreeSum,SelfSum)));
    }
    private class maxSubTreeSumPair{
        int entireSum = 0;
        int maxSubTreeSumPair = Integer.MIN_VALUE;
    }
    public int maxSubTreeSum3(){
        return maxSubTreeSum3(root).maxSubTreeSumPair;
    }
    private maxSubTreeSumPair maxSubTreeSum3(Node node){
        if(node == null){
            return new maxSubTreeSumPair();
        }
        maxSubTreeSumPair lSum = maxSubTreeSum3(node.left);
        maxSubTreeSumPair rSum = maxSubTreeSum3(node.right);
        maxSubTreeSumPair sum = new maxSubTreeSumPair();
        sum.entireSum = lSum.entireSum + rSum.entireSum + root.data;
        sum.maxSubTreeSumPair = Math.max(lSum.maxSubTreeSumPair,Math.max(rSum.maxSubTreeSumPair,sum.entireSum));
        return sum;
    }

}
