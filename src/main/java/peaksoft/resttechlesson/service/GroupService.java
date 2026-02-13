package peaksoft.resttechlesson.service;

import peaksoft.resttechlesson.dto.SimpleResponse;
import peaksoft.resttechlesson.dto.group.GroupRequest;
import peaksoft.resttechlesson.dto.group.GroupResponse;
import peaksoft.resttechlesson.entity.Group;

import java.util.List;

public interface GroupService {

    SimpleResponse saveGroup(GroupRequest groupRequest);

    List<GroupResponse> getAllGroups();

    GroupResponse getGroupById(Long id);

    SimpleResponse updateGroup(Long id, GroupRequest groupRequest);

    SimpleResponse deleteGroup(Long id);

    SimpleResponse assignStudentToGroup(Long studentId, Long groupId);
}
