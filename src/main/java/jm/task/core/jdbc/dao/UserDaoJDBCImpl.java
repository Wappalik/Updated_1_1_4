package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try(Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS chmoshniki (id BIGINT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR (64), lastname VARCHAR (64), age TINYINT (10))");
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void dropUsersTable() {
        try(Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
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
        try(Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(saveUser);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void removeUserById(long id) {
        try(Connection connection = Util.getConnection(); Statement statement = connection.createStatement();) {
            statement.executeUpdate("DELETE FROM chmoshniki WHERE 'id' = " + id );
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    public List<User> getAllUsers() {
    List <User> list = new ArrayList<>();
        return null;
    }


    public void cleanUsersTable() {
    try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()){
        statement.executeUpdate("DELETE FROM chmoshniki");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
}
