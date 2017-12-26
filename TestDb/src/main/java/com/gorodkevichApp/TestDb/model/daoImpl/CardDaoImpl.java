package com.gorodkevichApp.TestDb.model.daoImpl;

import com.gorodkevichApp.TestDb.model.dao.CardDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CardDaoImpl implements CardDao {
    private JdbcConnect connect;

    public CardDaoImpl(JdbcConnect connect) {
        this.connect = connect;
    }

    @Override
    public void createCard(int cardNumber, String currentUserName) {
        String SQLCreateCard = "INSERT INTO card (card_number, card_users_id)" +
                "VALUES (?,(SELECT users_id FROM users WHERE users_name=?))";
        try (Connection connection = connect.getConnection();
             PreparedStatement createCard = connection.prepareStatement(SQLCreateCard)) {
            createCard.setInt(1, cardNumber);
            createCard.setString(2, currentUserName);
            createCard.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateStatus(int newCardNumber) {
        String SQLUpdateStatus = "";
        try (Connection connection = connect.getConnection();
             PreparedStatement updateStatus = connection.prepareStatement(SQLUpdateStatus)) {
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
