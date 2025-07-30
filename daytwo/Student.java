package daytwo;

public class Student {
    String name;
    int rollNo;
    double marks;

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "John";
        s1.rollNo = 101;
        s1.marks = 89.5;

        Student s2 = new Student();
        s2.name = "Alice";
        s2.rollNo = 102;
        s2.marks = 92.0;

        s1.displayDetails();
        System.out.println();
        s2.displayDetails();
    }
}
