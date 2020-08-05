package co.com.s4n.demo_bc2.infrastructure.acl.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDataRequestDTO {
    private String idDevice;
    private String biometryType;
}
