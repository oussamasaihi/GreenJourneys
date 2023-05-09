package com.greenjourneys.controller;

import com.greenjourneys.entities.Group;
import com.greenjourneys.entities.Interest;
import com.greenjourneys.entities.User;
import com.greenjourneys.services.GroupService;
import com.greenjourneys.services.IInterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class GroupCont {
    private final GroupService groupService;
    private final IInterestService interestService ;
    @GetMapping({"/groups"})
    public List<Group> retrive() {
        return groupService.getAllGroup();
    }

    @GetMapping({"/group/{id}"})
    public Group retriveById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @PostMapping({"/group/add"})
    public Group addGroup(@RequestBody Group g) {
        return groupService.addGroup(g);
    }

    @DeleteMapping({"/group/delete/{id}"})
    public void deleteGroup(@PathVariable long id) {
        groupService.iGroup.deleteById(id);
    }

    @PutMapping({"/group/update"})
    public Group updateGroup(@RequestBody Group group) {
        return groupService.iGroup.save(group);
    }

    @PostMapping({"/group/matching"})
    public void matching(@RequestBody User user) {
        Iterator var2 = user.getInterest().iterator();

        while(var2.hasNext()) {
            Interest interest = (Interest)var2.next();
            List<User> otherUsers = this.interestService.getUsersByInterest(interest);
            if (!otherUsers.isEmpty()) {
                Group newGroup = new Group();
                newGroup.setName("chnageme-" + interest.getActivityName());
                newGroup.getUsers().addAll(otherUsers);
                this.groupService.addGroup(newGroup);
            }
        }

    }
}
