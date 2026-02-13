package peaksoft.resttechlesson.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.resttechlesson.dto.SimpleResponse;
import peaksoft.resttechlesson.dto.student.StudentRequest;
import peaksoft.resttechlesson.dto.student.StudentResponse;
import peaksoft.resttechlesson.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentApi {

    private final StudentService studentService;

    @PostMapping
    public SimpleResponse saveStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest);
    }

    @GetMapping
    public List<StudentResponse> getAll() {
        return studentService.getAllStudent();
    }

    //    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentService.getById(id);
//    }

    @GetMapping("/getById")
    public StudentResponse getStudentById(@RequestParam Long id) {
        return studentService.getById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
      return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }


}
