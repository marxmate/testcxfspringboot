package server.api;

import model.Test;
import org.apache.cxf.security.claims.authorization.Claim;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TestResource {

    @GET
    @Path("/getTest")
    @Claim("admin")
    Test getTestObject(@QueryParam("name") String name, @QueryParam("int") int integerSmall);
}
