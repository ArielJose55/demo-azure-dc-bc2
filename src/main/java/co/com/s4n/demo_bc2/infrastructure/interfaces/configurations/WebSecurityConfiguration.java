package co.com.s4n.demo_bc2.infrastructure.interfaces.configurations;

import co.com.s4n.demo_bc2.infrastructure.paramenters.ApplicationConf;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.nimbusds.jose.JWSAlgorithm;
import org.mitre.jose.keystore.JWKSetKeyStore;
import org.mitre.jwt.signer.service.JWTSigningAndValidationService;
import org.mitre.jwt.signer.service.impl.DefaultJWTSigningAndValidationService;
import org.mitre.jwt.signer.service.impl.JWKSetCacheService;
import org.mitre.oauth2.model.ClientDetailsEntity.AuthMethod;
import org.mitre.oauth2.model.RegisteredClient;
import org.mitre.openid.connect.client.OIDCAuthenticationFilter;
import org.mitre.openid.connect.client.OIDCAuthenticationProvider;
import org.mitre.openid.connect.client.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final ApplicationConf conf = ApplicationConf.getInstance();


    @Value("${oidc.keystorepath:keystore.jwks}")
    private String keystorePath;

    /**
     * This is the key ID of the key used to sign the client's outgoing requests. This key
     * must exist in the keystore configured above
     */
    @Value("${oidc.defaultkey:rsa-test-key}")
    private String signingKeyId;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()

                // This adds the authentication filter itself, see
                // the configureOIDCFilter method for more details
                .addFilterBefore(configureOIDCfilter(),
                        AbstractPreAuthenticatedProcessingFilter.class)


                // This sets up the application to automatically request an OIDC login when needed
                .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/openid_connect_login"))
                .and()

                // This sets up the logout system
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
    }


    @Bean
    public OIDCAuthenticationFilter configureOIDCfilter() throws Exception {

        OIDCAuthenticationFilter filter = new OIDCAuthenticationFilter();

        // This sets the RP to talk only to one IdP, configured above
        StaticSingleIssuerService issuerService = new StaticSingleIssuerService();
        issuerService.setIssuer(conf.getUrlIssuer());
        filter.setIssuerService(issuerService);

        // This tells the RP to dynamically load the IdP's configuration over the web
        filter.setServerConfigurationService(new DynamicServerConfigurationService());

        // This tells the RP how to talk to the IdP
        StaticClientConfigurationService clientService = new StaticClientConfigurationService();
        RegisteredClient client = new RegisteredClient();

        // This is the client's unique identifier at the IdP, configured above
        client.setClientId(conf.getClientID());

        // This tells the client to use a signed JWT to authenticate itself
        //   note: your keys need to be registered with the IdP
        client.setTokenEndpointAuthMethod(AuthMethod.PRIVATE_KEY);

        // This tells the client to ask for the standard OpenID Connect scopes
        client.setScope(ImmutableSet.of("openid", "email", "address", "profile", "phone"));

        // This tells the client which redirect URIs are valid, configured above.
        //   note: it will use only the first one in the set.
        client.setRedirectUris(ImmutableSet.of(conf.getRedirectUri()));

        // This tells the client to use this configuration when talking to the IdP
        clientService.setClients(ImmutableMap.of(conf.getUrlIssuer(), client));
        filter.setClientConfigurationService(clientService);

        // This tells the client to send no additional options
        filter.setAuthRequestOptionsService(new StaticAuthRequestOptionsService());

        // This tells the client to use a plain HTTP redirect to send its requests
        filter.setAuthRequestUrlBuilder(new PlainAuthRequestUrlBuilder());

        // This wires in the authentication manager to the filter
        filter.setAuthenticationManager(authenticationManager());

        return filter;

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth
                // This wires the OIDC authentication provider into the system
                .authenticationProvider(configureOIDCAuthenticationProvider());

    }

    /**
     * This creates the authentication provider that handles the OIDC login process
     * to create a spring Authentication object in the security context.
     *
     * @return
     */
    @Bean
    public AuthenticationProvider configureOIDCAuthenticationProvider() {
        OIDCAuthenticationProvider authenticationProvider = new OIDCAuthenticationProvider();

        // This default provider will set everyone to have the role "USER". To change this
        // behavior, wire in a custom OIDCAuthoritiesMapper here
        //
        //   authenticationProvider.setAuthoritiesMapper(OIDCAuthoritiesMapper);
        //

        return authenticationProvider;
    }

    /**
     * This creates a component to fetch the public keys of the IdP
     */
    @Bean
    public JWKSetCacheService createValidatorCache() {
        return new JWKSetCacheService();
    }


    /**
     * This loads the public and private keys for this client from the
     * JWKS file, path configured above.
     * @return
     */
    @Bean
    public JWKSetKeyStore createKeyStore() {
        JWKSetKeyStore keyStore = new JWKSetKeyStore();
        keyStore.setLocation(new ClassPathResource(keystorePath));
        return keyStore;
    }

    /**
     * This creates the services that signs the outgoing request and validates
     * the ID token's signature.
     * @return
     * @throws Exception
     */
    @Bean
    public JWTSigningAndValidationService createSigningService() throws Exception {
        DefaultJWTSigningAndValidationService jwtSigningAndValidationService = new DefaultJWTSigningAndValidationService(createKeyStore());
        jwtSigningAndValidationService.setDefaultSignerKeyId(signingKeyId);
        jwtSigningAndValidationService.setDefaultSigningAlgorithmName(JWSAlgorithm.RS256.getName());
        return jwtSigningAndValidationService;
    }

}
