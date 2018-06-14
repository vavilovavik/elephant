package com.webapp.elephant.model.entities;

import com.webapp.elephant.model.enums.ArticleType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "article")
public class Article implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private long id;

    @NotNull
    private String name;
    @NotNull
    private String description;

    @Enumerated(EnumType.STRING)
    private ArticleType type;
    private byte visible;
    private Date created;
    private Date updated;

    public Article() {}

    public long getId() {
        return id;
    }
}
