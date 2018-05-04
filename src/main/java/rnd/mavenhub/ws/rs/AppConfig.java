package rnd.mavenhub.ws.rs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		register(MavenResource.class);
	}
}