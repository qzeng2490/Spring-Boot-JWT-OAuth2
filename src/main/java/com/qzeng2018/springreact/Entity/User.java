package com.qzeng2018.springreact.Entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_User")
public class User implements Serializable {
    private static final long serialVersionUID = -649996051252965245L;

    @Id
    @GenericGenerator(name = "uid", strategy = "uuid2")
    @GeneratedValue(generator = "uid")
    private String id;
    private String username;    //用户名

    private String password;

    public User(){

    }

    public User(String usr,String pwd) {
        this.username = usr;
        this.password = pwd;
        this.roles = new HashSet<Role>();
    }

    @Column
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_user_role",
            joinColumns = @JoinColumn(name = "userId",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId",
                    referencedColumnName = "id"))
    private Set<Role> roles;
}
