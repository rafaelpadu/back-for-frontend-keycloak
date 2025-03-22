package org.padua.bff;

import com.c4_soft.springaddons.security.oidc.starter.properties.SpringAddonsOidcProperties;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class LoginOptionsController {
    private final List<LoginOptionDTO> loginOptions;

    public LoginOptionsController(OAuth2ClientProperties clientProperties, SpringAddonsOidcProperties addonsProperties) {
        final var clientAuthority = addonsProperties.getClient()
                .getClientUri()
                .getAuthority();
        this.loginOptions = clientProperties.getRegistration()
                .entrySet()
                .stream()
                .filter(entry -> "authorization_code".equals(entry.getValue().getAuthorizationGrantType()))
                .map(entry -> {
                    final var label = entry.getValue().getProvider();
                    final var loginUri = "%s/oauth2/authorization/%s" //
                            .formatted(addonsProperties.getClient().getClientUri(), entry.getKey());
                    final var providerId = clientProperties.getRegistration().get(entry.getKey()).getProvider();
                    final var providerIssuerAuthority = URI
                            .create(clientProperties.getProvider().get(providerId).getIssuerUri())
                            .getAuthority();
                    return new LoginOptionDTO(label, loginUri, clientAuthority.equals(providerIssuerAuthority));
                }).toList();
    }

    @GetMapping(value = "/login-options", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<LoginOptionDTO>> getLoginOptions() {
        return Mono.just(this.loginOptions);
    }

    public record LoginOptionDTO(@NotEmpty String label, @NotEmpty String loginUri, boolean isSameAuthority) {
    }
}
