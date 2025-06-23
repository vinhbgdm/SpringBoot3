package com.example.springboot3.dto.response;

import com.example.springboot3.enums.Gender;
import com.example.springboot3.enums.UserStatus;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Builder
public class UserDetailResponse implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Date dateOfBirth;
    private Gender gender;
    private String username;
    private String type;
    private UserStatus status;
}
