package com.bekirdogan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;

    @NotEmpty(message = "Name and surname is mandatory field.")
    @Size(min=1, max=255)
    private String teacherNameSurname;

    @NotEmpty(message = "Email is mandatory field.")
    @Email(message = "It is not valid email")
    private String teacherEmail;

    @NotEmpty(message = "Password is mandatory field.")
    @Min(value=18, message = "Minimum value must be grater than 18")
    @Min(value=18, message = "Maximum value must be smaller than 18")
    private String teacherPassword;

}
