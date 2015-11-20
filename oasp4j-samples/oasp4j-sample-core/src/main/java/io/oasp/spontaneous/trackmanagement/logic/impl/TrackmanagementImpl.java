package io.oasp.spontaneous.trackmanagement.logic.impl;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.general.logic.api.UseCase;
import io.oasp.spontaneous.general.logic.base.AbstractComponentFacade;
import io.oasp.spontaneous.trackmanagement.logic.api.Trackmanagement;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackEto;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackSearchCriteriaTo;
import io.oasp.spontaneous.trackmanagement.logic.api.usecase.UcFindTrack;
import io.oasp.spontaneous.trackmanagement.logic.api.usecase.UcManageTrack;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Implementation of component interface of trackmanagement
 */
@Named
public class TrackmanagementImpl extends AbstractComponentFacade implements Trackmanagement {

  private UcFindTrack ucFindTrack;

  private UcManageTrack ucManageTrack;

  /**
   * The constructor.
   */
  public TrackmanagementImpl() {

    super();
  }

  @Override
  public TrackEto findTrack(Long id) {

    return this.ucFindTrack.findTrack(id);
  }

  @Override
  public PaginatedListTo<TrackEto> findTrackEtos(TrackSearchCriteriaTo criteria) {

    return this.ucFindTrack.findTrackEtos(criteria);
  }

  @Override
  public TrackEto saveTrack(TrackEto track) {

    return this.ucManageTrack.saveTrack(track);
  }

  @Override
  public boolean deleteTrack(Long id) {

    return this.ucManageTrack.deleteTrack(id);
  }

  /**
   * Sets the field 'ucFindTrack'.
   *
   * @param ucFindTrack New value for ucFindTrack
   */
  @Inject
  @UseCase
  public void setUcFindTrack(UcFindTrack ucFindTrack) {

    this.ucFindTrack = ucFindTrack;
  }

  /**
   * Sets the field 'ucManageTrack'.
   *
   * @param ucManageTrack New value for ucManageTrack
   */
  @Inject
  @UseCase
  public void setUcManageTrack(UcManageTrack ucManageTrack) {

    this.ucManageTrack = ucManageTrack;
  }

}
