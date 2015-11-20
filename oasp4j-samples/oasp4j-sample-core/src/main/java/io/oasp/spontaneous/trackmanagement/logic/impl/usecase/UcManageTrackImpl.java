package io.oasp.spontaneous.trackmanagement.logic.impl.usecase;

import io.oasp.spontaneous.general.logic.api.UseCase;
import io.oasp.spontaneous.trackmanagement.dataaccess.api.TrackEntity;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackEto;
import io.oasp.spontaneous.trackmanagement.logic.api.usecase.UcManageTrack;
import io.oasp.spontaneous.trackmanagement.logic.base.usecase.AbstractTrackUc;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

/**
 * Use case implementation for modifying and deleting Tracks
 */
@Named
@UseCase
@Validated
public class UcManageTrackImpl extends AbstractTrackUc implements UcManageTrack {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageTrackImpl.class);

  @Override
  public boolean deleteTrack(Long trackId) {

    TrackEntity track = getTrackDao().find(trackId);
    getTrackDao().delete(track);
    LOG.debug("The track with id '{}' has been deleted.", trackId);
    return true;
  }

  @Override
  public TrackEto saveTrack(TrackEto track) {

    Objects.requireNonNull(track, "track");

    TrackEntity trackEntity = getBeanMapper().map(track, TrackEntity.class);

    // initialize, validate trackEntity here if necessary

    getTrackDao().save(trackEntity);
    LOG.debug("Track with id '{}' has been created.", trackEntity.getId());
    return getBeanMapper().map(trackEntity, TrackEto.class);
  }

}
