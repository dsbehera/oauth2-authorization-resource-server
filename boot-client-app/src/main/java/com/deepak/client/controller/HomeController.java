package com.deepak.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.security.Principal;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@RestController("/")
public class HomeController {

    @Autowired
    private WebClient webClient;

    @GetMapping
    public String home(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "Authenticated";
        }
        return "<h1>Home Page</h1>";
    }

    @GetMapping(path = "dashboard")
    public String dashboard() {
        return "Welcome to dashboard !!!";
    }

    /*@GetMapping("/users")
    public String[] users(
            @RegisteredOAuth2AuthorizedClient("api-client-authorization-code")
                    OAuth2AuthorizedClient client){
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/api/users")
                .attributes(oauth2AuthorizedClient(client))
                .retrieve()
                .bodyToMono(String[].class)
                .block();
    }*/
}
