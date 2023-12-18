package com.github.bradhead.keycloak.idp.auth;

import org.jboss.logging.Logger;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.authenticators.broker.IdpAutoLinkAuthenticator;
import org.keycloak.authentication.authenticators.broker.util.SerializedBrokeredIdentityContext;
import org.keycloak.broker.provider.BrokeredIdentityContext;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

public class SmileIdpAutoLinkAuthenticator extends IdpAutoLinkAuthenticator {

    @Override
    protected void authenticateImpl(AuthenticationFlowContext context, SerializedBrokeredIdentityContext serializedCtx,
            BrokeredIdentityContext brokerContext) {

        final Logger logger = Logger.getLogger(getClass().getName());
        RealmModel realm = context.getRealm();
        UserModel user = context.getUser();

        String brokerUserId = brokerContext.getId();
        if (brokerUserId == null) {
            logger.info("com.github.bradhead.keycloak.idp.auth.SmileIdpAutoLinkAuthenticator.authenticateImpl(...) brokerUserId is null");
            return;
        }
        if (!brokerUserId.contains("|")) {
            logger.info("com.github.bradhead.keycloak.idp.auth.SmileIdpAutoLinkAuthenticator.authenticateImpl(...) brokerUserId does not contain |");
            return;
        }

        super.authenticateImpl(context, serializedCtx, brokerContext);
        logger.info("com.github.bradhead.keycloak.idp.SmileIdpAutoLinkAuthenticator.authenticateImpl(...) called");
        logger.info("userId: " + user.getId());
        logger.info("username: " + user.getUsername());
        logger.info("realm name: " + realm.getName());

    }
}
