package dbr.services.users;

import dbr.entities.users.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private UserEntity getUserByLogin(String login) {
        String sql = "SELECT * from users WHERE login = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new UserEntity(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getInt("level"),
                rs.getInt("group_id")
        ), login).get(0);
    }

    public UserEntity create(String login, String password) {
        String sql = "INSERT INTO users(login, password, level, group_id) VALUES(?, ?, 0, 1)";

       jdbcTemplate.update(sql, login, password);

        return this.getUserByLogin(login);
    }

    public UserEntity auth(String login, String password) throws Exception {
        UserEntity user = this.getUserByLogin(login);
        if(user.password.equals(password)) {
            return user;
        }
        throw new Exception("Неправильный логин или пароль");
    }
}
