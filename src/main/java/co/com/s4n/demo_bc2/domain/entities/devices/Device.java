package co.com.s4n.demo_bc2.domain.entities.devices;

import co.com.s4n.demo_bc2.domain.entities.ProteccionImmutableStyle;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@ProteccionImmutableStyle
@JsonSerialize(as = DeviceImmutable.class)
@JsonDeserialize(as = DeviceImmutable.class)
public interface Device {
    String hash();
    BiometryType biometryType();
}
