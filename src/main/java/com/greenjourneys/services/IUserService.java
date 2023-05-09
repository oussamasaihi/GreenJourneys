package com.greenjourneys.services;

import com.greenjourneys.entities.User;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IUserService {
    void register (User user) throws MessagingException, UnsupportedEncodingException;
    List<User> getUsers();
    void deleteUser(User user);
    void updateUser(User user);
    int testUnique(User user);
    User getUserById(int id);
    void verify (String token);
    int testUniqueWithId(User user);
    void addUser(User user);


    User getUserByUsername(String username);
}
