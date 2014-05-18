package name.companjen.ben.olbot;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Integration test for the AuthorProcessor
 */
public class AuthorProcessorIT extends AbstractIT {

    @Before
    public void setUp() {
        webClient = WebClient.create(endpointUrl + "/olbot/authorname", providers);

    }

    /**
     * Perform an integration test using a mock Author.
     * @throws Exception
     */
    @Test
    public void testProcess() throws Exception {
        Author au = new Author();
        au.setName("Ben Companjen");
        au.setRevision(1);
        au.setKey("/authors/OL1A");
        Response r = webClient.accept("application/json")
                .type("application/json")
                .post(au);
        assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
        MappingJsonFactory factory = new MappingJsonFactory();
        JsonParser parser = factory.createJsonParser((InputStream)r.getEntity());
        Author output = parser.readValueAs(Author.class);
        assertEquals("Ben_Companjen", output.getName());
    }

    /**
     * Test the processing of the author name using a sample record store in a file.
     * @throws Exception
     */
    @Test
    public void testProcessFile() throws Exception {
        String testFile = "/author1.json";
        JsonParser parser = factory.createJsonParser(getClass().getResourceAsStream(testFile));
        Author au = parser.readValueAs(Author.class);
        Response r = webClient.accept("application/json")
                .type("application/json")
                .post(au);
        assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
        parser = factory.createJsonParser((InputStream)r.getEntity());
        Author output = parser.readValueAs(Author.class);
        assertEquals("M._A._Padlipsky", output.getName());
    }
}