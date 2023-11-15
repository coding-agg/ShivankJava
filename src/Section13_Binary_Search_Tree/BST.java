package Section13_Binary_Search_Tree;

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
        nn.left = construct(arr , lo,mid-1);
        nn.right = construct(arr,mid+1,hi);
        return nn;
    }
    public void display(){
        this.display(this.root);
    }
    private void display(Node node){
        if(node == null){
            return;
        }
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
        this.display(node.left);
        this.display(node.right);
    }
    public boolean find(int item){
        return find(this.root,item);
    }
    private boolean find(Node node,int item){
        if(node == null){
            return false;
        }
        if(item>node.data){
            return find(node.right,item);
        }
        else if(item<node.data){
            return find(node.left,item);
        }
        else{
            return true;
        }
    }
    public void add(int item){
        add(this.root,item,null);
    }
    private void add(Node node,int item,Node prev){
        if(node==null){
            Node nn = new Node();
            nn.data = item;
            if(item>prev.data){
                prev.right = nn;
            }
            else if(item<prev.data){
                prev.left = nn;
            }
            return;
        }
        if(item>node.data){
            add(node.right,item,node);
        }
        else if(item<node.data){
            add(node.left,item,node);
        }
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
    public void remove(int item){
        remove(this.root,null,false,item);
    }
    private void remove(Node node,Node parent,boolean ilc,int item){
        if(item>node.data){
            remove(node.right,node,false,item);
        }
        else if(item<node.data){
            remove(node.left,node,true,item);
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
            else if(node.left == null && node.right !=null){
                if(ilc){
                    parent.left = node.right;
                }
                else{
                    parent.right = node.right;
                }
            }
            else if(node.left!=null && node.right == null){
                if(ilc){
                    parent.left = node.right;
                }
                else{
                    parent.right = node.right;
                }
            }
            else{
                int max = max(node.left);
                node.data = max;
                remove(node.left,node,true,max);
            }
        }
    }

}
