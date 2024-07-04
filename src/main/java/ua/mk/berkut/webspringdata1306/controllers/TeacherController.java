package ua.mk.berkut.webspringdata1306.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.mk.berkut.webspringdata1306.data.Subject;
import ua.mk.berkut.webspringdata1306.data.Teacher;
import ua.mk.berkut.webspringdata1306.service.TeacherService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teachers")
@AllArgsConstructor
public class TeacherController {

    private TeacherService teacherService;

    @GetMapping
    public String teachers(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teachers";
    }

    @GetMapping("/show_subjects")
    public String showSubjects(@RequestParam Long tid, Model model) {
        Optional<Teacher> optionalTeacher = teacherService.findTeacherById(tid);
        if (optionalTeacher.isPresent()) {
            model.addAttribute("teacher", optionalTeacher.get());
            List<Subject> subjects = teacherService.findAvailableSubjects(tid);
            model.addAttribute("available", subjects);
            return "teachers_subjects";
        }
        return "redirect:/teachers";
    }

    @GetMapping("/delete_subject")
    public String deleteSubject(@RequestParam Long tid, @RequestParam Long sid) {
        teacherService.removeSubjectFromTeacher(tid, sid);
        return "redirect:/teachers/show_subjects?tid=" + tid;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long tid) {
        teacherService.deleteTeacher(tid);
        return "redirect:/teachers";
    }

    @PostMapping("/add_teacher")
    public String addTeacher(@RequestParam String tname, @RequestParam int texp) {
        teacherService.addTeacher(tname, texp);
        return "redirect:/teachers";
    }

    @PostMapping("/edit")
    public String editTeacher(@RequestParam String tname, @RequestParam int texp, @RequestParam Long tid) {
        teacherService.updateTeacher(tid, tname, texp);
        return "redirect:/teachers";
    }

    @GetMapping("/subjects/add/{tid}/{sid}")
    public String addSubject(@PathVariable Long tid, @PathVariable Long sid) {
        teacherService.addSubject(tid, sid);
        return "redirect:/teachers/show_subjects?tid="+tid;
    }

    @GetMapping("/subjects/remove/{tid}/{sid}")
    public String removeSubject(@PathVariable Long tid, @PathVariable Long sid) {
        teacherService.removeSubject(tid, sid);
        return "redirect:/teachers/show_subjects?tid="+tid;
    }
}
