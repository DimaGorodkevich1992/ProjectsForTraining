package com.gorodkevichApp.TestDb.services.CardServices;


import com.gorodkevichApp.TestDb.model.dao.CardDao;
import com.gorodkevichApp.TestDb.model.daoImpl.CardDaoImpl;
import com.gorodkevichApp.TestDb.model.daoImpl.JdbcConnect;
import com.gorodkevichApp.TestDb.model.domain.Card;
import com.gorodkevichApp.TestDb.services.UserServices.UserServices;
import org.springframework.stereotype.Service;

@Service
public class CardServices {
    CardDao cardDao = new CardDaoImpl(JdbcConnect.getInstance());

    public boolean addCard(Card card) {
        if (UserServices.getCurrentUserName()!=null){
            cardDao.createCard(card.getCardNumber(),UserServices.getCurrentUserName());
            return true;
        }else return false;
    }

    public String updateCardStatus(int cardNumber) {
        cardDao.updateStatus(cardNumber);
        return "card status update";
    }
}
