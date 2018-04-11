package com.qzeng2018.springreact.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tbl_Employee")
public class Employee {

    @Id
    @GenericGenerator(name = "uid", strategy = "uuid2")
    @GeneratedValue(generator = "uid")
    String id;
    private String firstName;
    private String lastName;
    private String description;

    public Employee() {}

    public Employee(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }
}
