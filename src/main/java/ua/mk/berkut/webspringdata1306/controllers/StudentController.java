package ua.mk.berkut.webspringdata1306.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.mk.berkut.webspringdata1306.data.Student;
import ua.mk.berkut.webspringdata1306.service.FacultyService;
import ua.mk.berkut.webspringdata1306.service.StudentService;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final FacultyService facultyService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculties());
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam("first_name") String firstName,
            @RequestParam("last_name") String lastName,
            @RequestParam Integer age,
            @RequestParam("faculty_id") Long facultyId) {

        studentService.addStudent(new Student(firstName, lastName, age), facultyId);
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
