package com.greenjourneys.services;

import com.greenjourneys.entities.Group;

import java.util.List;

public interface IGroupService {
    Group getGroupById(long id);

    Group addGroup(Group g);

    List<Group> getAllGroup();

    void deleteGroup(long idGroup);

    Group updateGroup(Group group);

    void matchGroup();
}
