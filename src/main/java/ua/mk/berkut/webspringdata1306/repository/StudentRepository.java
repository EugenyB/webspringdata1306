package ua.mk.berkut.webspringdata1306.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mk.berkut.webspringdata1306.data.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}