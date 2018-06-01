package rnd.mavenhub.utils;

import java.io.File;

public class WorkspaceHelper {
    
    public static String getProjectList() {
	    
        String workspace = "[ { \"id\" : 1, \"text\" : \"Workspace\", \"children\" : [ ";

        String workDir = "./user/workspace/";
	    File ws = new File(workDir);
	    
	    if(ws.exists()) {
	        int projectCount = ws.list().length;
    	    for (int i = 0; i < projectCount; i++) {
                String projectName = ws.list()[i];
                workspace += "{ \"id\" : " + (i+2) +", \"text\" : \""+ projectName + "\" }";
                if(i < projectCount -1 ) {
                    workspace += ", ";
                }
            }
        }
        workspace += " ] } ]";
	    return workspace;
	}
	
	public static void main(String[] args) {

        System.out.println(getProjectList());

    }
    
}
