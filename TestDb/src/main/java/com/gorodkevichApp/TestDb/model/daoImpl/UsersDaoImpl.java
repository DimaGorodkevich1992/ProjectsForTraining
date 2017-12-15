package com.gorodkevichApp.TestDb.model.daoImpl;

import com.gorodkevichApp.TestDb.model.dao.UsersDao;
import com.gorodkevichApp.TestDb.model.domain.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoImpl implements UsersDao {
    private JdbcConnect connect;

    public UsersDaoImpl(JdbcConnect connect) {
        this.connect = connect;
    }


    @Override
    public Users getForUsers(String name) {
        String SQLselectByName = "SELECT users_name, users_password, users_status FROM users WHERE users_name =?";

        try (Connection connection = connect.getConnection();
             PreparedStatement prst = connection.prepareStatement(SQLselectByName);) {
            prst.setString(1, name);
            ResultSet resultSet = prst.executeQuery();
            while (resultSet.next()) {
                return new Users(resultSet.getString("users_name"), resultSet.getString("users_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void create(Users users) {
        String SQLsetUsers = "INSERT INTO users (users_name,users_password) VALUES (?, ?)";
        String usersName = users.getUsersName();
        String userPassword = users.getUsersPassword();

        try (Connection connection = connect.getConnection();
             PreparedStatement prst = connection.prepareStatement(SQLsetUsers);) {
            prst.setString(1, usersName);
            prst.setString(2, userPassword);
            prst.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updatePassword(String name , String newPassword) {
        String SQLupdatePassword = "UPDATE users SET users_password =? WHERE users_name = ?";
        try (Connection connection = connect.getConnection();
             PreparedStatement prst = connection.prepareStatement(SQLupdatePassword);) {
            prst.setString(1, newPassword);
            prst.setString(2, name);

            prst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateStatus(String name) {
        String SQLupdatePassword = "UPDATE users SET users_status = FALSE WHERE users_name=?";
        try (Connection connection = connect.getConnection();
             PreparedStatement prst = connection.prepareStatement(SQLupdatePassword);) {
            prst.setString(1, name);
            prst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}