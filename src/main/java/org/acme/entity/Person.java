package org.acme.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String birth;
    String status;


//    @OneToMany(mappedBy = "person")
//    Set<Order> orderSet;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public Set<Order> getOrderSet() {
//        return orderSet;
//    }
//
//    public void setOrderSet(Set<Order> orderSet) {
//        this.orderSet = orderSet;
//    }
}