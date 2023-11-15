package Section14_Interfaces_and_Generics;

public class car implements Comparable<car> {
    int speed;
    int price;
    String color;
    public car(int speed,int price,String color){
        this.speed = speed;
        this.price = price;
        this.color = color;
    }
    public String toString(){
        return "S:"+ this.speed + " P:" + this.price + " C:"+ this.color;
    }
    public int compareTo(car other){
        return this.speed - other.speed;
    }
}
