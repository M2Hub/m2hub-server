package rnd.m2hub.cli;

import org.apache.maven.cli.MavenCli;
import org.apache.maven.repository.RepositorySystem;
import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.codehaus.plexus.PlexusContainer;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.spi.locator.ServiceLocator;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class M2HubCli extends MavenCli {
    
    private static Logger log = LoggerFactory.getLogger(M2HubCli.class);
    
    @Override
    protected void customizeContainer(PlexusContainer container) {

        ServiceLocator serviceLocator = MavenRepositorySystemUtils.newServiceLocator() //
            .addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class) //
            .addService(TransporterFactory.class, FileTransporterFactory.class) //
            .addService(TransporterFactory.class, HttpTransporterFactory.class);

        RepositorySystem rs = serviceLocator.getService(RepositorySystem.class);
        System.out.println("RepoSys : " + rs);
        log.info("RepoSys : " + rs);
        
        container.addComponent(rs, RepositorySystem.class, "default");

        //container.addComponent(serviceLocator.lookup(RemoteRepositoryManager.class), RemoteRepositoryManager.class, "default");
        
    }
    
}
