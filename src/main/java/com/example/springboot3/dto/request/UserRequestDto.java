package com.example.springboot3.dto.request;

import com.example.springboot3.util.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class UserRequestDto implements Serializable {
    // Serializable dùng để chuyển đổi từ JSON sang byte nhị phân và ngược lại
    @NotBlank(message = "FirstName must be not blank")
    private String firstName;

    @NotNull(message = "LastName must be not null")
    private String lastName;

//    @Pattern(regexp = "^\\d{10}$", message = "Phone invalid format")
    @PhoneNumber
    private String phone;

    @Email(message = "Email invalid format")
    private String email;

    @NotNull(message = "dateOfBirth must be not null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @NotNull(message = "username must be not null")
    private String username;

    @NotNull(message = "password must be not null")
    private String password;

    @NotEmpty(message = "addresses can not empty")
    private Set<Address> addresses;

    public UserRequestDto(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    @Setter
    @Getter
    public static class Address {
        private String apartmentNumber;
        private String floor;
        private String building;
        private String streetNumber;
        private String street;
        private String city;
        private String country;
        private Integer addressType;
    }
}
