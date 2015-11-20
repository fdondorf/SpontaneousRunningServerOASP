package io.oasp.spontaneous.offermanagement.common.api;

import io.oasp.spontaneous.offermanagement.common.api.datatype.DayOfWeek;
import io.oasp.spontaneous.offermanagement.logic.api.to.WeeklyPeriodEto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Common interface for WeeklyPeriodEmbeddable.
 */
@JsonDeserialize(as = WeeklyPeriodEto.class)
public interface WeeklyPeriod {

  /**
   * Returns the field startingDay.
   *
   * @return the field startingDay.
   */
  DayOfWeek getStartingDay();

  /**
   * Sets the new value for the field startingDay.
   *
   * @param startingDay new value for the field startingDay.
   */
  void setStartingDay(DayOfWeek startingDay);

  /**
   * Returns the field startingHour.
   *
   * @return the field startingHour.
   */
  int getStartingHour();

  /**
   * Sets the new value for the field startingHour.
   *
   * @param startingHour new value for the field startingHour.
   */
  void setStartingHour(int startingHour);

  /**
   * Returns the field endingDay.
   *
   * @return the field endingDay.
   */
  DayOfWeek getEndingDay();

  /**
   * Sets the new value for the field endingDay.
   *
   * @param endingDay new value for the field endingDay.
   */
  void setEndingDay(DayOfWeek endingDay);

  /**
   * Returns the field endingHour.
   *
   * @return the field endingHour.
   */
  int getEndingHour();

  /**
   * Sets the new value for the field endingHour.
   *
   * @param endingHour new value for the field endingHour.
   */
  void setEndingHour(int endingHour);

}
