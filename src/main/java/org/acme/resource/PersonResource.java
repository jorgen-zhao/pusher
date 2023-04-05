package org.acme.resource;

import org.acme.entity.Person;
import org.acme.repository.PersonRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    public List<Person> list() {
        return personRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Person get(Long id) {
        return personRepository.findById(id);
    }

    @POST
    @Transactional
    public Response create(Person person) {
        personRepository.persist(person);
        return Response.created(URI.create("/persons/" + person.getId())).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Person update(Long id, Person person) {
        Person entity = personRepository.findById(id);
//        Person entity = Person.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }

        // map all fields from the person parameter to the existing entity
        entity.setName(person.getName());
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(Long id) {
        Person entity = personRepository.findById(id);

        if (entity == null) {
            throw new NotFoundException();
        }
//        entity.delete();
        personRepository.deleteById(id);
    }

    @GET
    @Path("/search/{name}")
    public Person search(String name) {
        return personRepository.findByName(name);
//        return Person.findByName(name);

    }

    @GET
    @Path("/count")
    public Long count() {
        return personRepository.count();
//        return Person.count();
    }
}
