package rnd.m2hub.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
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
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    
    public static String readFile(String fileName) {
        System.out.println("FileHelper.readFile: " + fileName);
        InputStream is = FileHelper.class.getClassLoader().getResourceAsStream(fileName);
        System.out.println("FileHelper.readFile: ResourceNotFound, reading FileSystem");
        try {
            if(is == null) {
                is = new FileInputStream(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return readFile(is);
    }
    
    public static String readZipFile(String zipFileName) {
        System.out.println("FileHelper.readFile: " + zipFileName);
        try {
            URL zipUrl = FileHelper.class.getClassLoader().getResource(zipFileName);
            File zipFile = new File(zipUrl.toURI());
            ZipFile zip = new ZipFile(zipFile);
            InputStream is = zip.getInputStream(zip.entries().nextElement());
            String content = readFile(is);
            zip.close();
            return content;
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
