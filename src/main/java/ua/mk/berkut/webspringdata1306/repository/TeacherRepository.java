package ua.mk.berkut.webspringdata1306.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mk.berkut.webspringdata1306.data.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    //TODO method find by subject and experience
}