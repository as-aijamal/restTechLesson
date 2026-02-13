package peaksoft.resttechlesson.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.resttechlesson.dto.student.StudentResponse;
import peaksoft.resttechlesson.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<@NonNull Student, @NonNull Long> {

    @Query("select new peaksoft.resttechlesson.dto.student.StudentResponse(s.id,s.firstName,s.lastName,s.age,s.email,s.blocked)from Student s")
    List<StudentResponse> getAllStudent();

}


