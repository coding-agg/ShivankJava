package Section20_Segment_Tree;

public class SegmentTree {
    private class Node{
        int data;
        int startinterval;
        int endinterval;
        Node left;
        Node right;
    }
    Node root;
    public SegmentTree(int[] arr){
        this.root = constructTree(arr,0,arr.length-1);
    }
    private Node constructTree(int[] arr,int si,int ei){
        if(si == ei){
            Node leafnode = new Node();
            leafnode.data = arr[si];
            leafnode.startinterval = si;
            leafnode.endinterval = ei;
            return leafnode;
        }
        Node node = new Node();
        node.startinterval = si;
        node.endinterval = ei;
        int mid = (si+ei)/2;
        node.left = this.constructTree(arr,si,mid);
        node.right = this.constructTree(arr,mid+1,ei);
        node.data = node.left.data + node.right.data;
        return node;
    }
    public void display(){
        display(root);
    }
    private void display(Node node){
        String str = "";
        if(node.left != null){
            str = str+"Interval=["+node.left.startinterval+"-"+node.left.endinterval+"] and data ="+node.left.data+"=>";
        }
        else{
            str = str+"No left Child =>";
        }
        str = str+"Interval=["+node.startinterval+"-"+node.endinterval+"] and data ="+node.data+"=>";
        if(node.right!=null){
            str = str+"<=data is ="+node.right.data+" and interval is ["+node.right.startinterval+"-"+node.right.endinterval+"]";
        }
        else{
            str = str+"<=No right Child";
        }
        System.out.println(str);
        if(node.left!=null){
            this.display(node.left);
        }
        if(node.right!=null){
            this.display(node.right);
        }
    }
    public int query(int qsi,int qei){
        return query(this.root,qsi,qei);
    }
    private int query(Node node,int qsi,int qei){
        if(node.startinterval>=qsi && node.endinterval<=qei){
            return node.data;
        }
        else if(node.startinterval>qei || node.endinterval<qsi){
            return 0;
        }
        else{
            int leftans = this.query(node.left,qsi,qei);
            int rightans = this.query(node.right,qsi,qei);
            return (leftans + rightans);
        }
    }
    public void update(int index,int newValue){
        this.root.data = this.update(this.root,index,newValue);
    }
    private int update(Node node,int index,int newValue){
        if(index>=node.startinterval && index<=node.endinterval){
            if(index == node.startinterval && index == node.endinterval){
                node.data = newValue;
            }
            else{
                int leftval = this.update(node.left,index,newValue);
                int rightval = this.update(node.right,index,newValue);
                node.data = leftval + rightval;
            }
        }
        return node.data;
    }

}
