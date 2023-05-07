package com.greenjourneys.controller;

import com.fasterxml.uuid.Generators;
import com.greenjourneys.entities.User;
import com.greenjourneys.services.MailService;
import com.greenjourneys.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/UserController")
@Controller
public class PasswordController {
    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @PostMapping("/reset")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        String email = resetPasswordRequest.getEmail();
        User user = userService.getUserByEmail(email);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        String token = "token-" + Generators.nameBasedGenerator().generate(email);
        userService.updateResetPasswordToken(token, email);
        mailService.sendResetPasswordEmail(email, token);

        return ResponseEntity.ok().build();
    }

    /*@PostMapping("/update")
  public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
      String token = updatePasswordRequest.getToken();
      String newPassword = updatePasswordRequest.getNewPassword();
      User user = userService.getUserByResetPasswordToken(token);
      if (user == null) {
          return ResponseEntity.badRequest().build();
      }

      userService.updatePassword(user, newPassword);

      return ResponseEntity.ok().build();
  }  */
 /* @PostMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        User user = userService.getUserByResetPasswordToken(updatePasswordRequest.getToken());
        if (user == null) {
            // handle null user error by returning an appropriate error response to the client
            return ResponseEntity.badRequest().body("User not found with reset password token " + updatePasswordRequest.getToken());
        }
      // update user's password
        userService.updatePassword(user, updatePasswordRequest.getNewPassword());
        return ResponseEntity.ok("Password updated successfully");
    }*/


    // DTOs

    public static class ResetPasswordRequest {
        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class UpdatePasswordRequest {
        private String token;
        private String newPassword;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }
    @PostMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestParam("token") String token,
                                            @RequestParam("email") String email,
                                            @RequestParam("password") String password,
                                            @RequestParam("newPassword") String newPassword) {
        User user = userService.getUserByResetPasswordToken(token);
        if (user == null) {
            // handle null user error by returning an appropriate error response to the client
            return ResponseEntity.badRequest().body("User not found with reset password token " + token);
        }
        if (!user.getEmail().equals(email)) {
            // handle email mismatch error by returning an appropriate error response to the client
            return ResponseEntity.badRequest().body("Email does not match user email");
        }
        if (!userService.checkPassword(user, password)) {
            // handle incorrect password error by returning an appropriate error response to the client
            return ResponseEntity.badRequest().body("Incorrect password");
        }
        // update user's password
        userService.updatePassword(user, newPassword);
        return ResponseEntity.ok("Password updated successfully");
    }

}
