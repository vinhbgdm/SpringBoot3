package com.example.springboot3.dto.response;

import com.example.springboot3.enums.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
public class UserDetailResponse implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Date dateOfBirth;
    private Gender gender;
    private String username;
    private UserType type;
    private UserStatus status;

    public UserDetailResponse(Long id, String firstName, String lastName, String phone, String email, Date dateOfBirth, Gender gender, String username, UserType type, UserStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.username = username;
        this.type = type;
        this.status = status;
    }
}
