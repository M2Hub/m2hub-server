package rnd.mavenhub.utils;

import java.io.File;

public class WorkspaceHelper {
    
    public static String getProjectList() {
	    
        String workspace = "[{\"id\":1,\"text\":\"Workspace\",\"children\":[";

        String workDir = "./user/workspace/";
	    File ws = new File(workDir);
	    
	    if(ws.exists()) {
    	    for (int i = 0; i < ws.list().length; i++) {
                String projectName = ws.list()[i];
                workspace += "{\"id\" : " + (i+2) +", \"text\" : \""+ projectName + "\" },";
            }
        }
        workspace += "]}]";
	    return workspace;
	}
	
	public static void main(String[] args) {

        System.out.println(getProjectList());

    }
    
}
