package rnd.mavenhub.ws.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rnd.mavenhub.utils.WorkspaceHelper;

@Path("/ws")
public class WorkspaceResource {
    
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/")
	public String getProjectList() throws Exception {
	    return WorkspaceHelper.getProjectList();
	}
	
}