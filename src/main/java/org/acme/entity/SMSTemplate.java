package org.acme.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "sms_template")
@Entity
public class SMSTemplate extends Template{

    public String templateCode;

    public String data;
}
