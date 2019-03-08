package server.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//TODO: @Path("/test"), @Produces(MediaType.APPLICATION_JSON), @Consumes(MediaType.APPLICATION_JSON)

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TestResource {

    //TODO: @GET, @Path("/getTestByPathParam"), Test getTestObject(@QueryParam("name") String name, @QueryParam("int") int integerSmall);

    //TODO: @POST, @Path("/create"), Test createTest(JsonInput input);

    //TODO: @GET, @Path("/name/{name}"), Test getTestByPathParam(@PathParam("name") String name);
}
