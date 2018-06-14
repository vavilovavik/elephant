package com.webapp.elephant.model.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_address")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @Column(name = "user_id")
    private long userId;

    private String region;
    private String city;
    private String street;
    private String build;
    private String appartment;
    private String index;
    private Date created;

    public UserAddress() {};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
