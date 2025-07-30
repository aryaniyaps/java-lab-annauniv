package university;

public class UGEngineeringStudent extends Student implements GradeCalculation {
    final int marks, technicalEventGrading;

    public UGEngineeringStudent(int marks, int technicalEventGrading) {
        this.marks = marks;
        this.technicalEventGrading = technicalEventGrading;

    }

    @Override
    public void calculateGrade() {
        int score = (marks + technicalEventGrading) / 10;
        System.out.println("Grade: " + score);
    }
}
