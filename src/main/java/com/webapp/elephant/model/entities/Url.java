package com.webapp.elephant.model.entities;

import com.webapp.elephant.model.enums.UrlType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    private UrlType type;
    private String url;
    private Date created;

    public Url() {};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
