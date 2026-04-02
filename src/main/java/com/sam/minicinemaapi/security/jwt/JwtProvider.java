package com.sam.minicinemaapi.security.jwt;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.sam.minicinemaapi.config.AppProperties;
import com.sam.minicinemaapi.util.UUIDUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtProvider {
    SecretKey secretKey;
    AppProperties properties;

    public String generate(Long id, List<String> roles) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        Date issueTime = new Date();
        Date expirationTime = new Date(System.currentTimeMillis() + properties.getAccessTokenExpiration());

        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .issuer("Mini Cinema")
                .subject(id.toString())
                .issueTime(issueTime)
                .expirationTime(expirationTime)
                .jwtID(UUIDUtil.generate())
                .claim("roles", roles)
                .build();

        Payload payload = new Payload(claims.toJSONObject());
        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(secretKey));
        } catch (JOSEException e) {
            log.error("Generate access token failed: {}", e.getMessage());
            throw new RuntimeException(e);
        }

        return jwsObject.serialize();
    }
}
