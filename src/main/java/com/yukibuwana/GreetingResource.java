package com.yukibuwana;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/")
public class GreetingResource {

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello...";
    }

    @GET
    @Path("greeting/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting(@PathParam String name) {
        return "Hi " + name;
    }
}