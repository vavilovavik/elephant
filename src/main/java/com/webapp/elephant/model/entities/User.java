package com.webapp.elephant.model.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String password;

    @Column(name = "session_key")
    private String sessionKey;

    private String phone;

    @Column(name = "personal_agree")
    private byte personalAgree;

    private byte admin;
    private Date created;
    private Date updated;

    public User() {};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
