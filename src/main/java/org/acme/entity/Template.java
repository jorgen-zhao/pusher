package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Template  {

    @Id
    @GeneratedValue
    public UUID uuid;

    public String content;

    public Boolean enabled;

    public Instant createTime;

    public Instant updateTime;

    public String createUser;

    public String updateUser;
}
