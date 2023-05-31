package kz.bitlabJava.SpringTask61.Repositories;

import kz.bitlabJava.SpringTask61.Entities.AppRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AppRequestRepository extends JpaRepository<AppRequest, Long> {
    List<AppRequest> findAllByHandledIsTrue();
    List<AppRequest> findAllByHandledIsFalse();
}
