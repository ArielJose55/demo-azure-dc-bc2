package co.com.s4n.demo_bc2.infrastructure.acl.boot;

import co.com.s4n.demo_bc2.domain.repositories.DeviceRepository;
import co.com.s4n.demo_bc2.domain.services.DeviceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartServiceBean {

    @Bean
    public DeviceService beanDeviceService(DeviceRepository deviceRepository) {
        return new DeviceService(deviceRepository);
    }
}
