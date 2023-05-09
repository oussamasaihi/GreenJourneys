package com.greenjourneys.services;

import com.greenjourneys.entities.Role;

import java.util.List;

public interface IRoleService {
    void addRole(Role role);
    List<Role> getRoles();
    void deleteRole(Role role);
    void updateRole(Role role);

    Role getRoleById(int id);
    Role getRoleByName(String name);
}
