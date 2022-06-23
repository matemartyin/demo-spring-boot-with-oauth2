package com.matemartyin.springbootwithoauthdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final ObjectMapper objectMapper;

    public UserController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/user")
    public String userDetails(@AuthenticationPrincipal OAuth2User principal) throws JsonProcessingException {
        return objectMapper.writeValueAsString(principal);
    }

}
