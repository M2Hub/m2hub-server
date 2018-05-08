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
	public String getVersion() throws Exception {
	    return MavenHelper.runMavenCli("-v");
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{option}")
	public String runOption(@PathParam("option") String option) throws Exception {
	    return MavenHelper.runMavenCli("-" + option);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{option}/{goal}")
	public String runGoal(@PathParam("option") String option, @PathParam("goal") String goal) throws Exception {
	    return MavenHelper.runMavenCli("-"+ option + " " + goal);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{option}/{goal}/{phase}")
	public String runPhase(@PathParam("option") String option, @PathParam("goal") String goal, @PathParam("phase") String phase) throws Exception {
	    return MavenHelper.runMavenCli("-"+ option + " " + goal + " " + phase);
	}
	
}