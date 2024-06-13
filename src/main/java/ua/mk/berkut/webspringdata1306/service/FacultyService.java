package ua.mk.berkut.webspringdata1306.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mk.berkut.webspringdata1306.data.Faculty;
import ua.mk.berkut.webspringdata1306.repository.FacultyRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FacultyService {

    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
}
