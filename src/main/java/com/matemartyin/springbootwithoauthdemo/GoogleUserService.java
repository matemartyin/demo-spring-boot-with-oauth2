package com.matemartyin.springbootwithoauthdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GoogleUserService implements OAuth2UserService<OidcUserRequest, OidcUser> {
    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        var oidcUserService = new OidcUserService();
        var user = oidcUserService.loadUser(userRequest);

        var clientName = userRequest.getClientRegistration().getClientName();
        var userName = (String) user.getAttribute("name");

        log.info("User logged in: {} - {}", userName, clientName);

        return user;
    }
}