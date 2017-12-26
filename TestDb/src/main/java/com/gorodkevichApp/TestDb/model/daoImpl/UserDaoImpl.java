package com.gorodkevichApp.TestDb.model.daoImpl;

import com.gorodkevichApp.TestDb.model.dao.UserDao;
import com.gorodkevichApp.TestDb.model.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private JdbcConnect connect;

    public UserDaoImpl(JdbcConnect connect) {
        this.connect = connect;
    }

    @Override
    public void createUser(User user) {
        String SQLCreateUser = "INSERT INTO users (users_name, users_password)VALUES (?, ?)";
        try (Connection connection = connect.getConnection();
             PreparedStatement createUser = connection.prepareStatement(SQLCreateUser)) {
            createUser.setString(1, user.getUserName());
            createUser.setString(2, user.getUserPassword());
            createUser.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePassword(String carrentUserName, String oldPassword, String newPassword) {
        String SQLUpdatePassword = "UPDATE users SET users_password=? WHERE users_name=? AND users_password=?";
        try (Connection connection = connect.getConnection();
             PreparedStatement updatePassword = connection.prepareStatement(SQLUpdatePassword)) {
            updatePassword.setString(1, newPassword);
            updatePassword.setString(2, carrentUserName);
            updatePassword.setString(3, oldPassword);
            updatePassword.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
/*
    @Override
    public User loginUser(User users) {
        String SQLLoginUser = "SELECT users_name,users_password FROM users WHERE users_name=?";
        User confirmedUser = new User();
        try (Connection connection = connect.getConnection();
             PreparedStatement loginUser = connection.prepareStatement(SQLLoginUser)) {
            loginUser.setString(1, users.getUserName());
            ResultSet resultSet = loginUser.executeQuery();
            while (resultSet.next()){
                confirmedUser.setUserName(resultSet.getString("users_name"));
                confirmedUser.setUserPassword(resultSet.getString("users_password"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return confirmedUser;
    }*/

    @Override
    public String getPassword(String carrentUserName) {
        String SQLGetPassword = "SELECT users_password FROM users WHERE users_name=?";
        String currentPassword = null;
        try (Connection connection = connect.getConnection();
             PreparedStatement getPassword = connection.prepareStatement(SQLGetPassword)) {
            getPassword.setString(1, carrentUserName);
            ResultSet resultSet = getPassword.executeQuery();
            while (resultSet.next()) {
                currentPassword = resultSet.getString("users_password");
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return currentPassword;
    }
}