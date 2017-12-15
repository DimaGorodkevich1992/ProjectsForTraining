package com.gorodkevichApp.TestDb.model.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {
    private static final String Driver = "org.postgresql.Driver";
    private static final String DbUrl = "jdbc:postgresql://localhost:5432/payments_system";
    private static final String Login = "postgres";
    private static final String Password = "city1992";
    private static JdbcConnect instance;

    private JdbcConnect() {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Not found" + Driver, e);
        }
    }

    public static synchronized JdbcConnect getInstance() {
        if (instance == null) {
            instance = new JdbcConnect();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DbUrl, Login, Password);
    }
}
