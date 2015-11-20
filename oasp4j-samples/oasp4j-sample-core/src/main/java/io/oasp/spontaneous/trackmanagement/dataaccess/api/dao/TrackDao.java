package io.oasp.spontaneous.trackmanagement.dataaccess.api.dao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.spontaneous.trackmanagement.dataaccess.api.TrackEntity;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackSearchCriteriaTo;

/**
 * Data access interface for Track entities
 */
public interface TrackDao extends ApplicationDao<TrackEntity> {

  /**
   * Finds the {@link TrackEntity tracks} matching the given {@link TrackSearchCriteriaTo}.
   *
   * @param criteria is the {@link TrackSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link TrackEntity} objects.
   */
  PaginatedListTo<TrackEntity> findTracks(TrackSearchCriteriaTo criteria);

}
