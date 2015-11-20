package io.oasp.spontaneous.trackmanagement.logic.api.usecase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackEto;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackSearchCriteriaTo;

import java.util.List;

public interface UcFindTrack {

  /**
   * Returns a Track by its id 'id'.
   *
   * @param id The id 'id' of the Track.
   * @return The {@link TrackEto} with id 'id'
   */
  TrackEto findTrack(Long id);

  /**
   * Returns a paginated list of Tracks matching the search criteria.
   *
   * @param criteria the {@link TrackSearchCriteriaTo}.
   * @return the {@link List} of matching {@link TrackEto}s.
   */
  PaginatedListTo<TrackEto> findTrackEtos(TrackSearchCriteriaTo criteria);

}
