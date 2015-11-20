package io.oasp.spontaneous.trackmanagement.logic.base.usecase;

import io.oasp.spontaneous.general.logic.base.AbstractUc;
import io.oasp.spontaneous.trackmanagement.dataaccess.api.dao.TrackDao;

import javax.inject.Inject;

/**
 * Abstract use case for Tracks, which provides access to the commonly necessary data access objects.
 */
public class AbstractTrackUc extends AbstractUc {

  /** @see #getTrackDao() */
  private TrackDao trackDao;

  /**
   * Returns the field 'trackDao'.
   * 
   * @return the {@link TrackDao} instance.
   */
  public TrackDao getTrackDao() {

    return this.trackDao;
  }

  /**
   * Sets the field 'trackDao'.
   * 
   * @param trackDao New value for trackDao
   */
  @Inject
  public void setTrackDao(TrackDao trackDao) {

    this.trackDao = trackDao;
  }

}
