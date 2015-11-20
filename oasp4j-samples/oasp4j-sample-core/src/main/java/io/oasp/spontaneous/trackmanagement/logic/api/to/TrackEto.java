package io.oasp.spontaneous.trackmanagement.logic.api.to;

import io.oasp.spontaneous.general.common.api.to.AbstractEto;
import io.oasp.spontaneous.trackmanagement.common.api.Track;

/**
 * Entity transport object of Track
 */
public class TrackEto extends AbstractEto implements Track {

  private static final long serialVersionUID = 1L;

  private String name;

  private Long totalDistance;

  private Long totalDuration;

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {

    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getTotalDistance() {

    return totalDistance;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTotalDistance(Long totalDistance) {

    this.totalDistance = totalDistance;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getTotalDuration() {

    return totalDuration;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTotalDuration(Long totalDuration) {

    this.totalDuration = totalDuration;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.totalDistance == null) ? 0 : this.totalDistance.hashCode());
    result = prime * result + ((this.totalDuration == null) ? 0 : this.totalDuration.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    TrackEto other = (TrackEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.totalDistance == null) {
      if (other.totalDistance != null) {
        return false;
      }
    } else if (!this.totalDistance.equals(other.totalDistance)) {
      return false;
    }
    if (this.totalDuration == null) {
      if (other.totalDuration != null) {
        return false;
      }
    } else if (!this.totalDuration.equals(other.totalDuration)) {
      return false;
    }
    return true;
  }

}
