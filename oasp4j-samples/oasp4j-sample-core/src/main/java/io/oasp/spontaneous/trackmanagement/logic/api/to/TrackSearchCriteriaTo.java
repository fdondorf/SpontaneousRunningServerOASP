package io.oasp.spontaneous.trackmanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.spontaneous.trackmanagement.common.api.Track}s.
 */
public class TrackSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private Long totalDistance;

  private Long totalDuration;

  /**
   * The constructor.
   */
  public TrackSearchCriteriaTo() {

    super();
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public Long getTotalDistance() {

    return totalDistance;
  }

  public void setTotalDistance(Long totalDistance) {

    this.totalDistance = totalDistance;
  }

  public Long getTotalDuration() {

    return totalDuration;
  }

  public void setTotalDuration(Long totalDuration) {

    this.totalDuration = totalDuration;
  }

}
