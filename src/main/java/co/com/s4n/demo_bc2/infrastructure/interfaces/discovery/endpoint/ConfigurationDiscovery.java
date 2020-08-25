package co.com.s4n.demo_bc2.infrastructure.interfaces.discovery.endpoint;

import org.mitre.discovery.web.DiscoveryEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"org.mitre.springboot.config"})
public class ConfigurationDiscovery {

    @Autowired
    DiscoveryEndpoint discoveryEndpoint;
}
