package rnd.m2hub.utils;

import java.io.File;
import java.io.PrintStream;

import org.apache.maven.cli.MavenCli;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

public class MavenHelper {
    
    static {
        System.setProperty("maven.multiModuleProjectDirectory", ".");
    }
    
    public static String execMavenCli(String projectName, String[] args) {

        MavenCli CLI = new MavenCli();
        //MavenHubCli CLI = new MavenHubCli();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);

        String workspaceDir = "/home/user/workspace";
        //String workspaceDir = "./user/workspace";

        String projectDir = workspaceDir;
        if(projectName !=null ) {
            projectDir = workspaceDir + File.separator + projectName;
        }
        
        int result = CLI.doMain(args, projectDir, ps, ps);
        //if(result != 0) {
            //throw new RuntimeException("MavenCli exited abnormally");
        //} else {
            return baos.toString();
        //}
    }
    
//    public static String execMavenInvoker(String args) {
//        
//        Invoker invoker = new DefaultInvoker();
//        
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        InvocationOutputHandler ioh = new PrintStreamHandler(new PrintStream(baos), false);
//        
//        invoker.setOutputHandler(ioh);
//        invoker.setErrorHandler(ioh);
//
//        InvocationRequest request = new DefaultInvocationRequest();
//        //request.setPomFile( new File( "/path/to/pom.xml" ) );
//        request.setGoals( Collections.singletonList( args ) );
//        
//        try {
//            invoker.execute( request );
//        } catch (MavenInvocationException e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
//        
//        return baos.toString();
//    }
    
//    public static String execMavenWrapper(String args) {
//        try {
//            MavenWrapperMain.main(new String[]{ args });
//        } catch (Exception e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
//        
//        return "Maven Executed";
//    }

    public static String execMaven(String option) {
        return execMavenCli(null, new String[] { option });
    }

    public static String execMaven(String projectName, String[] args) {
        return execMavenCli(projectName, args);
    }
    
    public static void main(String[] args) {
        
        System.out.println(execMaven(null, new String[] {
            "archetype:generate", //
            "-B", //
            "-DarchetypeGroupId=org.apache.maven.archetypes", //
            "-DarchetypeArtifactId=maven-archetype-webapp", //
            "-DarchetypeVersion=1.3",//
            "-DgroupId=rnd", //
            "-DartifactId=MyWebApp", //
            "-Dversion=1.0.0" //
        }));
        
        System.out.println(WorkspaceHelper.getProjectObjectModel("MyWebApp"));
        
        //System.out.println(execMaven("MyWebApp", new String[]{ "clean" }));
        
        //System.out.println(execMaven("MyWebApp", new String[]{ "compile" }));
        
        //System.out.println(execMaven("MyWebApp", new String[]{ "install" }));

    }
    
}