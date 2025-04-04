package org.padua.associacaoback.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//@RequiredArgsConstructor
public class SecurityConfig {

//    private final JwtAuthConverter jwtAuthConverter;
//
//    @Bean
//    SecurityFilterChain resourceServerSecurityFilterChain(HttpSecurity http) throws Exception {
//        http //
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> {
//                    jwt.jwtAuthenticationConverter(jwtAuthConverter);
//                }));
//        http //
//                .sessionManagement(sessions -> {
//                    sessions.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                }) //
//                .csrf(AbstractHttpConfigurer::disable);
//
//        http //
//                .authorizeHttpRequests(requests -> {
//                    requests.requestMatchers("/public/**").permitAll();
//                    requests.requestMatchers("/logout").permitAll();
//                    requests.anyRequest().authenticated();
//                });
//
//        return http.build();
//    }
}
