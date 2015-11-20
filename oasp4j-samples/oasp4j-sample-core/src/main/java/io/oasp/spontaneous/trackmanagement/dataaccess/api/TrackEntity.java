package io.oasp.spontaneous.trackmanagement.dataaccess.api;

import io.oasp.spontaneous.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.spontaneous.offermanagement.common.api.Special;
import io.oasp.spontaneous.trackmanagement.common.api.Track;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The {@link ApplicationPersistenceEntity persistent entity} for a track.
 *
 * @author mbrunnli
 */
@Entity(name = "Track")
@Table(name = "Track")
public class TrackEntity extends ApplicationPersistenceEntity implements Track {

  private String name;

  private Long totalDistance;

  private Long totalDuration;

  private static final long serialVersionUID = 1L;

  /**
   * Returns the name of the {@link Special}.
   *
   * @return name the name of the {@link Special}.
   */
  @Override
  @Column(unique = true)
  public String getName() {

    return this.name;
  }

  /**
   * Sets the name of the special.
   *
   * @param name the name of the special.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return totalDistance
   */
  public Long getTotalDistance() {

    return totalDistance;
  }

  /**
   * @param totalDistance new value of {@link #gettotalDistance}.
   */
  public void setTotalDistance(Long totalDistance) {

    this.totalDistance = totalDistance;
  }

  /**
   * @return totalDuration
   */
  public Long getTotalDuration() {

    return totalDuration;
  }

  /**
   * @param totalDuration new value of {@link #gettotalDuration}.
   */
  public void setTotalDuration(Long totalDuration) {

    this.totalDuration = totalDuration;
  }

}
