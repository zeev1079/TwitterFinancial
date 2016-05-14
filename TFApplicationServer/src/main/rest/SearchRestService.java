package main.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import main.objects.search;
import main.interfaces.SearchService;

@Path("/search")
public class SearchRestService {

    private final SearchService searchService;

    public SearchRestService(SearchService searchService) {
        this.searchService = searchService;
    }

    @GET
    @Path("requestIPCount")
    @Produces(MediaType.APPLICATION_JSON)
    public int requestIPCount() {
        return searchService.requestIPCount();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> getAllCompanyFavoriates() {
        return searchService.getAllCompanyFavoriates();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") int id) {
        return searchService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(User user) {
        return searchService.createNewUser(user);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(User user) {
        return searchService.update(user);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id) {
        searchService.remove(id);
    }
}
