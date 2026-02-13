package peaksoft.resttechlesson.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.resttechlesson.dto.SimpleResponse;
import peaksoft.resttechlesson.dto.group.GroupRequest;
import peaksoft.resttechlesson.dto.group.GroupResponse;
import peaksoft.resttechlesson.entity.Group;
import peaksoft.resttechlesson.entity.Student;
import peaksoft.resttechlesson.repository.GroupRepository;
import peaksoft.resttechlesson.repository.StudentRepository;
import peaksoft.resttechlesson.service.GroupService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @Override
    public SimpleResponse saveGroup(GroupRequest groupRequest) {
        Group group = new Group();
        group.setGroupName(groupRequest.groupName());
        group.setDescription(groupRequest.description());
        group.setStarts(LocalDate.now());
        group.setFinishes(groupRequest.finishes());
        groupRepository.save(group);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Group with id: %d is successfully saved", group.getId()))
                .build();
    }

    @Override
    public List<GroupResponse> getAllGroups() {
        return groupRepository.getAllGroups();
    }

    @Override
    public GroupResponse getGroupById(Long id) {
        return groupRepository.getGroupById(id).orElseThrow(
                () -> new NoSuchElementException(
                        String.format("Group with is %d is not found", id)
                )
        );

    }

    @Override
    public SimpleResponse updateGroup(Long id, GroupRequest groupRequest) {
        return null;
    }

    @Override
    public SimpleResponse deleteGroup(Long id) {
        return null;
    }

    @Override
    public SimpleResponse assignStudentToGroup(Long studentId, Long groupId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new NoSuchElementException(
                        String.format("Student with id %d is not found", studentId)
                )
        );
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new NoSuchElementException(
                        String.format("Group with is %d is not found", groupId)
                )
        );

        student.setGroup(group);
        group.getStudents().add(student);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Student with id: %d is assigned to group with id: %d", studentId,groupId))
                .build();
    }
}
