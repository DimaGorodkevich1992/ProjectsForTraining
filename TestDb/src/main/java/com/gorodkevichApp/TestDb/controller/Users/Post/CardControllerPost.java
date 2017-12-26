package com.gorodkevichApp.TestDb.controller.Users.Post;

import com.gorodkevichApp.TestDb.model.domain.Card;
import com.gorodkevichApp.TestDb.services.CardServices.CardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardControllerPost {
    @Autowired
    CardServices cardServices = new CardServices();

    @RequestMapping(value = "/login/addCard", method = RequestMethod.POST)
    public boolean addCard(@RequestBody Card card) {
        if (cardServices.addCard(card)) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/login/updateCardStatus/",method = RequestMethod.PUT)
    public String updateCardStatus (@RequestBody int cardNumber){
        return cardServices.updateCardStatus(cardNumber);
    }
}
