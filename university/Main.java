package university;

public class Main {
    public static void main(String[] args) {
        UGEngineeringStudent ug = new UGEngineeringStudent(
            90, 5
        );

        PGEngineeringStudent pg = new PGEngineeringStudent(
            85, 8);

        PGScienceStudent pgScience = new PGScienceStudent(
            89, 4
        );
        

        PGArtStudent pgArt = new PGArtStudent(70, 4);

        ResearchScholar researchScholar = new ResearchScholar(10, 12);


        Student students[] = {
            ug, pg, pgScience, pgArt, researchScholar
        };

        for (Student elem : students) {
            elem.calculateGrade();
        }
    }
}
