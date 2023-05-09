package com.greenjourneys.security;

import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

public class AuthenticationResponse  implements Serializable {
    private final String jwt;
    private final UserDetails userDetails;

    public AuthenticationResponse(String jwt, UserDetails userDetails) {
        this.jwt = jwt;
        this.userDetails = userDetails;
    }

    public String getJwt() {
        return jwt;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }
}
