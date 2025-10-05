package com.scm20.scm22.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserForms {

    @NotBlank(message = "Username is Required")
    @Size(min = 3,message = "Min 3 characters is Required")
    private String name;

    @NotBlank(message = "Email is Required")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(min = 6,message = "Min 6 characters is required")
    private String password;

    @NotBlank(message = "About is Required")
    private String about;

    @NotBlank(message = "Phone Number is Required")
    @Size(min = 9,max = 12,message = "Invalid Phone Number")
    private String phoneNumber;
}
