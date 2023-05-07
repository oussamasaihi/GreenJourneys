package com.greenjourneys.services;

import com.greenjourneys.entities.Group;
import com.greenjourneys.repositories.IGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService implements IGroupService{
    public final IGroup iGroup;
    @Override
    public Group getGroupById(long id) {
        return iGroup.getReferenceById(id);
    }

    @Override
    public Group addGroup(Group g) {
        return iGroup.save(g);
    }

    @Override
    public List<Group> getAllGroup() {
        return iGroup.findAll();
    }

    @Override
    public void deleteGroup(long idGroup) {
        iGroup.deleteById(idGroup);

    }

    @Override
    public Group updateGroup(Group group) {
        return iGroup.save(group);
    }

    @Override
    public void matchGroup() {

    }
}
