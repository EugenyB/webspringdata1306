package ua.mk.berkut.webspringdata1306.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mk.berkut.webspringdata1306.data.StudentInfo;
import ua.mk.berkut.webspringdata1306.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class StudentRestController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentInfo> findInfo() {
        return studentService.findStudentInfo();
    }
}
