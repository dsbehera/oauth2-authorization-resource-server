package com.deepak.resource.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppUser {
    private Long id;
    private String userName;
    private String email;

}
