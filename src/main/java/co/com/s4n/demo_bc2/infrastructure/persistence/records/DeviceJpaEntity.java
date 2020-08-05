package co.com.s4n.demo_bc2.infrastructure.persistence.records;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb2c_device")
@NoArgsConstructor
public class DeviceJpaEntity {
    @Id
    @Column(name = "id_device", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idDevice;

    @Column(name = "fechaEvento", nullable = false)
    private String biometryType;
}
