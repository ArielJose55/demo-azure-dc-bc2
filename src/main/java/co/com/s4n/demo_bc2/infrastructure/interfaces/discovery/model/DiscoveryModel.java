package co.com.s4n.demo_bc2.infrastructure.interfaces.discovery.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class DiscoveryModel {
    private final String issuer;
    private final String authorization_endpoint;
    private final String token_endpoint;
}
