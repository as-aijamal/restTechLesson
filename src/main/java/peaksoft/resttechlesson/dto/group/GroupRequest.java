package peaksoft.resttechlesson.dto.group;

import java.time.LocalDate;

public record GroupRequest(
         String groupName,
         String description,
         LocalDate finishes)
{
}
