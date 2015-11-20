package io.oasp.spontaneous.trackmanagement.logic.api.to;

import io.oasp.spontaneous.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Track
 */
public class TrackCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private TrackEto track;

  public TrackEto getTrack() {

    return track;
  }

  public void setTrack(TrackEto track) {

    this.track = track;
  }

}
