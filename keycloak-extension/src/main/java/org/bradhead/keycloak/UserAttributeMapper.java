/**
 * When creating user during token exchange federation, attributes should be updated (created in this case) as well
 */
package org.bradhead.keycloak;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.keycloak.models.KeycloakSession;
import org.keycloak.models.IdentityProviderMapperModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.RealmModel;
import org.keycloak.broker.provider.BrokeredIdentityContext;
/**
 * Maps a UserModel.attribute to a token claim and/or token response field.
 * The token claim name can be a full qualified nested object name, e.g. "address.country".
 * This will create a nested json object within the token claim.
 * 
 * Fixes issue when attribute mapper not working when creating user during token exchange federation
 *
 * @author <a href="mailto:brad@zedwerks.com">Brad Head</a>
 * @version $Revision: 1 $
 */
public class UserAttributeMapper extends org.keycloak.broker.oidc.mappers.UserAttributeMapper{
    @Override
    public void importNewUser(KeycloakSession session, RealmModel realm, UserModel user, IdentityProviderMapperModel mapperModel, BrokeredIdentityContext context) {
        super.importNewUser(session, realm, user, mapperModel, context);
        Logger.getLogger(getClass().getName()).info("importNewUser called");
        this.updateBrokeredUser(session, realm, user, mapperModel, context);
    }
}