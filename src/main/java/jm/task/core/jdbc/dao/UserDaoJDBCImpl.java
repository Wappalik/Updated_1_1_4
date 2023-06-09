package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {


    private Connection connection = Util.getConnection();


    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try(Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS chmoshniki (id BIGINT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR (64), lastname VARCHAR (64), age TINYINT (10))");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void dropUsersTable() {
        try(Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS chmoshniki");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
//        try(Connection connection = Util.getConnection(); PreparedStatement statement =
//                connection.prepareStatement("INSERT INTO Table1 ()")) {
//
//        } catch (SQLException e) {
//            e.getStackTrace();
//        }
        String saveUser = "INSERT INTO chmoshniki (name,lastname,age) VALUES ('" + name + "', '" + lastName + "', '" + String.valueOf(age) + "')";
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(saveUser);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void removeUserById(long id) {
        try(PreparedStatement statement = connection.prepareStatement("DELETE  FROM chmoshniki WHERE id = ?")) {
//            statement.executeUpdate("DELETE FROM chmoshniki WHERE 'id' = " + id );
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    public List<User> getAllUsers() {
    List <User> list = new ArrayList<>();
    try(Statement statement = connection.createStatement()){
        ResultSet resultSet = statement.executeQuery("SELECT * FROM chmoshniki ");
       while (resultSet.next()) {
           User user1 = new User();
           user1.setId(resultSet.getLong("id"));
           user1.setName(resultSet.getString("name"));
           user1.setLastName(resultSet.getString("lastname"));
           user1.setAge(resultSet.getByte("age"));
           list.add(user1);
       }
    } catch (SQLException e) {
        e.getStackTrace();
    }
        return list;
    }


    public void cleanUsersTable() {
    try (Statement statement = connection.createStatement()){
        statement.executeUpdate("DELETE FROM chmoshniki");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
}
