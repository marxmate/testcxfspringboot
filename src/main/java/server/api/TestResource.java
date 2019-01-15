package server.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import model.Test;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import static server.api.config.SwaggerConfig.BEARER_AUTH;

@SecurityRequirement(name = BEARER_AUTH)
@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TestResource {

    @GET
    @Path("/getTest")
    Test getTestObject(@QueryParam("name") String name, @QueryParam("int") int integerSmall);
}
