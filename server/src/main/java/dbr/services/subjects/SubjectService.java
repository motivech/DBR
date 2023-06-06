package dbr.services.subjects;

import dbr.entities.subjects.SubjectEntity;
import dbr.entities.subjects.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Subjects> getAll() {
        String sql = "select id, name, img, CAST((select  COUNT(*) from tests where tests.school_subject_id = school_subjects.id) as int) as totalCountTest from school_subjects";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Subjects(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("img"),
                rs.getInt("totalCountTest")
        ));
    }
}
