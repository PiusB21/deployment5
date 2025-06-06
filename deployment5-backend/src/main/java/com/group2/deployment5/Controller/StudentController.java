package com.group2.deployment5.Controller;

import com.group2.deployment5.DTO.StudentDTO;
import com.group2.deployment5.Entity.Student;
import com.group2.deployment5.ServiceImpl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody StudentDTO studentDTO) {
        try{
            return ResponseEntity.ok(studentService.registerStudent(studentDTO));
        }
        catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/register-many")
    public ResponseEntity<?> registerMany(@RequestBody List<StudentDTO> studentDTOList) {
        try { return ResponseEntity.ok(studentService.registerStudents(studentDTOList)); }
        catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("student")
    public ResponseEntity<?> getStudent(int id) {
        try{return ResponseEntity.ok(studentService.getStudentById(id)); }
        catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
