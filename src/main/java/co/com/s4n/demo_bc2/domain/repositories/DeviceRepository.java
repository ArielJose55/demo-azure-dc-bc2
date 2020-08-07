package co.com.s4n.demo_bc2.domain.repositories;

import co.com.s4n.demo_bc2.domain.entities.devices.Device;

public interface DeviceRepository {

    Device save(Device device);
}
