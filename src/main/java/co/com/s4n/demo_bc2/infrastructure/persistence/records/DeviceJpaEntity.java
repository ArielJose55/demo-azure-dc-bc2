package co.com.s4n.demo_bc2.infrastructure.persistence.records;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
//@Entity
//@Table(name = "tb2c_device")
@NoArgsConstructor
@AllArgsConstructor
public class DeviceJpaEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "id_device", nullable = false, unique = true)
    private String idDevice;

    @Column(name = "fecha_evento", nullable = false)
    private String biometryType;
}
