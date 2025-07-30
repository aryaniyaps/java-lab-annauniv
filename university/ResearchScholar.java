package university;

public class ResearchScholar extends Student implements GradeCalculation {
    int numResearchArticlesPublished, numResearchProjectsDone;

    public ResearchScholar(int numResearchArticlesPublished, int numResearchProjectsDone) {
        this.numResearchArticlesPublished = numResearchArticlesPublished;
        this.numResearchProjectsDone = numResearchProjectsDone;
    }
    
    @Override
    public void calculateGrade() {
        int score = (numResearchArticlesPublished + numResearchProjectsDone * 2) / 10;
        System.out.println("Grade: " + score);
    }
}
