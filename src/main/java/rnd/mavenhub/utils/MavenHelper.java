package rnd.mavenhub.utils;

import java.io.PrintStream;

import org.apache.maven.cli.MavenCli;
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
        if(result != 0) {
            throw new RuntimeException("MavenCli exited abnormally");
        } else {
            return baos.toString();
        }

    }
    
    public static void main(String[] args) {
        System.out.print(runMavenCli(" -v "));
    }
    
}
