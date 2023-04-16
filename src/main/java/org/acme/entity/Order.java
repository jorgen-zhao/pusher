//package org.acme.entity;
//
//import lombok.Data;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class Order {
//
//    @Id
//    @GeneratedValue
//    Long id;
//
//    String name;
//
//    String time;
//
//    boolean status;
//
////    @ManyToOne(optional = false)
////    Person person;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
////    public Person getPerson() {
////        return person;
////    }
////
////    public void setPerson(Person person) {
////        this.person = person;
////    }
//}
