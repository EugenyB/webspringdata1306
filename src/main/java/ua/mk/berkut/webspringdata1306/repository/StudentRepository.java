package ua.mk.berkut.webspringdata1306.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mk.berkut.webspringdata1306.data.Student;
import ua.mk.berkut.webspringdata1306.data.StudentInfo;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<StudentInfo> findByIdNotNull();

}