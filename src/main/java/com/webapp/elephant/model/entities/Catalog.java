package com.webapp.elephant.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "catalog")
public class Catalog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @NotNull
    private String name;

    private String description;
    private byte visible;
    private Date created;
    private Date updated;

    public Catalog() {}

    public long getId() {
        return id;
    }
}
