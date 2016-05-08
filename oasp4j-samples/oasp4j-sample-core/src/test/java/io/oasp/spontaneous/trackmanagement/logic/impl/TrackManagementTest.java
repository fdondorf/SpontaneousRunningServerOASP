package io.oasp.spontaneous.trackmanagement.logic.impl;

import io.oasp.module.configuration.common.api.ApplicationConfigurationConstants;
import io.oasp.spontaneous.general.common.AbstractSpringIntegrationTest;
import io.oasp.spontaneous.trackmanagement.logic.api.Trackmanagement;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackEto;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * This is the test-case of {@link Trackmanagement}.
 *
 * @author fdondorf
 */
@ContextConfiguration({ ApplicationConfigurationConstants.BEANS_LOGIC })
public class TrackManagementTest extends AbstractSpringIntegrationTest {

  @Inject
  private Trackmanagement trackManagement;

  /**
   *
   */
  @Test
  public void testTrackmanagement() {

    TrackEto track = new TrackEto();
    track.setName("Testtrack");
    track.setTotalDistance(500000L);
    track.setTotalDuration(1000000L);
    track.setAverageSpeed(5555L);
    track.setCreationTime(new Date().getTime());
    track.setUserId(0L);

    String trackData = "trackData: {segment: }";
    track.setTrackData(trackData);

    TrackEto trackResult = this.trackManagement.saveTrack(track);
    assertNotNull(trackResult.getId());

    TrackEto trackFromDB = this.trackManagement.findTrack(trackResult.getId());
    assertEquals(new String(track.getTrackData()), new String(trackFromDB.getTrackData()));
    assertEquals(track.getName(), trackFromDB.getName());
    assertEquals(track.getTotalDistance(), trackFromDB.getTotalDistance());
    assertEquals(track.getTotalDuration(), trackFromDB.getTotalDuration());
    assertEquals(track.getAverageSpeed(), trackFromDB.getAverageSpeed());
    assertEquals(track.getCreationTime(), trackFromDB.getCreationTime());
    assertEquals(track.getUserId(), trackFromDB.getUserId());
  }

}
