package Section12_Generic_Tree_and_Binary_Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class generic_tree {
    private class Node{
        int data;
        ArrayList<Node> children;
        Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    private Node root;
    private int size;
    generic_tree(){
        Scanner s = new Scanner(System.in);
        this.root = takeinput(s,null,0);
    }
    // to take the input of generic tree
    public Node takeinput(Scanner s,Node parent,int ith_child){
        if(parent == null){
            System.out.println("Enter data");
        }
        else{
            System.out.println("Enter the data for "+ith_child+" th child of "+parent.data);
        }
        int nodedata = s.nextInt();
        Node node = new Node(nodedata);
        this.size++;
        System.out.println("Enter the number of children for "+node.data);
        int children = s.nextInt();
        for (int i = 0; i < children; i++) {
            Node child = this.takeinput(s,node,i);
            node.children.add(child);
        }
        return node;
    }
    public void display(){
        this.display(this.root);
    }
    private void display(Node node){
        String str = node.data+"=>";
        for (int i = 0; i <node.children.size() ; i++) {
            str = str+node.children.get(i).data+", ";
        }
        str = str+"END";
        System.out.println(str);
        for (int i = 0; i < node.children.size(); i++) {
            this.display(node.children.get(i));
        }
    }

}
