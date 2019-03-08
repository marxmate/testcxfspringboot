package server.api;

import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;
import model.Test;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TestResource {

    @GET
    @Path("/getTest")
    Test getTestObject(@QueryParam("name") String name, @QueryParam("age") int age);

    @POST
    @Path("/create")
    Test createTest(JsonInput input);

    @GET
    @Path("/name/{name}")
    Test getTestByPathParam(@PathParam("name") String name);
}
