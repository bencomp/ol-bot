package name.companjen.ben.olbot;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Ben on 17-5-2014.
 */
@Path("olbot")
public class AuthorProcessor implements Processor<Author> {
    @Override
    @Path("authorname")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Author process(Author record) {
        String name = record.getName().replace(' ','_');
        record.setName(name);
        return record;
    }
}
