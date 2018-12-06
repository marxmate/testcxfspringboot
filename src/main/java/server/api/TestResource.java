package server.api;

import model.Test;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/rest")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TestResource {

    @GET
    @Path("/getTest")
    Test getTest(@QueryParam("name") String name, @QueryParam("int") int integerSmall);
}
