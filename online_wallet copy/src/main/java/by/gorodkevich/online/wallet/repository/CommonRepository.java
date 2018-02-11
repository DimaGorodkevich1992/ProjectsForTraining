package by.gorodkevich.online.wallet.repository;

import by.gorodkevich.online.wallet.entity.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends CommonEntity> extends JpaRepository<E, Long> {
}
