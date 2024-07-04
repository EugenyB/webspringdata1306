package ua.mk.berkut.webspringdata1306.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mk.berkut.webspringdata1306.data.Subject;
import ua.mk.berkut.webspringdata1306.data.Teacher;
import ua.mk.berkut.webspringdata1306.repository.SubjectRepository;
import ua.mk.berkut.webspringdata1306.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {

    private TeacherRepository teacherRepository;
    private SubjectRepository subjectRepository;

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
            teacher.getSubjects().removeIf(s -> s.getId().equals(sid));
            teacherRepository.save(teacher);
        }
    }

    public void deleteTeacher(Long tid) {
        teacherRepository.deleteById(tid);
    }

    public Teacher addTeacher(String tname, int texp) {
        Teacher teacher = new Teacher(tname, texp);
        teacherRepository.save(teacher);
        return teacher;
    }

    public void updateTeacher(Long tid, String tname, int texp) {
        teacherRepository.findById(tid).ifPresent(t -> {
            t.setFullName(tname);
            t.setExperience(texp);
            teacherRepository.save(t);
        });

//        Optional<Teacher> optionalTeacher = teacherRepository.findById(tid);
//        if (optionalTeacher.isPresent()) {
//            Teacher teacher = optionalTeacher.get();
//            teacher.setFullName(tname);
//            teacher.setExperience(texp);
//            teacherRepository.save(teacher);
//        }
    }

    public List<Subject> findAvailableSubjects(Long tid) {
        return subjectRepository.findAvailableSubjects(tid);
    }

    public void addSubject(Long tid, Long sid) {
        teacherRepository.findById(tid).ifPresent(t -> {
            Optional<Subject> oSubject = subjectRepository.findById(sid);
            if (oSubject.isPresent()) {
                t.getSubjects().add(oSubject.get());
                teacherRepository.save(t);
            }
        });
    }

    public void removeSubject(Long tid, Long sid) {
        teacherRepository.findById(tid).ifPresent(t -> {
           t.getSubjects().removeIf(s -> s.getId().equals(sid));
           teacherRepository.save(t);
        });
    }
}
