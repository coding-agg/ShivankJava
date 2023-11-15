package Section13_Binary_Search_Tree;

public class client_BST {
    public static void main(String[] args) {
        int[] in = {5,3,2,4,7,6,8};
        BST bst = new BST(in);
        bst.remove(2);
        bst.remove(3);
        bst.remove(5);
        bst.display();
    }
}
