package tests;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import main.objects.Search;
import main.tests.setup.ClientProvider;
import main.tests.setup.ServerProvider;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class SearchRestTest {

    private final ServerProvider serverProvider;
    private final ClientProvider clientProvider;
    private WebResource webService;

    public SearchRestServiceTest() {
        serverProvider = new ServerProvider();
        clientProvider = new ClientProvider(serverProvider);
    }

    @Before
    public void startServer() throws IOException {
        serverProvider.createServer();
        webService = clientProvider.getWebResource();
    }

    @After
    public void stopServer() {
        serverProvider.stop();
    }


    @Test
    public void testSearchShouldReturnSearches() throws IOException {
        ClientResponse resp = webService.path("web").path("search")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        System.out.println("Got stuff: " + resp);

        assertEquals(200, resp.getStatus());
    }

}
