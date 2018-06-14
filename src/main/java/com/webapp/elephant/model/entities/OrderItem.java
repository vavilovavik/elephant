package com.webapp.elephant.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @NotNull
    @Column(name = "order_id")
    private long orderId;

    @NotNull
    @Column(name = "item_id")
    private long itemId;

    private float price;
    private byte amount;
    private Date created;
    private Date updated;

    public OrderItem() {}

    public long getId() {
        return id;
    }
}
