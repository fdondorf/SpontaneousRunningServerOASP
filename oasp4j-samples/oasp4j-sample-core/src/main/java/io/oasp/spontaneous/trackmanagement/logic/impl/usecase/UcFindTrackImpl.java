package io.oasp.spontaneous.trackmanagement.logic.impl.usecase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.general.logic.api.UseCase;
import io.oasp.spontaneous.trackmanagement.dataaccess.api.TrackEntity;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackEto;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackSearchCriteriaTo;
import io.oasp.spontaneous.trackmanagement.logic.api.usecase.UcFindTrack;
import io.oasp.spontaneous.trackmanagement.logic.base.usecase.AbstractTrackUc;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

/**
 * Use case implementation for searching, filtering and getting Tracks
 */
@Named
@UseCase
@Validated
public class UcFindTrackImpl extends AbstractTrackUc implements UcFindTrack {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindTrackImpl.class);

  @Override
  public TrackEto findTrack(Long id) {

    LOG.debug("Get Track with id {} from database.", id);
    return getBeanMapper().map(getTrackDao().findOne(id), TrackEto.class);
  }

  @Override
  public PaginatedListTo<TrackEto> findTrackEtos(TrackSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<TrackEntity> tracks = getTrackDao().findTracks(criteria);
    return mapPaginatedEntityList(tracks, TrackEto.class);
  }

}
