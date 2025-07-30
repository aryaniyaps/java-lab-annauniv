package university;

public class PGArtStudent extends Student implements GradeCalculation {
    int marks, assignmentGrading;

    public PGArtStudent(int marks, int assignmentGrading) {
        this.marks = marks;
        this.assignmentGrading = assignmentGrading;
    }
    
    @Override
    public void calculateGrade() {
        int score = (marks + assignmentGrading * 3) / 10;
        System.out.println("Grade: " + score);
    }
}
