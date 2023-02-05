package controller;

import com.auth0.AuthenticationController;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;

import java.io.UnsupportedEncodingException;


public abstract class AuthenticationControllerProvider {
    private static String domain = "dev-rz4pwc3yzwr0eps2.uk.auth0.com";
    private static String clientId = "grcF9o20HLQuGh61GphIdLN2SzyMGOLw";
    private static String clientSecret = "ayxp-fBLIiC9g1f1HHLW_f-HstLh_UCmdAiNncessV9LneWIxgfyj6UHbV5OMBVw";

    public static AuthenticationController getInstance(String config) throws UnsupportedEncodingException {


        if (domain == null || clientId == null || clientSecret == null) {
            throw new IllegalArgumentException("Missing domain, clientId, or clientSecret. Did you update src/main/webapp/WEB-INF/web.xml?");
        }

        // JwkProvider required for RS256 tokens. If using HS256, do not use.
        JwkProvider jwkProvider = new JwkProviderBuilder(domain).build();
        return AuthenticationController.newBuilder(domain, clientId, clientSecret)
                .withJwkProvider(jwkProvider)
                .build();
    }


    public static String getDomain() {
        return domain;
    }

    public static String getClientId() {
        return clientId;
    }

    public static String getClientSecret() {
        return clientSecret;
    }

}