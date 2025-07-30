package university;

public class PGScienceStudent extends Student implements GradeCalculation {
  
    int marks, paperPresentationGrading;

    public PGScienceStudent(int marks, int paperPresentationGrading) {
        this.marks = marks;
        this.paperPresentationGrading = paperPresentationGrading;
    }

    @Override
    public void calculateGrade() {
        int score = (marks + paperPresentationGrading * 2) / 10;
        System.out.println("Grade: " + score);
    }
}
