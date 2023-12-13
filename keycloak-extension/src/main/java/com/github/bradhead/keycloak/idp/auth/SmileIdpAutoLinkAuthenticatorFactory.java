package com.github.bradhead.keycloak.idp.auth;

import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.authentication.authenticators.broker.IdpAutoLinkAuthenticatorFactory;
import org.keycloak.models.KeycloakSession;

public class SmileIdpAutoLinkAuthenticatorFactory extends IdpAutoLinkAuthenticatorFactory {

    private static final SmileIdpAutoLinkAuthenticator INSTANCE = new SmileIdpAutoLinkAuthenticator();

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public Authenticator create(KeycloakSession session) {
        return INSTANCE;
    }

    @Override
    public String getReferenceCategory() {
        return "custom-smile-autoLink";
    }

    @Override
    public boolean isConfigurable() {
        return false;
    }

    @Override
    public String getDisplayType() {
        return "SmileCDR Automatically set existing Realm user";
    }

    @Override
    public String getHelpText() {
        return "Automatically set existing user to authentication context without any verification";
    }
}