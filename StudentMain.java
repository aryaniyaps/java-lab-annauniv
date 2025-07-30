class Person {
    public String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getDetails() {
        return name + "(" + age + " years)";
    }
}


class Student extends Person {
    private final String course;

    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " - Enrolled in: " + course;
    }
}

public class StudentMain {
    public static void main(String[] args) {
     Student student = new Student("Alice", 22, "Computer Science");
     System.out.println(student.getDetails());   
    }
}
