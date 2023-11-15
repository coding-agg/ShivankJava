package Section12_Generic_Tree_and_Binary_Tree;

public class client_binary {
    public static void main(String[] args) {
        binary_tree tree1 = new binary_tree();
        int[] in = {38,25, 18 ,48, 50, 85, 45, 60};
        int[] pre = {50,25,38,48,18,45,85,60};
        int[] post = {38 ,18, 48, 25, 85, 60, 45, 50};
        binary_tree tree2 = new binary_tree(pre,in,0);
        tree1.display();
        binary_tree tree3 = new binary_tree(post,in,1);
        System.out.println("*******************************");
        tree2.display();
        System.out.println("********************************");
        tree3.display();
    }
}
