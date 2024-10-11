package practice;

public class quicksort {
    public static void quick(int[] arr,int[] num,int start,int end){
        if(start<end){
            int partition = part(arr,num,start,end);
            quick(arr,num,start,partition-1);
            quick(arr,num,partition+1,end);
        }
    }
    public static int part(int[] arr,int[] num,int start,int end){
        int j = start-1;
        int val = num[end];
        for (int i = start; i < end ; i++) {
            if(num[i]<val){
                j++;
                swap(arr,num,j,i);
            }
        }
        swap(arr,num,j+1,end);
        return j+1;
    }
    public static void swap(int[] arr,int[] num,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

        int temp2=num[i];
        num[i]=num[j];
        num[j]=temp2;
    }

    public static void quicksingle(int[] arr,int start,int end){
        if(start<end){
            int partition = parti(arr,start,end);
            quicksingle(arr,start,partition-1);
            quicksingle(arr,partition+1,end);
        }
    }
    public static int parti(int[] arr,int start,int end){
        int j = start-1;
        int val = arr[end];
        for (int i = start; i < end ; i++) {
            if(arr[i]<val){
                j++;
                swapsingle(arr,j,i);
            }
        }
        swapsingle(arr,j+1,end);
        return j+1;
    }
    public static void swapsingle(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void quickcenter(String[] str, int[] arr, int low, int high) {
        if (low < high) {
            int part = parti(str, arr, low, high);
            quickcenter(str, arr, low, part - 1);
            quickcenter(str, arr, part + 1, high);
        }
    }

    public static int parti(String[] str, int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {  // Change comparison to >= for descending order
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                String temp2 = str[i];
                str[i] = str[j];
                str[j] = temp2;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        String temp2 = str[i + 1];
        str[i + 1] = str[high];
        str[high] = temp2;
        return i + 1;
    }
    public static void quick(int[] arr,long[] num,int start,int end){
        if(start<end){
            int partition = part(arr,num,start,end);
            quick(arr,num,start,partition-1);
            quick(arr,num,partition+1,end);
        }
    }
    public static int part(int[] arr,long[] num,int start,int end){
        int j = start-1;
        long val = num[end];
        for (int i = start; i < end ; i++) {
            if(num[i]<=val){
                j++;
                swap(arr,num,j,i);
            }
        }
        swap(arr,num,j+1,end);
        return j+1;
    }
    public static void swap(int[] arr,long[] num,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

        long temp2=num[i];
        num[i]=num[j];
        num[j]=temp2;
    }

}
