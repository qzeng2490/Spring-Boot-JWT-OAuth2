package com.qzeng2018.springreact.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = -718017459899309493L;

    @Id
    @GenericGenerator(name = "uid", strategy = "uuid2")
    @GeneratedValue(generator = "uid")
    private String id;

    private String name;    //角色名称
}
