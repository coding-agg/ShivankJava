package Section6_Recursion;

public class towerofhanoi {
    public static int count = 0 ;
    public static void main(String[] args) {
        int n = 3;
        int num = 1 ;
        toh(n,"src","dest","helper") ;
    }
    public static void toh(int n , String src,String dest,String helper){
        if(n==0){
            return ;
        }
        toh(n-1,src,helper,dest) ;
        count++;
        System.out.println(count+"."+"move "+n+"th disc from "+src+" to "+dest);
        toh(n-1,helper,dest,src) ;
    }
}
