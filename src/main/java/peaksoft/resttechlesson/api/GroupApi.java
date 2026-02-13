package peaksoft.resttechlesson.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.resttechlesson.dto.SimpleResponse;
import peaksoft.resttechlesson.dto.group.GroupRequest;
import peaksoft.resttechlesson.dto.group.GroupResponse;
import peaksoft.resttechlesson.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("api/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService groupService;

    @PostMapping
    public SimpleResponse saveGroup(@RequestBody GroupRequest groupRequest) {
        return groupService.saveGroup(groupRequest);
    }

    @GetMapping
    public List<GroupResponse> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public GroupResponse getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @PostMapping("/{id}")
    public SimpleResponse assignStudentToGroup(@PathVariable Long id, @RequestParam Long studentId) {
        return groupService.assignStudentToGroup(studentId, id);
    }

}
