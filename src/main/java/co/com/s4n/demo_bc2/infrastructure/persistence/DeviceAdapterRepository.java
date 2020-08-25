package co.com.s4n.demo_bc2.infrastructure.persistence;

import co.com.s4n.demo_bc2.domain.entities.devices.Device;
import co.com.s4n.demo_bc2.domain.repositories.DeviceRepository;
import org.springframework.stereotype.Component;

@Component
public class DeviceAdapterRepository implements DeviceRepository {

    @Override
    public Device save(Device device) {
        //DeviceJpaEntity deviceJpaEntity = DeviceBuilder.fromDomain(device);
        //deviceJpaRepository.save(deviceJpaEntity);
        return device;
    }
}
