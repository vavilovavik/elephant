package com.webapp.elephant.model.entities;

import com.webapp.elephant.model.enums.TagType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    private String name;

    @Column(name = "filter_url")
    private String filterUrl;

    private TagType type;
    private Date created;
    private Date updated;

    public Tag() {};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(TagType type) {
        this.type = type;
    }
}
