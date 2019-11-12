package org.example;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
class MyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/")
    String index(){
        return "index";
    }

    @GetMapping("/secured")
    String secure(HttpServletRequest request){

        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal=(KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();

        LOGGER.info("username: {}", accessToken.getPreferredUsername());
        LOGGER.info("emailId: {}", accessToken.getEmail());
        LOGGER.info("lastname: {}",accessToken.getFamilyName());
        LOGGER.info("firstname: {}", accessToken.getGivenName());
        LOGGER.info("realmName: {}", accessToken.getIssuer());

        return "secured";
    }

    @GetMapping("/logout")
    String logout(HttpServletRequest httpServletRequest) throws Exception{
        httpServletRequest.logout();
        return "index";
    }
}
