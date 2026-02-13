package peaksoft.resttechlesson.dto.group;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record GroupResponse(
        Long id,
        String groupName,
        String description,
        LocalDate starts,
        LocalDate finishes) {
}
