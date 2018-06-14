package com.webapp.elephant.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "session_key")
    private String sessionKey;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private float price;

    @Column(name = "user_address_id")
    private long userAddressId;

    private String coupon;

    @Column(name = "tracking_number")
    private String trackingNumber;

    private String address;
    private String phone;
    private Date created;
    private Date updated;

    public Order() {}

    public long getId() {
        return id;
    };
}
