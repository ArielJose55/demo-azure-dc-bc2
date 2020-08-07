package co.com.s4n.demo_bc2.infrastructure.acl.builders;

import co.com.s4n.demo_bc2.domain.entities.devices.BiometryType;
import co.com.s4n.demo_bc2.domain.entities.devices.Device;
import co.com.s4n.demo_bc2.domain.entities.devices.DeviceImmutable;
import co.com.s4n.demo_bc2.infrastructure.acl.dtos.requests.DeviceDataRequestDTO;
import co.com.s4n.demo_bc2.infrastructure.persistence.records.DeviceJpaEntity;

public class DeviceBuilder {

    private DeviceBuilder() { throw new InstantiationError("This class should not be instantiated");}

    public static Device fromRequestDto(DeviceDataRequestDTO deviceDataRequestDTO) {
        return DeviceImmutable.of(deviceDataRequestDTO.getIdDevice(), BiometryType.valueOf(deviceDataRequestDTO.getBiometryType()));
    }

    public static DeviceJpaEntity fromDomain(Device device) {
        return new DeviceJpaEntity(null , device.hash(), device.biometryType().name());
    }
}
