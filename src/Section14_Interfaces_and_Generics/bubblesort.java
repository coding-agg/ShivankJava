package Section14_Interfaces_and_Generics;

import java.util.Comparator;

public class bubblesort {
    public static void main(String[] args) {
        car[] arr = new car[5];
        arr[0] = new car(200,500,"Yellow");
        arr[1] = new car(300,600,"Green");
        arr[2] = new car(100,300,"Red");
        arr[3] = new car(600,200,"Blue");
        arr[4] = new car(150,230,"Purple");
        bubble(arr,new carpriceComparator());
        for(car value:arr){
            System.out.print(value+" ");
        }
        System.out.println();
        bubble(arr,new carspeedComparator());
        for(car value:arr){
            System.out.print(value+" ");
        }
        System.out.println();
        bubble(arr,new carcolorComparator());
        for(car value:arr){
            System.out.print(value+" ");
        }
    }
    public static <T extends Comparable<T>> void bubble(T[] array){
        for (int i = 3; i >=0 ; i--) {
            for (int j = 0; j <= i; j++) {
                if(array[j].compareTo(array[j+1])>0){
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static <T> void bubble(T[] array, Comparator<T> comparator){
        for (int i = 3; i >=0 ; i--) {
            for (int j = 0; j <= i; j++) {
                if(comparator.compare(array[j],array[j+1])>0){
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
