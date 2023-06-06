package dbr.entities.tests;

public class TestEntity {

    public int id;

    public String name;
    public String author;
    public String create_time;
    public String img;
    public int school_subject_id;

    public TestEntity(int id, String name, String author, String create_time, int school_subject_id, String img) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.create_time = create_time;
        this.school_subject_id = school_subject_id;
        this.img = img;
    }

}
