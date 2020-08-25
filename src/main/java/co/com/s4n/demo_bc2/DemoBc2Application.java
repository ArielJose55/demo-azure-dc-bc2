package co.com.s4n.demo_bc2;

import org.mitre.springboot.config.annotation.EnableOpenIDConnectServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableOpenIDConnectServer
@ComponentScan(basePackages = "org.mitre.springboot.config")
public class DemoBc2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoBc2Application.class, args);
	}

}
