package com.gorodkevichApp.TestDb.model.daoImpl;

import com.gorodkevichApp.TestDb.model.dao.UsersDao;
import com.gorodkevichApp.TestDb.model.domain.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UsersDao {
    private JdbcConnect jdbcConnect;

    public UserDaoImpl(JdbcConnect jdbcConnect) {
        this.jdbcConnect = jdbcConnect;
    }

    @Override
    public Users getById(int id) {
        String SelectById = "select * from users where user_id =?";
        try {
            Connection connection = jdbcConnect.getConnection();
            PreparedStatement stms = connection.prepareStatement(SelectById);
            stms.setInt(1,id);
            ResultSet rs = stms.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("user_name"));
                /*return new Users(rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getInt("user_status"));*/
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertUser(Users user) {

    }

    @Override
    public void updateUser(Users user) {

    }

}
