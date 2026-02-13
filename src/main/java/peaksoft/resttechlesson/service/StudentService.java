package peaksoft.resttechlesson.service;

import peaksoft.resttechlesson.dto.SimpleResponse;
import peaksoft.resttechlesson.dto.student.StudentRequest;
import peaksoft.resttechlesson.dto.student.StudentResponse;

import java.util.List;

public interface StudentService {

    SimpleResponse saveStudent(StudentRequest studentRequest);

    List<StudentResponse> getAllStudent();

    StudentResponse getById(Long id);

    SimpleResponse updateStudent(Long id, StudentRequest studentRequest);

    SimpleResponse deleteStudent(Long id);

}
