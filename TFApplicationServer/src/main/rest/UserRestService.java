package main.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import main.objects.User;
import main.interfaces.UserService;


@Path("/users")
public class UserRestService {

    private final UserService userService;

    public UserRestService(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User login(@PathParam("id") int id) {
        return userService.doLogin(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(User user) {
        return userService.doRegistration(user);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id) {
        userService.remove(id);
    }
}
