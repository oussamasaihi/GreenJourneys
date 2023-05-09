package com.greenjourneys.controller;

import com.greenjourneys.entities.User;
import com.greenjourneys.security.AuthenticationRequest;
import com.greenjourneys.security.AuthenticationResponse;
import com.greenjourneys.security.JwtUtil;
import com.greenjourneys.services.IUserService;
import com.greenjourneys.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    IUserService us;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private MyUserDetailsService userDetailsService ;


    @GetMapping(value = "/getUsers")
    @ResponseBody
    public List<User> getUsers() {
        return us.getUsers();
    }

    @GetMapping(value = "/getUser/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") int id) {
        return us.getUserById(id);
    }

    @GetMapping(value = "/getMyInfo")
    @ResponseBody
    public User getMyInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return us.getUserByUsername(authentication.getName());
    }

    @PostMapping(value = "/register")

    public int register(@RequestBody User user ) throws MessagingException, UnsupportedEncodingException {
        int test = us.testUnique(user);
        if(test == 0) {
            us.register(user);


        }
        return test;
    }

    @GetMapping(value = "/confirm/{token}")
    @ResponseBody
    public String confirm(@PathVariable("token") String token) {
        us.verify(token);
        return "your account is active now";
    }

    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable("id") int id) {
        User user = us.getUserById(id);
        us.deleteUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public int updateUser(@RequestBody User user, @PathVariable("id") int id) {
        user.setId(id);
        int test = us.testUniqueWithId(user);
        if(test == 0) {
            us.updateUser(user);
        }
        return test;
    }

    @PostMapping(value = "/authenticate")
    @ResponseBody
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        AuthenticationResponse response = new AuthenticationResponse(jwt, userDetails);

        return ResponseEntity.ok(response);
    }


    @GetMapping(value = "/current-user")
    @ResponseBody
    public User getCurentUser(Principal principal){
        return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
    }
}
