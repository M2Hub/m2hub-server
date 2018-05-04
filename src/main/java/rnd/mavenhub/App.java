package rnd.mavenhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rnd.mavenhub.ws.rs.AppConfig;

@SpringBootApplication
public class App {

    public static void main( String[] args ) {
        
        SpringApplication.run(new Object[] { AppConfig.class, App.class }, args);
        
    }

}