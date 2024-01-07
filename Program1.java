
import java.util.*;

class Student {

    String name;
    String usn;
    String dept;
    char section;
    double cgpa;

    public Student(String name, String usn, String dept, char section, double cgpa) {
        this.name = name;
        this.usn = usn;
        this.dept = dept;
        this.section = section;
        this.cgpa = cgpa;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String toString() {
        return "name : " + name + "\n" + "usn : " + usn + "\n" + "dept : " + dept + "\n" + "section : " + section + "\n" + "cgpa : " + cgpa + "\n";
    }
}

public class Program1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("jaswanth", "1ms21is078", "ise", 'b', 8.95);
        Student student2 = new Student("ramu", "1ms21is001", "aiml", 'a', 8.6);
        Student student3 = new Student("raju", "1ms21is002", "me", 'c', 9.95);
        Student student4 = new Student("kiran", "1ms21is006", "cv", 'd', 8.35);
        Student student5 = new Student("vamsi", "1ms21is115", "ise", 'c', 8.14);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            Student currentStudent = itr.next();
            if (currentStudent.cgpa == 8.5) {
                System.out.println(currentStudent);
            }
            if (currentStudent.dept.equals("ise")) {
                System.out.println(currentStudent);
            }
            if (currentStudent.section == 'c') {
                System.out.println(currentStudent);
            }

        }

    }

}
