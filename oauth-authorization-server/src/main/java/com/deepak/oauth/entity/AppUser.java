package com.deepak.oauth.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUser {
    private Long id;
    private String userName;
    private String password;
    private String email;
}
