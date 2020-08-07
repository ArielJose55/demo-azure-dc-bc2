package co.com.s4n.demo_bc2.domain.services;

import co.com.s4n.demo_bc2.domain.entities.devices.Device;
import co.com.s4n.demo_bc2.domain.repositories.DeviceRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;

public class DeviceService {

    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Either<String, Device> saveDevice(Device device) {
        return Try.of(() -> deviceRepository.save(device))
                .onFailure(error -> System.out.println("Error -> "  + error.getMessage()))
                .toEither("Ouups! The enrollment process was not possible");
    }
}
