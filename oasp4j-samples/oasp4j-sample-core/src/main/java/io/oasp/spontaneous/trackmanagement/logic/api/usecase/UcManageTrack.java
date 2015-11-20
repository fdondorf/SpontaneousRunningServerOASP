package io.oasp.spontaneous.trackmanagement.logic.api.usecase;

import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackEto;

/**
 * Interface of UcManageTrack to centralize documentation and signatures of methods.
 */
public interface UcManageTrack {

  /**
   * Deletes a track from the database by its id 'trackId'.
   *
   * @param trackId Id of the track to delete
   * @return boolean <code>true</code> if the track can be deleted, <code>false</code> otherwise
   */
  boolean deleteTrack(Long trackId);

  /**
   * Saves a track and store it in the database.
   *
   * @param track the {@link TrackEto} to create.
   * @return the new {@link TrackEto} that has been saved with ID and version.
   */
  TrackEto saveTrack(TrackEto track);

}
