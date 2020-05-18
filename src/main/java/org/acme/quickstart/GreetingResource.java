package org.acme.quickstart;

import org.acme.quickstart.interceptor.ServiceMethodLog;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
@ServiceMethodLog
public class GreetingResource {

    @Inject
    GreetingServiceImpl greetingService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.sayHello("hello");
    }

    @GET
    @Path("/helloo")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloo() {
        return "helloo";
    }
}