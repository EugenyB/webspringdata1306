package ua.mk.berkut.webspringdata1306.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mk.berkut.webspringdata1306.data.Faculty;
import ua.mk.berkut.webspringdata1306.data.Student;
import ua.mk.berkut.webspringdata1306.data.StudentInfo;
import ua.mk.berkut.webspringdata1306.repository.FacultyRepository;
import ua.mk.berkut.webspringdata1306.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;
    private FacultyRepository facultyRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student, Long facultyId) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(facultyId);
        if (optionalFaculty.isPresent()) {
            student.setFaculty(optionalFaculty.get());
            studentRepository.save(student);
        }
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<StudentInfo> findStudentInfo() {
        return studentRepository.findByIdNotNull();
    }
}
