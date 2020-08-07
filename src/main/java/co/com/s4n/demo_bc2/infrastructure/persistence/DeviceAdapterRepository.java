package co.com.s4n.demo_bc2.infrastructure.persistence;

import co.com.s4n.demo_bc2.domain.entities.devices.Device;
import co.com.s4n.demo_bc2.domain.repositories.DeviceRepository;
import co.com.s4n.demo_bc2.infrastructure.acl.builders.DeviceBuilder;
import co.com.s4n.demo_bc2.infrastructure.persistence.records.DeviceJpaEntity;
import co.com.s4n.demo_bc2.infrastructure.persistence.repositories.DeviceJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceAdapterRepository implements DeviceRepository {

    private final DeviceJpaRepository deviceJpaRepository;

    @Autowired
    public DeviceAdapterRepository(DeviceJpaRepository deviceJpaRepository) {
        this.deviceJpaRepository = deviceJpaRepository;
    }

    @Override
    public Device save(Device device) {
        DeviceJpaEntity deviceJpaEntity = DeviceBuilder.fromDomain(device);
        deviceJpaRepository.save(deviceJpaEntity);
        return device;
    }
}
