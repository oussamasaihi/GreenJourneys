package com.greenjourneys.controller;

import com.greenjourneys.entities.Role;
import com.greenjourneys.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class RoleController {
    @Autowired
    IRoleService rs;

    @GetMapping(value = "/getRoles")
    @ResponseBody
    public List<Role> getRoles() {
        return rs.getRoles();
    }

    @GetMapping(value = "/getRole/{id}")
    @ResponseBody
    public Role getRole(@PathVariable("id") int id) {
        return rs.getRoleById(id);
    }

    @PostMapping("/addRole")
    @ResponseBody
    public void addRole(@RequestBody Role role) {
        rs.addRole(role);
    }

    @DeleteMapping("/deleteRole/{id}")
    @ResponseBody
    public void deleteRole(@PathVariable("id") int id) {
        Role role = rs.getRoleById(id);
        rs.deleteRole(role);
    }

    @PutMapping("/updateRole/{id}")
    public void updateRole(@RequestBody Role role, @PathVariable("id") int id) {
		/*Role r = rs.getRoleById(id);
		r.setName(role.getName());
		rs.updateRole(role);*/
        role.setId(id);
        rs.updateRole(role);
    }
}
