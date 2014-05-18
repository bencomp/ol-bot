package name.companjen.ben.olbot;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract integration test that instantiates some objects used by all integration tests.
 * @author Ben Companjen
 * @since 18-5-2014
 */
public abstract class AbstractIT {

    protected static String endpointUrl;

    protected static List<Object> providers;
    protected static MappingJsonFactory factory;

    /**
     * The WebClient is instantiated in each IT to reach a specific endpoint.
     */
    protected WebClient webClient;


    /**
     * Setup before executing the integration test(s).
     * Get the service URL from the Maven configuration.
     */
    @BeforeClass
    public static void beforeClass() {
        endpointUrl = System.getProperty("service.url");
        providers = new ArrayList<Object>();
        providers.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());
        factory = new MappingJsonFactory();
    }
}
