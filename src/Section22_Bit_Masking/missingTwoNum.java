package Section22_Bit_Masking;

public class missingTwoNum {
    public static void main(String[] args) {
        int n = 8;
        int[] arr = {1,3,4,6,8,2};

        int z = 0;
        for (int i = 0; i < arr.length; i++) {
            z = z^arr[i];
        }
        for (int i = 1; i <= n; i++) {
            z = z^i;
        }
        //System.out.println(z);
        int set_bit = z&~(z-1);
        //System.out.println(set_bit);
        int group1 = 0;
        int group2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if((set_bit & arr[i]) == set_bit){
                group1 = group1^arr[i];
            }
            else{
                group2 = group2^arr[i];
            }
        }
        for (int i = 1; i <=n; i++) {
            if((set_bit & i) == set_bit){
                group1 = group1^i;
            }
            else{
                group2 = group2^i;
            }
        }
        System.out.println("The first number is "+group1);
        System.out.println("The first number is "+group2);
    }
}
