package BaiTap;
import java.util.Scanner;
public class Student {
    private String firstName;
    private int age;
    private String lastName;
    private String studentId;
    private String birthDay;
    private String className;
    private String major;

    public Student(String firstName, int age, String lastName, String studentId, String birthDay, String className, String major) {
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
        this.studentId = studentId;
        this.birthDay = birthDay;
        this.className = className;
        this.major = major;
    }
    public Student() {
        this.firstName = "";
        this.age = 0;
        this.lastName = "";
        this.studentId = "";
        this.birthDay = "";
        this.className = "";
        this.major = "";
    }
    public String getFirstName() {
        return firstName;
    }
    public int getAge() {
        return age;
    }
    public String getLastName() {
        return lastName;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getBirthDay() {
        return birthDay;
    }
    public String getClassName() {
        return className;
    }
    public String getMajor() {
        return major;
    }
    public void inputStudent(Scanner sc) {
        System.out.print("Enter Student First Name: ");
        this.firstName = sc.nextLine();
        System.out.print("Enter Student Last Name: ");
        this.lastName = sc.nextLine();
        System.out.print("Enter Student Age: ");
        this.age = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Student ID: ");
        this.studentId = sc.nextLine();
        System.out.print("Enter Student's birth day: ");
        this.birthDay = sc.nextLine();
        System.out.print("Enter Student's class name: ");
        this.className = sc.nextLine();
        System.out.print("Enter Student's major: ");
        this.major = sc.nextLine();
    }
    @Override
    public String toString() {
        return studentId + " - " + firstName + " - " + lastName + " - " + age + " - " + birthDay + " - " + className + " - " + major;
    }
}
