package com.webapp.elephant.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "session_key")
    private String sessionKey;

    private float price;
    private byte amount;
    private String coupon;
    private Date created;
    private Date updated;

    public Cart() {}

    public long getId() {
        return id;
    }
}
