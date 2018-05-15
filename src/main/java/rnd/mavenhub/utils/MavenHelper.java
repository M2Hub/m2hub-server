package rnd.mavenhub.utils;

import java.io.PrintStream;
import java.util.Collections;

import org.apache.maven.cli.MavenCli;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationOutputHandler;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.apache.maven.shared.invoker.PrintStreamHandler;
import org.apache.maven.wrapper.MavenWrapperMain;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import rnd.mavenhub.cli.MavenHubCli;

public class MavenHelper {
    
    static {
        System.setProperty("maven.multiModuleProjectDirectory", ".");
    }
    
    public static String execMavenCli(String args) {

        //MavenCli CLI = new MavenCli();
        MavenHubCli CLI = new MavenHubCli();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        
        int result = CLI.doMain(
                        new String[] { args.trim() }, //
                        ".", //
                        ps, ps);
        //if(result != 0) {
            //throw new RuntimeException("MavenCli exited abnormally");
        //} else {
            return baos.toString();
        //}
    }
    
    public static String execMavenInvoker(String args) {
        
        Invoker invoker = new DefaultInvoker();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InvocationOutputHandler ioh = new PrintStreamHandler(new PrintStream(baos), false);
        
        invoker.setOutputHandler(ioh);
        invoker.setErrorHandler(ioh);

        InvocationRequest request = new DefaultInvocationRequest();
        //request.setPomFile( new File( "/path/to/pom.xml" ) );
        request.setGoals( Collections.singletonList( args ) );
        
        try {
            invoker.execute( request );
        } catch (MavenInvocationException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        
        return baos.toString();
    }
    
    public static String execMavenWrapper(String args) {
        try {
            MavenWrapperMain.main(new String[]{ args });
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        
        return "Maven Executed";
        
    }
    
    public static String execMaven(String args) {
        return execMavenCli(args);
        //return execMavenInvoker(args);
        //return execMavenWrapper(args);
    }
    
    public static void main(String[] args) {
        System.out.println(execMaven("clean"));
    }
    
}
