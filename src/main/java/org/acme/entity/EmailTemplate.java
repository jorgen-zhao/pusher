package org.acme.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "email_template")
public class EmailTemplate extends Template{
    private String url;

    private String user;
}
