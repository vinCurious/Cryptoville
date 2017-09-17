package webHandler;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class WebServerRestAPIConfiguration extends ResourceConfig {
	
	public WebServerRestAPIConfiguration() {
		register(RequestContextFilter.class);
		packages("webhandler");
		register(WebHandler.class);
	}
	
}
