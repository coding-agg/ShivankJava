package Section14_Interfaces_and_Generics;

public class Generic_display {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4};
        display(arr);
    }
    public static <ab> void display(ab[] array){
        for (ab value:array){
            System.out.print(value+" ");
        }
    }
}
