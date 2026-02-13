package peaksoft.resttechlesson.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.resttechlesson.dto.SimpleResponse;
import peaksoft.resttechlesson.dto.StudentRequest;
import peaksoft.resttechlesson.dto.StudentResponse;
import peaksoft.resttechlesson.entity.Student;
import peaksoft.resttechlesson.repository.StudentRepository;
import peaksoft.resttechlesson.service.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public SimpleResponse saveStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setAge(studentRequest.getAge());
        student.setEmail(studentRequest.getEmail());
        student.setBlocked(false);
        studentRepository.save(student);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Student wit id %d saved", student.getId()))
                .build();
    }

    @Override
    public List<StudentResponse> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public StudentResponse getById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        String.format("Student with id %d is not found", id)
                )
        );
        return StudentResponse
                .builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .email(student.getEmail())
                .blocked(student.isBlocked())
                .build();


    }

    @Override
    public SimpleResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student1 = studentRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        String.format("Student with id %d is not found", id)
                )
        );
        student1.setFirstName(studentRequest.getFirstName());
        student1.setLastName(studentRequest.getLastName());
        student1.setAge(studentRequest.getAge());
        student1.setEmail(studentRequest.getEmail());
        studentRepository.save(student1);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Student updated successfully")
                .build();

    }

    @Override
    public SimpleResponse deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new NoSuchElementException(String.format("Student with id %d is not found", id));
        }
        studentRepository.deleteById(id);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Student with id: " + id + " is deleted")
                .build();

    }
}
