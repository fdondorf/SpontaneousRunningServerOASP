package io.oasp.spontaneous.general.common;

import io.oasp.spontaneous.general.common.api.to.UserDetailsClientTo;
import io.oasp.spontaneous.test.general.AppProperties;
import io.oasp.spontaneous.test.general.webclient.ResponseData;
import io.oasp.spontaneous.test.general.webclient.WebClientWrapper;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class to test security features.
 *
 * @author jmetzler
 */
public class SecurityRestServiceTest {

  /**
   * Login and check if current user is the one logged in.
   */
  @Test
  public void loginTest() {

    String login = "chief";
    WebClientWrapper user = new WebClientWrapper(login);

    ResponseData<UserDetailsClientTo> response =
        user.get(AppProperties.SERVER_URL + "/services/rest/security/v1/currentuser/", UserDetailsClientTo.class);

    Assert.assertEquals(login, response.getResponseObject().getName());
  }
}
