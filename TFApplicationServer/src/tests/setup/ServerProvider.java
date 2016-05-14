package test.setup;

import com.sun.jersey.api.container.tomcat.TomcatServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

import main.models.SearchModel;

public class ServerProvider {

    private final URI BASE_URI = getBaseURI();
    private HttpServer server;

    protected URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(9998).build();
    }

    public void createServer() throws IOException {
        System.out.println("Starting tomcat...");

        // [TODO] Insert setup for tomcat here 
        // server = TomcatServerFactory.createHttpServer(BASE_URI + "rest/");

        System.out.println(String.format("Jersey app started with the application available at ",
                BASE_URI, BASE_URI));
    }

    public void stop() {
        server.stop();
    }
}
