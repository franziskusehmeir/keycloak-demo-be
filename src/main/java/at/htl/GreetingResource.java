package at.htl;

import io.quarkus.security.Authenticated;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/hello-resteasy")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("user")
    @Authenticated
    public List<String> loggedInUsers() {
        return List.of("Christian", "David", "Donna");
    }

    @GET
    @Path("user/me")
    @RolesAllowed("admin")
    public String me(@Context SecurityContext sc) {
        return sc.getUserPrincipal().getName();
    }
}
