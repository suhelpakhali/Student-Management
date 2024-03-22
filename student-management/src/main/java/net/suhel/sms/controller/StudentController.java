package net.suhel.sms.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.suhel.sms.dto.StudentDto;
import net.suhel.sms.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {
    UserServiceImpl userService ;
    @GetMapping("/students")
    public String findAllStudent(Model model){
      List<StudentDto> studentDto=  userService.findAll();
      model.addAttribute("Students",studentDto);
      return "Students";
    }

    @GetMapping("/student/new")
    public String createStudent(Model model){
       StudentDto studentDto=new StudentDto();
       model.addAttribute("student",studentDto);
       return "create-student";
    }
@PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto studentDto, BindingResult result, Model model){
        if(result.hasErrors()){

            return "create-student";
        }
        userService.saveStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("students/{studentId}/edit")
    public String editStudent (@PathVariable("studentId") Long studentId, Model model){
        StudentDto studentDto=userService.findById(studentId);
        model.addAttribute("student",studentDto);
        return "edit-student";
    }

@PostMapping("students/{studentId}")
    public String saveEditStudent (@PathVariable("studentId") Long id,@Valid @ModelAttribute ("student") StudentDto studentDto,
                                   BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("student",studentDto);
            return "edit-student";
        }
        studentDto.setId(id);
        userService.updateStudent(studentDto);
        return "redirect:/students";
}

@GetMapping("students/{studentId}/delete")
public String deleteStudent (@PathVariable ("studentId") Long id){
        userService.deleteById(id);
        return"redirect:/students";

}

@GetMapping("students/{studentId}/view")
    public String viewStudent (@PathVariable("studentId") Long id, Model model){
        StudentDto studentDto= userService.findById(id);
        model.addAttribute("student",studentDto);
        return "view-student";

}


}
