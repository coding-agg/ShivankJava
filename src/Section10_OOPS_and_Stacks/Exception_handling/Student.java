package Section10_OOPS_and_Stacks.Exception_handling;

public class Student {
    private String name;
    private int age;
    public void setage(int age) throws Exception {
        if(age<0){
            throw new Exception("Can't be less than 0");
        }
        this.age = age;
    }
    public int getage(){
        return this.age;
    }
}
