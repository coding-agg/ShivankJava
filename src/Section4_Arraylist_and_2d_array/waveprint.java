package Section4_Arraylist_and_2d_array;

public class waveprint {
    public static void main(String[] args) {
        int[][] arr = {{11,12,13,14},{21,22,23,24},{31,32,33,34},{41,42,43,44}} ;
        waveprint(arr) ;
    }
    public static void waveprint(int[][] arr){
        for (int top = 0; top < arr.length; top++) {
            if(top%2 == 0){
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[top][i]+" ");
                }
            }else{
                for (int i = arr.length-1; i>=0 ; i--) {
                    System.out.print(arr[top][i]+" ");
                }
            }
        }
        System.out.print("END");
    }

}
