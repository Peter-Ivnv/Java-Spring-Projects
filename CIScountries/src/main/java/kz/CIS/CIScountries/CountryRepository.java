package kz.CIS.CIScountries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findAllById(Long id);
}
