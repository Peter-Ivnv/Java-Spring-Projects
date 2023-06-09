package kz.bitlabJava.SpringTask61.Repositories;

import kz.bitlabJava.SpringTask61.Entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CoursesRepository extends JpaRepository<Courses, Long> {

}
