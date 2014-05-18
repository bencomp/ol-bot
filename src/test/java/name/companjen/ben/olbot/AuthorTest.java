package name.companjen.ben.olbot;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthorTest {
    private static String testFile = "/author1.json";



    @Test
    public void testProcess() throws Exception {
        List<Object> providers = new ArrayList<Object>();
        providers.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());
        MappingJsonFactory factory = new MappingJsonFactory();
        JsonParser parser = factory.createJsonParser((InputStream) getClass().getResourceAsStream(testFile));
        Author output = parser.readValueAs(Author.class);
        assertEquals("M. A. Padlipsky", output.getName());
    }
}