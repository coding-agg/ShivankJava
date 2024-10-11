public class MultiSort<T> {
    int[] num;
    T[] arr;
    public void quickcenter(T[] str, int[] arr, int low, int high) {
        if (low < high) {
            int part = parti(str, arr, low, high);
            quickcenter(str, arr, low, part - 1);
            quickcenter(str, arr, part + 1, high);
        }
    }
    public int parti(T[] str, int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {  // Change comparison to >= for descending order
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                T temp2 = str[i];
                str[i] = str[j];
                str[j] = temp2;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        T temp2 = str[i + 1];
        str[i + 1] = str[high];
        str[high] = temp2;
        return i + 1;
    }
}
