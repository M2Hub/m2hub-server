package rnd.m2hub.ws.rs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rnd.m2hub.utils.CommandHelper;

@Path("/cmd")
public class CommandResource {
    
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{cmd}")
	public String getHelp(@PathParam("cmd") String cmd) throws Exception {
	    return CommandHelper.execCmd(cmd + " --help");
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{cmd}")
	public String execute(@PathParam("cmd") String cmd) throws Exception {
	    return CommandHelper.execCmd(cmd);
	}
}