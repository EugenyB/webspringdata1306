package ua.mk.berkut.webspringdata1306.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.mk.berkut.webspringdata1306.data.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("select s from Subject s where not exists (select 1 from Teacher t where s member of t.subjects and t.id = ?1)")
    List<Subject> findAvailableSubjects(Long tid);
}