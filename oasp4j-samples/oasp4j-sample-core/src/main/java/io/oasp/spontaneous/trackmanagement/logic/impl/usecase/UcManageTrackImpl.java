package io.oasp.spontaneous.trackmanagement.logic.impl.usecase;

import io.oasp.spontaneous.general.logic.api.UseCase;
import io.oasp.spontaneous.staffmanagement.dataaccess.api.StaffMemberEntity;
import io.oasp.spontaneous.staffmanagement.logic.api.Staffmanagement;
import io.oasp.spontaneous.staffmanagement.logic.api.to.StaffMemberEto;
import io.oasp.spontaneous.trackmanagement.dataaccess.api.TrackEntity;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackEto;
import io.oasp.spontaneous.trackmanagement.logic.api.usecase.UcManageTrack;
import io.oasp.spontaneous.trackmanagement.logic.base.usecase.AbstractTrackUc;

import java.util.Objects;

import javax.inject.Inject;
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

  private Staffmanagement staffmanagement;

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
    StaffMemberEto userEto = this.staffmanagement.findStaffMember(track.getUserId());
    trackEntity.setUser(getBeanMapper().map(userEto, StaffMemberEntity.class));

    getTrackDao().save(trackEntity);
    LOG.debug("Track with id '{}' has been created.", trackEntity.getId());
    TrackEto result = getBeanMapper().map(trackEntity, TrackEto.class);
    result.setUserId(track.getUserId());
    return result;
  }

  /**
   * @param salesmanagement the salesmanagement to set
   */
  @Inject
  public void setStaffmanagement(Staffmanagement staffmanagement) {

    this.staffmanagement = staffmanagement;
  }
}
