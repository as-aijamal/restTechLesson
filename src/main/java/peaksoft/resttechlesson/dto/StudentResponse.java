package peaksoft.resttechlesson.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private boolean blocked;
}
