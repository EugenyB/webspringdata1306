package ua.mk.berkut.webspringdata1306.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.mk.berkut.webspringdata1306.service.SubjectService;

@Controller
@RequestMapping("/subjects")
@AllArgsConstructor
public class SubjectController {
    private SubjectService subjectService;

    @GetMapping
    public String showSubjects(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        return "subjects";
    }

    @GetMapping("/delete")
    public String deleteSubject(@RequestParam Long sid) {
        subjectService.deleteSubjectById(sid);
        return "redirect:/subjects";
    }
}
