package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Notify;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotifyRepository implements PanacheRepository<Notify> {
}
