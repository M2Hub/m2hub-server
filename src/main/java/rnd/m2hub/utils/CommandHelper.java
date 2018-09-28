package rnd.m2hub.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CommandHelper {

    public static String execCmd(String cmd) throws Exception {
        Process p = Runtime.getRuntime().exec(cmd);
        return readIS(p.getInputStream()) + readIS(p.getErrorStream());
    }

    public static String readIS(InputStream is) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = "";
        StringBuilder result = new StringBuilder();
        while ((line = br.readLine()) != null) {
            result.append(line).append("\n");
        }
        
        return result.toString();

    }
    
    public static void main(String[] args) throws Exception {
        String result = execCmd("ls -ltr");
        System.out.print(result);
    }

}
