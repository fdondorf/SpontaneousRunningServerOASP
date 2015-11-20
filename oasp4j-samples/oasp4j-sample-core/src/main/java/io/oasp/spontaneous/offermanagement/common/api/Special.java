package io.oasp.spontaneous.offermanagement.common.api;

import io.oasp.spontaneous.general.common.api.ApplicationEntity;
import io.oasp.spontaneous.general.common.api.datatype.Money;

public interface Special extends ApplicationEntity {

  public Long getOfferId();

  public void setOfferId(Long offerId);

  public WeeklyPeriod getActivePeriod();

  public void setActivePeriod(WeeklyPeriod activePeriod);

  public Money getSpecialPrice();

  public void setSpecialPrice(Money specialPrice);

  public String getName();

  public void setName(String name);

}
