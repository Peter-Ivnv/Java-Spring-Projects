package kz.Ivanov.crm.crm.manager.repositories;

import kz.Ivanov.crm.crm.manager.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findAllByHandledIsTrue();
}
