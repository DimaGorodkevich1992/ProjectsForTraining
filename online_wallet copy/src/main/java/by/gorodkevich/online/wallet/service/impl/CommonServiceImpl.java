package by.gorodkevich.online.wallet.service.impl;

import by.gorodkevich.online.wallet.entity.CommonEntity;
import by.gorodkevich.online.wallet.repository.CommonRepository;
import by.gorodkevich.online.wallet.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class CommonServiceImpl<E extends CommonEntity> implements CommonService<E> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceImpl.class);

    private static final String WRONG_ARGUMENT_MESSAGE = "Wrong argument.";
    private static final String CANNOT_BE_NULL_MESSAGE = WRONG_ARGUMENT_MESSAGE + " Entity cannot be null";
    private static final String CANNOT_BE_ZORE_MESSAGE = WRONG_ARGUMENT_MESSAGE + " Id cannot be 0";

    private CommonRepository<E> repository;
    private final String serviceName;

    public CommonServiceImpl(CommonRepository<E> repository) {
        this.repository = repository;
        this.serviceName = this.getClass().getName();
        LOGGER.debug("Create service:{}", this.serviceName);
    }

    @Override
    public E get(long id) {
        LOGGER.debug("Get by id:{}, in service:{}", id, serviceName);
        if (id == 0) {
            LOGGER.warn(CANNOT_BE_ZORE_MESSAGE);
            throw new IllegalArgumentException(CANNOT_BE_ZORE_MESSAGE);
        }
        return repository.getOne(id);
    }

    @Override
    public E get(E entity) {
        if (Objects.isNull(entity)) {
            LOGGER.warn(CANNOT_BE_NULL_MESSAGE);
            throw new IllegalArgumentException(CANNOT_BE_NULL_MESSAGE);
        }
        return get(entity.getId());
    }

    @Override
    public Optional<E> find(long id) {
        LOGGER.debug("Find by id:{}, in service:{}", id, serviceName);
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Find all in service:{}", serviceName);
        }
        return repository.findAll();
    }

    @Override
    public void delete(E entity) {
        E entityInRepository  = get(entity);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Delete entity:{} in service:{}", entity, serviceName);
        }
        repository.delete(entityInRepository);
    }

    @Override
    public void deleteAll() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Delete all in service:{}", serviceName);
        }
        repository.deleteAll();
    }

    @Override
    public E save(E entity) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Save entity:{} in service:{}", entity, serviceName);
        }
        return repository.save(entity);
    }
}
