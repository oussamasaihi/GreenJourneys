package com.greenjourneys.services;

import com.fasterxml.uuid.Generators;
import com.greenjourneys.entities.Role;
import com.greenjourneys.entities.User;
import com.greenjourneys.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service

public class UserService implements IUserService{
    @Autowired
    UserRepository ur;

    @Autowired
    MailService mailService ;

    @Override
   /* public void register (User user) throws MessagingException, UnsupportedEncodingException {
        String pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(pw_hash);
        String token = "token-" + Generators.nameBasedGenerator().generate(user.getUsername());
        String tokenPass = "token-" + Generators.nameBasedGenerator().generate(user.getUsername());
        user.setEnabled(false);
        user.setToken(token);
        user.setResetPasswordToken(tokenPass);
        Role role = new Role();
        role.setName("USER_ROLE");

        user.getRoles().add(role);
        ur.save(user);
        mailService.sendVerificationEmail(user);
    }*/
    public void register(User user) throws MessagingException, UnsupportedEncodingException {
        if (user == null || user.getEmail() == null || user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("User object must not be null and must contain email, username, and password fields");
        }

        if (ur.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email already in use");
        }

        if (ur.getUserByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already in use");
        }

        String pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(pw_hash);
        String token = "token-" + Generators.nameBasedGenerator().generate(user.getUsername());
        String tokenPass = "token-" + Generators.nameBasedGenerator().generate(user.getUsername());
        user.setEnabled(false);
        user.setToken(token);
        user.setResetPasswordToken(tokenPass);
        Role role = new Role();
        role.setName("USER_ROLE");
        user.getRoles().add(role);
        ur.save(user);
        mailService.sendVerificationEmail(user);
    }


    @Override
    public List<User> getUsers() {
        return (List<User>) ur.findAll();
    }

    @Override
    public void deleteUser(User user) {
        ur.delete(user);
    }

    @Override
    public void updateUser(User user) {
        String pw_hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(pw_hash);
        String token = "token-" + Generators.nameBasedGenerator().generate(user.getUsername());
        String tokenPass = "token-" + Generators.nameBasedGenerator().generate(user.getUsername());
        user.setEnabled(true);
        user.setToken(token);
        user.setResetPasswordToken(tokenPass);
        Role role = new Role();
        role.setName("USER_ROLE");

        user.getRoles().add(role);
        ur.save(user);
    }


    @Override
    public int testUnique(User user) {
        if(ur.uniqueTestEmail(user.getEmail()) != null) {
            return 1;
        }
        if(ur.uniqueTestUsername(user.getUsername()) != null ) {
            return 2;
        }
        return 0;
    }

    @Override
    public int testUniqueWithId(User user) {
        if(ur.uniqueTestEmailWithId(user.getId(), user.getEmail()) != null) {
            return 1;
        }
        if(ur.uniqueTestUsernameWithId(user.getId(), user.getUsername()) != null ) {
            return 2;
        }
        return 0;
    }

    @Override
    public void addUser(User user) {
        ur.save(user);    }

    @Override
    public User getUserById(int id) {
        return ur.findById(id).get();
    }

    @Override
    public void verify(String token) {
        User user = ur.getUserByToken(token);
        user.setEnabled(true);
        ur.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = ur.getUserByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found with username " + username);
        }
        return user;
    }
    public void updateResetPasswordToken(String token, String email) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        User user = ur.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            ur.save(user);
        } else {
            throw new RuntimeException("User not found with email " + email);
        }
    }

    public User getUserByResetPasswordToken(String token) {
        User user = ur.findFirstByResetPasswordToken(token);
        if (user == null) {
            throw new RuntimeException("User not found with reset password token " + token);
        }
        return user;
    }



    public void updatePassword(User user, String newPassword) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (newPassword == null || newPassword.isEmpty()) {
            throw new IllegalArgumentException("New password cannot be null or empty");
        }
        String pw_hash = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        String tokenPass = "token-" + Generators.nameBasedGenerator().generate(user.getUsername());

        user.setPassword(pw_hash);
        user.setResetPasswordToken(tokenPass);
        ur.save(user);
    }
    public User getUserByEmail(String email) {
        User user = ur.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found with email " + email);
        }
        return user;
    }
    public boolean checkPassword(User user, String password) {
        String encodedPassword = user.getPassword();
        return BCrypt.checkpw(password, encodedPassword);
    }
//TODO :trying to login user and get the jwt token  and user as response

    /*public  User login (User user){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        MyUserDetails principal = (MyUserDetails) authentication.getPrincipal();
        String jwt = jwtUtil.generateToken(principal);
        User loginUser = principal.getUser();
        loginUser.setToken(jwt);
        return loginUser;
    }*/
}
