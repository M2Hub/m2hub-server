package rnd.mavenhub.ws.rs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rnd.mavenhub.utils.MavenHelper;


@Path("/mvn")
public class MavenResource {
    
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/version")
	public void getVersion() throws Exception {
	    MavenHelper.runMavenCli(" -v ");
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{options}")
	public void run(@PathParam("options") String options) throws Exception {
	    MavenHelper.runMavenCli(options);
	}
	
}