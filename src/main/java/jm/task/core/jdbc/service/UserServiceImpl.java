package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;


public class UserServiceImpl implements UserService {


    private UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();



    public void createUsersTable() {
    userDao.createUsersTable();
        System.out.println("Создали таблицу ");
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
        System.out.println("Удалили таблицу ");
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name,lastName,age);
        System.out.println("User с именем – " + name  + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
        System.out.println("удален пользователь с id " + id);
    }

    public List<User> getAllUsers() {
        System.out.println("Все юзеры");
        return new UserDaoJDBCImpl().getAllUsers();

    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
        System.out.println("Почистили таблицу");
    }
}
