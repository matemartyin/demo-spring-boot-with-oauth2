package com.matemartyin.oauth2demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GithubUserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        var defaultUserService = new DefaultOAuth2UserService();
        var user = defaultUserService.loadUser(userRequest);

        var clientName = userRequest.getClientRegistration().getClientName();
        var userName = (String) user.getAttribute("name");

        log.info("User logged in: {} - {}", userName, clientName);

        return user;
    }
}
