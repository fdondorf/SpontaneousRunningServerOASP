package io.oasp.spontaneous.trackmanagement.dataaccess.api;

import io.oasp.spontaneous.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.spontaneous.offermanagement.common.api.Special;
import io.oasp.spontaneous.staffmanagement.dataaccess.api.StaffMemberEntity;
import io.oasp.spontaneous.trackmanagement.common.api.Track;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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

  private Long creationTime;

  private StaffMemberEntity user;

  private Long averageSpeed;

  private String trackData;

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
   * @return trackData
   */

  public String getTrackData() {

    return this.trackData;
  }

  /**
   * @param trackData new value of {@link #getTrackData}.
   */
  public void setTrackData(String trackData) {

    this.trackData = trackData;
  }

  /**
   * @return totalDistance
   */
  @Override
  public Long getTotalDistance() {

    return this.totalDistance;
  }

  /**
   * @param totalDistance new value of {@link #getTotalDistance}.
   */
  @Override
  public void setTotalDistance(Long totalDistance) {

    this.totalDistance = totalDistance;
  }

  /**
   * @return totalDuration
   */
  @Override
  public Long getTotalDuration() {

    return this.totalDuration;
  }

  /**
   * @param totalDuration new value of {@link #getTotalDuration}.
   */
  @Override
  public void setTotalDuration(Long totalDuration) {

    this.totalDuration = totalDuration;
  }

  /**
   * @return creationTime
   */
  public Long getCreationTime() {

    return this.creationTime;
  }

  /**
   * @param creationTime new value of {@link #getCreationTime}.
   */
  public void setCreationTime(Long creationTime) {

    this.creationTime = creationTime;
  }

  /**
   * @return user
   */
  @ManyToOne
  public StaffMemberEntity getUser() {

    return this.user;
  }

  /**
   * @param user new value of {@link #getUser}.
   */
  public void setUser(StaffMemberEntity user) {

    this.user = user;
  }

  /**
   * @return averageSpeed
   */
  public Long getAverageSpeed() {

    return this.averageSpeed;
  }

  /**
   * @param averageSpeed new value of {@link #getAverageSpeed}.
   */
  public void setAverageSpeed(Long averageSpeed) {

    this.averageSpeed = averageSpeed;
  }

  /**
   * @return serialversionuid
   */
  public static long getSerialversionuid() {

    return serialVersionUID;
  }

}
