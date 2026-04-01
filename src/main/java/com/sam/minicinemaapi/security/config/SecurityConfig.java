package com.sam.minicinemaapi.security.config;

import com.sam.minicinemaapi.constant.EndpointConstant;
import com.sam.minicinemaapi.security.jwt.JwtAccessDeniedHandler;
import com.sam.minicinemaapi.security.jwt.JwtConverter;
import com.sam.minicinemaapi.security.jwt.JwtEntryPointHandler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityConfig {
    JwtDecoder decoder;
    JwtConverter converter;
    JwtEntryPointHandler entryPointHandler;
    JwtAccessDeniedHandler accessDeniedHandler;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.cors(Customizer.withDefaults());
        httpSecurity.authorizeHttpRequests(authorize -> {
            authorize.requestMatchers(EndpointConstant.PUBLIC_ENDPOINTS).permitAll();
            authorize.requestMatchers(EndpointConstant.SWAGGER_ENDPOINTS).permitAll();
            authorize.anyRequest().authenticated();
        });
        httpSecurity.oauth2ResourceServer(auth -> {
            auth.accessDeniedHandler(accessDeniedHandler);
            auth.authenticationEntryPoint(entryPointHandler);
            auth.jwt(jwt -> {
                jwt.decoder(decoder);
                jwt.jwtAuthenticationConverter(converter);
            });
        });
        return httpSecurity.build();
    }
}
