package com.bekirdogan.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@Log4j2


@Entity
@Table(name="employees")
public class EmployeeEntity extends BaseEntity implements Serializable {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String LastName;

    @Column(name="email_name")
    private String emailId;

    public EmployeeEntity(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.LastName = lastName;
        this.emailId = emailId;
    }
}
