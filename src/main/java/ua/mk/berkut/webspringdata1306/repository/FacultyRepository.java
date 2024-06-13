package ua.mk.berkut.webspringdata1306.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mk.berkut.webspringdata1306.data.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}