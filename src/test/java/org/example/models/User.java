package org.example.models;

import lombok.Builder;
import lombok.Data;
import org.example.enums.Gender;

@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String country;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String phone;
    private String password;
    private String passwordConfirmation;

}
