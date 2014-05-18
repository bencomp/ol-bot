package name.companjen.ben.olbot;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.junit.*;

import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Integration test for the AuthorProcessor
 */
public class AuthorProcessorIT {

    private static String endpointUrl;

    @BeforeClass
    public static void beforeClass() {
        endpointUrl = System.getProperty("service.url");
    }


    @Test
    public void testProcess() throws Exception {
        List<Object> providers = new ArrayList<Object>();
        providers.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());
        Author au = new Author();
        au.setName("Ben Companjen");
        au.setRevision(1);
        au.setKey("/authors/OL1A");
        System.out.println(endpointUrl + "/olbot/authorname");
        WebClient client = WebClient.create(endpointUrl + "/olbot/authorname", providers);
        Response r = client.accept("application/json")
                .type("application/json")
                .post(au);
        assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
        MappingJsonFactory factory = new MappingJsonFactory();
        JsonParser parser = factory.createJsonParser((InputStream)r.getEntity());
        Author output = parser.readValueAs(Author.class);
        assertEquals("Ben_Companjen", output.getName());
    }

    @Test
    public void testProcessFile() throws Exception {
        List<Object> providers = new ArrayList<Object>();
        providers.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());
        Author au = new Author();
        au.setName("Ben Companjen");
        au.setRevision(1);
        au.setKey("/authors/OL1A");
        System.out.println(endpointUrl + "/olbot/authorname");
        WebClient client = WebClient.create(endpointUrl + "/olbot/authorname", providers);
        Response r = client.accept("application/json")
                .type("application/json")
                .post(au);
        assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
        MappingJsonFactory factory = new MappingJsonFactory();
        JsonParser parser = factory.createJsonParser((InputStream)r.getEntity());
        Author output = parser.readValueAs(Author.class);
        assertEquals("Ben_Companjen", output.getName());
    }
}