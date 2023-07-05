package vn.itlearn.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class ReactiveWebfluxSecurityConfig {
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http){
        return http.csrf(ServerHttpSecurity.CsrfSpec::disable).build();
    }
}
