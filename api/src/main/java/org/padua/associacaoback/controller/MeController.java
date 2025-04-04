package org.padua.associacaoback.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class MeController {

    @GetMapping("/me")
    public UserInfoDto me(Authentication auth) {
        if (auth instanceof JwtAuthenticationToken jwtAuth) {
            final var email = (String) jwtAuth.getTokenAttributes().getOrDefault(StandardClaimNames.EMAIL, "");
            final var roles = jwtAuth.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
            final var exp = Optional.ofNullable(jwtAuth.getTokenAttributes().get(JwtClaimNames.EXP))
                    .map(expClaim -> switch (expClaim) {
                        case Long lexp -> lexp;
                        case Instant iexp -> iexp.getEpochSecond();
                        case Date dexp -> dexp.toInstant().getEpochSecond();
                        default -> Long.MAX_VALUE;
                    }).orElse(Long.MAX_VALUE);
            return new UserInfoDto(auth.getName(), email, roles, exp);

        }
        return UserInfoDto.ANONYMOUS;
    }

    /**
     * @param username a unique identifier for the resource owner in the token (sub claim by default)
     * @param email    OpenID email claim
     * @param roles    Spring authorities resolved for the authentication in the security context
     * @param exp      seconds from 1970-01-01T00:00:00Z UTC until the specified UTC date/time when the access token expires
     */
    public record UserInfoDto(String username, String email, List<String> roles, Long exp) {
        public static final UserInfoDto ANONYMOUS = new UserInfoDto("", "", List.of(), Long.MAX_VALUE);
    }
}
