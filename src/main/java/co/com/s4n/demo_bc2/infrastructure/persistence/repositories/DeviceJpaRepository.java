package co.com.s4n.demo_bc2.infrastructure.persistence.repositories;

import co.com.s4n.demo_bc2.infrastructure.persistence.records.DeviceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceJpaRepository extends JpaRepository<DeviceJpaEntity, String> {
}
