package org.acme.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "wx_template")
@Entity
public class WXTemplate extends Template{

    public String path;

    public String templateId;

    public String data;

    public String page;


}
