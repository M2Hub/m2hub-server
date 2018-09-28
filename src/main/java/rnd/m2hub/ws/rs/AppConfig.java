package rnd.m2hub.ws.rs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		register(MavenResource.class);
		register(CommandResource.class);
		register(WorkspaceResource.class);
	}
}