package rnd.m2hub.utils;

import java.io.File;

public class WorkspaceHelper {
    
    public static String getProjectList() {
	    
        String workspace = "[ { \"id\" : 1, \"text\" : \"Workspace\", \"children\" : [ ";
        
        File ws = new File(MavenHelper.WORKSPACE_DIR);
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
	
	
	public static String getProjectObjectModel(String project) {
	    System.out.println("WorkspaceHelper.getProjectObjectModel.projet: " + project);
	    
	    String pomFile = MavenHelper.WORKSPACE_DIR + File.separator + project + File.separator + "pom.xml";
	    System.out.println("WorkspaceHelper.getProjectObjectModel.pomFile: " + pomFile);
	    return FileHelper.readFile(pomFile);
	}
	
	public static void main(String[] args) {
	    
        //System.out.println(getProjectList());

    }
    
}
