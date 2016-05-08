package io.oasp.spontaneous.trackmanagement.logic.impl.usecase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.general.logic.api.UseCase;
import io.oasp.spontaneous.trackmanagement.dataaccess.api.TrackEntity;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackEto;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackSearchCriteriaTo;
import io.oasp.spontaneous.trackmanagement.logic.api.usecase.UcFindTrack;
import io.oasp.spontaneous.trackmanagement.logic.base.usecase.AbstractTrackUc;

import java.util.ArrayList;
import java.util.List;

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
    TrackEto trackEto = new TrackEto();
    TrackEntity track = getTrackDao().findOne(id);
    trackEto = getBeanMapper().map(track, TrackEto.class);
    trackEto.setUserId(track.getUser().getId());

    return trackEto;
  }

  @Override
  public PaginatedListTo<TrackEto> findTrackEtos(TrackSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<TrackEntity> tracks = getTrackDao().findTracks(criteria);
    PaginatedListTo<TrackEto> result = mapPaginatedEntityList(tracks);
    return result;
  }

  private PaginatedListTo<TrackEto> mapPaginatedEntityList(PaginatedListTo<TrackEntity> paginatedList) {

    List<TrackEto> etoList = new ArrayList<>();
    TrackEto eto;
    for (TrackEntity entity : paginatedList.getResult()) {
      eto = getBeanMapper().map(entity, TrackEto.class);
      eto.setUserId(entity.getUser().getId());
      etoList.add(eto);
    }
    PaginatedListTo<TrackEto> result = new PaginatedListTo<>(etoList, paginatedList.getPagination());
    return result;
  }
}
