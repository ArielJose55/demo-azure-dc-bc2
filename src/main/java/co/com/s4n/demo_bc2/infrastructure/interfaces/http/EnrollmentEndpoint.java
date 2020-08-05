package co.com.s4n.demo_bc2.infrastructure.interfaces.http;

import co.com.s4n.demo_bc2.infrastructure.acl.dtos.requests.DeviceDataRequestDTO;
import co.com.s4n.demo_bc2.infrastructure.acl.dtos.responses.DeviceDataResponseDTO;
import co.com.s4n.demo_bc2.infrastructure.command.enrollmentdevice.EnrollmentDeviceCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentEndpoint {

    private final EnrollmentDeviceCommand enrollmentDeviceCommand;

    @Autowired
    public EnrollmentEndpoint(EnrollmentDeviceCommand enrollmentDeviceCommand) {
        this.enrollmentDeviceCommand = enrollmentDeviceCommand;
    }

    @PostMapping("/enrollment-device")
    public DeviceDataResponseDTO enrollmentDevice(@RequestBody DeviceDataRequestDTO deviceDataRequestDTO) {
        return enrollmentDeviceCommand.execute(deviceDataRequestDTO);
    }
}
