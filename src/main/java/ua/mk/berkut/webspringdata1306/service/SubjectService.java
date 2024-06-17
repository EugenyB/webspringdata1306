package ua.mk.berkut.webspringdata1306.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mk.berkut.webspringdata1306.data.Subject;
import ua.mk.berkut.webspringdata1306.repository.SubjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService {
    private SubjectRepository subjectRepository;

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public void deleteSubjectById(Long sid) {
        try {
            subjectRepository.deleteById(sid);
        } catch (Exception ignored) {
        }

    }
}
