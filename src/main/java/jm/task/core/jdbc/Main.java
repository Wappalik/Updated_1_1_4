package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
      Util.getConnection();
      UserServiceImpl userService = new UserServiceImpl();
      userService.createUsersTable();
      userService.saveUser("Malik","Bakhriddinov",(byte) 25);
        userService.saveUser("Malik1","Bakhriddinov",(byte) 25);
        userService.saveUser("Malik2","Bakhriddinov",(byte) 25);
        userService.saveUser("Malik3","Bakhriddinov",(byte) 25);
        userService.removeUserById(1);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
