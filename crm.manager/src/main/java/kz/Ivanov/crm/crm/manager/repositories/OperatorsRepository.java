package kz.Ivanov.crm.crm.manager.repositories;

import kz.Ivanov.crm.crm.manager.entities.Operators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OperatorsRepository extends JpaRepository<Operators, Long> {
}
