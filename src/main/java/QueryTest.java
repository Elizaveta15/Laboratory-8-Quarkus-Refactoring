import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Path("/animal")
public class QueryTest {

    public QueryTest() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "About animals";
    }
}
