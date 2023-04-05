package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Notify extends PanacheEntity {


    public String title;

    public String sourceCode;

    public String remark;
}
