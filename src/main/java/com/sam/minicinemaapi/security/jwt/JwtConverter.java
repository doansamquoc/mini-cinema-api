package com.sam.minicinemaapi.security.jwt;

import com.sam.minicinemaapi.security.model.UserPrincipal;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    JwtGrantedAuthoritiesConverter authorities;

    @Override
    public @Nullable AbstractAuthenticationToken convert(@NonNull Jwt source) {
        Collection<? extends GrantedAuthority> authorities = this.authorities.convert(source);

        Long id = Long.valueOf(source.getSubject());
        UserPrincipal principal = UserPrincipal.builder().id(id).authorities(authorities).build();
        return new UsernamePasswordAuthenticationToken(principal, source, authorities);
    }
}
