package dbr.entities.users;

public class UserEntity {

    public int id;

    public String login;
    public String password;
    public int level;
    public int group_id;

    public UserEntity(int id, String login, String password, int level, int group_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.level = level;
        this.group_id = group_id;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                ", group_id=" + group_id +
                '}';
    }
}
