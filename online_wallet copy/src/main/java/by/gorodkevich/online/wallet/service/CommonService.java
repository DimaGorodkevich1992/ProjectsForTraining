package by.gorodkevich.online.wallet.service;

import by.gorodkevich.online.wallet.entity.CommonEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends CommonEntity> {
    E get(long id);
    E get(E entity);
    Optional<E> find(long id);
    List<E> findAll();
    E save(E entity);
    void delete(E entity);
    void deleteAll();
}
