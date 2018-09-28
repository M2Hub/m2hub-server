package rnd.m2hub.ws.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rnd.m2hub.utils.WorkspaceHelper;

@Path("/ws")
public class WorkspaceResource {
    
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/")
	public String getProjectList() throws Exception {
	    return WorkspaceHelper.getProjectList();
	}
	
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{project}")
	public String getProjectObjectModel(@PathParam("project") String project) throws Exception {
	    return WorkspaceHelper.getProjectObjectModel(project);
	}
	
}