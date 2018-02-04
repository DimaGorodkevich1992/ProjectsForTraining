package by.gorodkevich.app.service;

import by.gorodkevich.app.persistence.entity.CheckEntity;
import by.gorodkevich.app.persistence.entity.RequestEntity;
/**
 * Класс для перемещения денег внутри системы*/
public interface InternalMoneyTransferService {
    /**
     *
     * @param requestForMove сущность с номерами аккаунтов для перемещения денег
     * @param checkForMove  сущность в которой указана сумма для перемещения
     */
    void move(RequestEntity requestForMove, CheckEntity checkForMove);

}
