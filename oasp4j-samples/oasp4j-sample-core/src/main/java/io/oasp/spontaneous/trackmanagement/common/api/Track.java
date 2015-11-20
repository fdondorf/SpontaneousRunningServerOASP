package io.oasp.spontaneous.trackmanagement.common.api;

import io.oasp.spontaneous.general.common.api.ApplicationEntity;

public interface Track extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public Long getTotalDistance();

  public void setTotalDistance(Long totalDistance);

  public Long getTotalDuration();

  public void setTotalDuration(Long totalDuration);

}
