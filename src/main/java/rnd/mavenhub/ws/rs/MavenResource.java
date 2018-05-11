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
	@Path("/h")
	public String getHelp() throws Exception {
	    return MavenHelper.runMavenCli("-h");
	}
	
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/help")
	public String getFullHelp() throws Exception {
	    return MavenHelper.runMavenCli("--help");
	}
	
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/v")
	public String getVersion() throws Exception {
	    return MavenHelper.runMavenCli("-v");
	}
	
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/version")
	public String getFullVersion() throws Exception {
	    return MavenHelper.runMavenCli("--version");
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/-{option}")
	public String runOption(@PathParam("option") String option) throws Exception {
	    return MavenHelper.runMavenCli("-" + option);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/--{option}")
	public String runFullOption(@PathParam("option") String option) throws Exception {
	    return MavenHelper.runMavenCli("--" + option);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{goal}")
	public String runGoal(@PathParam("goal") String goal) throws Exception {
	    return MavenHelper.runMavenCli(goal);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/-{option}/{goal}")
	public String runOptionGoal(@PathParam("option") String option, @PathParam("goal") String goal) throws Exception {
	    return MavenHelper.runMavenCli("-"+ option + " " + goal);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/--{option}/{goal}")
	public String runFullOptionGoal(@PathParam("option") String option, @PathParam("goal") String goal) throws Exception {
	    return MavenHelper.runMavenCli("--"+ option + " " + goal);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{goal}/{phase}")
	public String runGoalPhase(@PathParam("goal") String goal, @PathParam("phase") String phase) throws Exception {
	    return MavenHelper.runMavenCli(goal + ":" + phase);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/-{option}/{goal}/{phase}")
	public String runOptionGoalPhase(@PathParam("option") String option, @PathParam("goal") String goal, @PathParam("phase") String phase) throws Exception {
	    return MavenHelper.runMavenCli("-"+ option + " " + goal + ":" + phase);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/--{option}/{goal}/{phase}")
	public String runFullOption_Goal_Phase(@PathParam("option") String option, @PathParam("goal") String goal, @PathParam("phase") String phase) throws Exception {
	    return MavenHelper.runMavenCli("--"+ option + " " + goal + ":" + phase);
	}

	
}