package rnd.mavenhub.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.zip.ZipFile;

public class FileHelper {

    public static String readFile(InputStream is) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = "";
        StringBuilder content = new StringBuilder(); 
        try {
            while((line = br.readLine()) != null) {
                content.append(line);
            }
            is.close();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public static String readFile(String fileName) {
        InputStream is = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        return readFile(is);
    }
    
    public static String readZipFile(String zipFileName) {
        try {
            URL zipUrl = FileHelper.class.getClassLoader().getResource(zipFileName);
            File zipFile = new File(zipUrl.toURI());
            ZipFile zip = new ZipFile(zipFile);
            InputStream is = zip.getInputStream(zip.entries().nextElement());
            return readFile(is);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(readFile("archetype-catalog.xml"));
        // System.out.println(readZipFile("archetype-catalog.zip"));
        
    }
    
    
    
}
