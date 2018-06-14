package com.webapp.elephant.model.entities;

import com.webapp.elephant.model.enums.ImageType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "image")
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @NotNull
    private long eid;

    @Enumerated(EnumType.STRING)
    private ImageType type;

    private String path;
    private Date created;
    private Date updated;

    public Image () {}

    public long getId() {
        return id;
    }
}
