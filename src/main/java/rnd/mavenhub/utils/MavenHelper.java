package rnd.mavenhub.utils;

import org.apache.maven.cli.MavenCli;

public class MavenHelper {
    
    static {
        System.setProperty("maven.multiModuleProjectDirectory", ".");
    }

    
    private static MavenCli CLI = new MavenCli();

    
    public static void runMavenCli(String options) {
        
        int result = CLI.doMain(
                        new String[] { options }, //
                        ".", //
                        System.out, System.err);
        if(result != 0) {
            throw new RuntimeException("MavenCli exited abnormally");
        }

    }
}
