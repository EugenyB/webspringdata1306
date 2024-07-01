package ua.mk.berkut.webspringdata1306.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mk.berkut.webspringdata1306.data.Teacher;
import ua.mk.berkut.webspringdata1306.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {

    private TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findTeacherById(Long tid) {
        return teacherRepository.findById(tid);
    }

    public void removeSubjectFromTeacher(Long tid, Long sid) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(tid);
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            teacher.getSubjects().removeIf(s->s.getId().equals(sid));
            teacherRepository.save(teacher);
        }
    }

    public void deleteTeacher(Long tid) {
        teacherRepository.deleteById(tid);
    }

    public void addTeacher(String tname, int texp) {
        Teacher teacher = new Teacher(tname, texp);
        teacherRepository.save(teacher);
    }
}
