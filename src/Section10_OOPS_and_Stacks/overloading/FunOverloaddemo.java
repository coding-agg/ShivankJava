package Section10_OOPS_and_Stacks.overloading;

public class FunOverloaddemo {
    public static void main(String[] args) {
        System.out.println(sum(2,3));
        System.out.println(sum(2,3,4));
        System.out.println(sum(2.1,3.2));
        System.out.println(sum());
    }
    public static int sum(int a,int b){
        return a+b;
    }
    public static int sum(int a,int b,int c){
        return a+b+c;
    }
    public static double sum(double a,double b){
        return a+b;
    }
    public static int sum(int... args){ //(args is basically array of integers)
        int sum = 0;
        for (int val : args){
            sum+=val;
        }
        return sum;
    }
}
