package co.com.s4n.demo_bc2.infrastructure.command.enrollmentdevice;

import co.com.s4n.demo_bc2.domain.services.DeviceService;
import co.com.s4n.demo_bc2.infrastructure.acl.builders.DeviceBuilder;
import co.com.s4n.demo_bc2.infrastructure.acl.dtos.requests.DeviceDataRequestDTO;
import co.com.s4n.demo_bc2.infrastructure.acl.dtos.responses.DeviceDataResponseDTO;
import co.com.s4n.demo_bc2.infrastructure.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentDeviceCommand implements Command<DeviceDataRequestDTO, DeviceDataResponseDTO> {

    private final DeviceService deviceService;

    @Autowired
    public EnrollmentDeviceCommand(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Override
    public DeviceDataResponseDTO execute(DeviceDataRequestDTO request) {
        return deviceService.saveDevice(DeviceBuilder.fromRequestDto(request))
                .fold(
                        DeviceDataResponseDTO::new,
                        device -> new DeviceDataResponseDTO("Successful enrollment")
                );
    }
}
