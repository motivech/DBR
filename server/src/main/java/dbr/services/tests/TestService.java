package dbr.services.tests;


import dbr.entities.tests.TestEntity;
import dbr.entities.tests.Tests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Tests> getTest(int id) {
        String sql = "SELECT id, name, CAST((select COUNT(*) from questions where test_id = tests.id) as int) as total FROM tests where tests.school_subject_id = ?";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Tests(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("total")
                ), id
        );
    }

//    public List<TestEntity> getTestById(int id) {
//        String sql = "SELECT * FROM tests where id = " + id;
//        return jdbcTemplate.queryForObject(sql, Integer.class, login) != 0;
//    }


}
