package Section10_OOPS_and_Stacks;

public class Student_ {
    public static final int Max_Students = 1000;
    public static int NumOfStudents = 0 ;
    private String str;
    private int num;
    public String getstr(){
        return this.str;
    }
    public int getnum(){
        return this.num;
    }

    public void setStr(String str) throws Exception {
        if(str.equals("") || str == null){
            throw new Exception("Names can't be empty");
        }
        this.str = str;
    }

    public Student_(String str)throws Exception{
        if(Student_.NumOfStudents == Student_.Max_Students){
            throw new Exception("Max Limit Reached");
        }
        this.setStr(str);
        Student_.NumOfStudents++;
        this.num = Student_.NumOfStudents;
    }

}
