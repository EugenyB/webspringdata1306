package ua.mk.berkut.webspringdata1306.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.mk.berkut.webspringdata1306.data.Teacher;
import ua.mk.berkut.webspringdata1306.service.TeacherService;

@RestController
@RequestMapping("/rest/teachers")
@AllArgsConstructor
public class TeacherRestController {
    private final TeacherService teacherService;

    @PostMapping("/add")
    public Teacher addTeacher(@RequestParam String name, @RequestParam int experience) {
        return teacherService.addTeacher(name, experience);
    }
}
