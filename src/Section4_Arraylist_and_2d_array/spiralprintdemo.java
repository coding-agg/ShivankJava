package Section4_Arraylist_and_2d_array;

public class spiralprintdemo {
    public static void main(String[] args) {
        int[][] arr = {{11,12,13,14,15},{21,22,23,24,25},{31,32,33,34,35},{41,42,43,44,45},{51,52,53,54,55}} ;
        Spiralprintclockwise(arr);
    }
    public static void Spiralprintclockwise(int[][] arr){
        int top,bottom,left,right,count,dir ;
        top = 0 ;
        bottom = arr.length-1 ;
        left = 0 ;
        right = arr[top].length-1 ;
        dir = 1 ;
        count = (bottom+1)*(right+1) ;
        while(left<=right && top<=bottom){
            if(count>0){
                if(dir==1){
                    for (int i = left; i <=right; i++) {
                        System.out.print(arr[top][i]+", ");
                        count-- ;
                    }
                    dir = 2 ;
                    top++ ;
                }
            }
            if(count>0){
                if(dir == 2){
                    for (int i = top; i <=bottom ; i++) {
                        System.out.print(arr[i][right]+", ");
                        count--;
                    }
                    dir = 3 ;
                    right-- ;
                }
            }
            if(count>0){
                if(dir==3){
                    for (int i = right; i >=left ; i--) {
                        System.out.print(arr[bottom][i]+", ");
                        count-- ;
                    }
                    dir=4 ;
                    bottom-- ;
                }
            }
            if(count>0){
                if(dir==4){
                    for (int i = bottom; i >=top ; i--) {
                        System.out.print(arr[i][left]+", ");
                        count--;
                    }
                    dir = 1 ;
                    left++ ;
                }
            }

        }
    }
}
