package rnd.mavenhub.utils;

import java.io.File;
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
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

public class MavenHelper {
    
    static {
        System.setProperty("maven.multiModuleProjectDirectory", ".");
    }
    
    private static MavenCli CLI = new MavenCli();
    
    public static String runMavenCli(String options) {
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        
        int result = CLI.doMain(
                        new String[] { options.trim() }, //
                        ".", //
                        ps, ps);
        //if(result != 0) {
            //throw new RuntimeException("MavenCli exited abnormally");
        //} else {
            return baos.toString();
        //}
    }
    
    public static void main(String[] args) throws MavenInvocationException {
        //System.out.print(runMavenCli(" -v "));
                 
        Invoker invoker = new DefaultInvoker();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InvocationOutputHandler ioh = new PrintStreamHandler(new PrintStream(baos), false);
        
        invoker.setOutputHandler(ioh);
        invoker.setErrorHandler(ioh);

        InvocationRequest request = new DefaultInvocationRequest();
        //request.setPomFile( new File( "/path/to/pom.xml" ) );
        request.setGoals( Collections.singletonList( "--version" ) );
        
        invoker.execute( request );
        
        System.out.println(baos.toString());
    }
    
}
