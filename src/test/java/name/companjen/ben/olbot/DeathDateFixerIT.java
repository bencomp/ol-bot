package name.companjen.ben.olbot;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class DeathDateFixerIT extends AbstractIT {

    @Before
    public void setUp() {
        webClient = WebClient.create(endpointUrl + "/olbot/deathdate", providers);

    }

    @Test
    public void testProcess() throws Exception {
        Author au = new Author();
        au.setDeathDate("2014.");
        au.setRevision(1);
        au.setKey("/authors/OL1A");
        Response r = webClient.accept("application/json")
                .type("application/json")
                .post(au);
        assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
        MappingJsonFactory factory = new MappingJsonFactory();
        JsonParser parser = factory.createJsonParser((InputStream)r.getEntity());
        Author output = parser.readValueAs(Author.class);
        assertEquals("2014", output.getDeathDate());
    }
}