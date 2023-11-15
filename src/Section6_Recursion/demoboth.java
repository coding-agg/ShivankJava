package Section6_Recursion;

public class demoboth {
    public static void main(String[] args) {
        P(5) ;
    }
    public static void P(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        P(n-1) ;
        System.out.println(n);
    }
}
