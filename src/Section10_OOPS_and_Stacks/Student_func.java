package Section10_OOPS_and_Stacks;

public class Student_func {
    public int hello = 1;
    public static void main(String[] args) throws Exception {
        Student_[] students = new Student_[1000];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student_(i+"th");
            System.out.println(Student_.NumOfStudents);
        }
        System.out.println(students[250].getnum());
        System.out.println(students[250].getstr());
    }
    public void hello(){
        System.out.println(hello);
    }
}
