package dbr.entities.subjects;

public class Subjects extends SubjectEntity {
    public int totalCountTest;
    public Subjects(int id, String name, String img, int totalCountTest) {
        super(id, name, img);
        this.totalCountTest = totalCountTest;
    }
}
