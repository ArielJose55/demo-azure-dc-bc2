package co.com.s4n.demo_bc2.infrastructure.interfaces.http;

import co.com.s4n.demo_bc2.infrastructure.acl.dtos.requests.DeviceDataRequestDTO;
import co.com.s4n.demo_bc2.infrastructure.acl.dtos.responses.DeviceRequestResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentEndpoint {

    @PostMapping("/enrollment-device")
    public DeviceRequestResponseDTO enrollmentDevice(@RequestBody DeviceDataRequestDTO deviceDataRequestDTO) {
        return new DeviceRequestResponseDTO("Ok");
    }
}
