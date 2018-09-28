package rnd.m2hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rnd.m2hub.ws.rs.AppConfig;

@SpringBootApplication
public class App {

    public static void main( String[] args ) {
        
        SpringApplication.run(new Object[] { AppConfig.class, App.class }, args);
        
    }

}