package rnd.m2hub.ws.rs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import rnd.m2hub.utils.MavenHelper;


@Path("/mvn")
public class MavenResource {
    
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/h")
	public String getHelp() throws Exception {
	    return MavenHelper.execMaven("-h");
	}
	
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/help")
	public String getFullHelp() throws Exception {
	    return MavenHelper.execMaven("--help");
	}
	
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/v")
	public String getVersion() throws Exception {
	    return MavenHelper.execMaven("-v");
	}
	
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/version")
	public String getFullVersion() throws Exception {
	    return MavenHelper.execMaven("--version");
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/-{option}")
	public String runOption(@PathParam("option") String option) throws Exception {
	    return MavenHelper.execMaven("-" + option);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/--{option}")
	public String runFullOption(@PathParam("option") String option) throws Exception {
	    return MavenHelper.execMaven("--" + option);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{goal}")
	public String runGoal(@PathParam("goal") String goal, @FormParam("artifactId") String artifactId) throws Exception {
	    return MavenHelper.execMaven(artifactId, new String[] { goal });
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/-{option}/{goal}")
	public String runOptionGoal(@PathParam("option") String option, @PathParam("goal") String goal, @FormParam("artifactId") String artifactId) throws Exception {
	    return MavenHelper.execMaven(artifactId, new String[] { "-"+ option, goal });
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/--{option}/{goal}")
	public String runFullOptionGoal(@PathParam("option") String option, @PathParam("goal") String goal, @FormParam("artifactId") String artifactId) throws Exception {
	    return MavenHelper.execMaven(artifactId, new String[] { "--"+ option, goal });
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{goal}/{phase}")
	public String runGoalPhase(@PathParam("goal") String goal, @PathParam("phase") String phase, @FormParam("artifactId") String artifactId) throws Exception {
	    return MavenHelper.execMaven(artifactId, new String[]{ goal + ":" + phase });
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/-{option}/{goal}/{phase}")
	public String runOptionGoalPhase(@PathParam("option") String option, @PathParam("goal") String goal, @PathParam("phase") String phase, MultivaluedMap<String, String> formParams) throws Exception {
	    
	    final List params = new ArrayList();
	    
	    params.add("-"+ option);
	    params.add(goal + ":" + phase);
	    
	    Iterator iter = formParams.entrySet().iterator();
	    while(iter.hasNext()) {
	        
	        Entry e = (Entry) iter.next();
	        String key = (String) e.getKey();
	        List values = (List) e.getValue();
	        
	        params.add("-D"+key + "=" + values.get(0));
	    }
	    
	    // TODO Add artificat support
	    return MavenHelper.execMaven(null, (String[]) params.toArray(new String[0]));
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/--{option}/{goal}/{phase}")
	public String runFullOption_Goal_Phase(@PathParam("option") String option, @PathParam("goal") String goal, @PathParam("phase") String phase) throws Exception {
	    // TODO Add artificat support
	    return MavenHelper.execMaven(null, new String[] { "--"+ option, goal + ":" + phase });
	}

	
}