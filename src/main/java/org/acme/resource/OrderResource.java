//package org.acme.resource;
//
//import org.acme.entity.Order;
//import org.acme.repository.OrderRepository;
//
//import javax.inject.Inject;
//import javax.transaction.Transactional;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.net.URI;
//import java.util.List;
//
//@Path("order")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class OrderResource {
//
//    @Inject
//    OrderRepository orderRepository;
//
//    @GET
//    public List<Order> list() {
//        return orderRepository.listAll();
//    }
//
//    @GET
//    @Path("/{id}")
//    public Order get(Long id) {
//        return orderRepository.findById(id);
//    }
//
//    @POST
//    @Transactional
//    public Response create(Order Order) {
//        orderRepository.persist(Order);
//        return Response.created(URI.create("/Orders/")).build();
//    }
//}
