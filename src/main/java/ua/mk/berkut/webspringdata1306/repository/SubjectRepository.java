package ua.mk.berkut.webspringdata1306.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mk.berkut.webspringdata1306.data.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}