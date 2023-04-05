package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public Person findByName(String name){
        return find("name", name).firstResult();
    }

    public List<Person> findEnabled(){
        return list("status", "enabled");
    }

    public void deleteStefs(){
        delete("name", "Stef");
    }
}
