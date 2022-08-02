package org.example;

import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/logging")
public class ExampleResource {

    Logger logger= Logger.getLogger(ExampleResource.class);
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        logger.debug("hola");
        return "1";
    }
}