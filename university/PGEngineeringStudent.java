package university;

public class PGEngineeringStudent extends Student implements GradeCalculation {
    final int marks, researchProjectGrading;

    public PGEngineeringStudent(int marks, int researchProjectGrading) {
        this.marks = marks;
        this.researchProjectGrading = researchProjectGrading;
    }
    
    @Override
    public void calculateGrade() {
        int score = (marks + researchProjectGrading * 5) / 10;
        System.out.println("Grade: " + score);
    }
}
