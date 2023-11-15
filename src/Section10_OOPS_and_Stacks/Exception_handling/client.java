package Section10_OOPS_and_Stacks.Exception_handling;

public class client {
    public static void main(String[] args){
        Student s1 = new Student();
        try {
            s1.setage(10);
            System.out.println("Hello Stat");
        }
        catch(Exception E){
            System.out.println("In catch block");

        }
        System.out.println("Hello");
        System.out.println(s1.getage());
    }
}
