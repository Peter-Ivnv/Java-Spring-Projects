package ru.transfermarket.transfermarket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.transfermarket.transfermarket.entities.Player;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByNameContainsIgnoreCaseOrSurnameContainsIgnoreCase(String name, String surname);
}
