package io.oasp.spontaneous.offermanagement.dataaccess.api;

import io.oasp.spontaneous.offermanagement.common.api.WeeklyPeriod;
import io.oasp.spontaneous.offermanagement.common.api.datatype.DayOfWeek;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Weekly period describing a starting and an ending point. Each is defined as a fixed hour (24h-format) at a specific
 * day of week.
 *
 * @author mbrunnli
 */
@Embeddable
public class WeeklyPeriodEmbeddable implements WeeklyPeriod {

  private DayOfWeek startingDay;

  private int startingHour;

  private DayOfWeek endingDay;

  private int endingHour;

  /**
   * Returns the {@link DayOfWeek} the period starts.
   *
   * @return startingDay the {@link DayOfWeek} the period starts.
   */
  @Override
  @Enumerated(EnumType.STRING)
  public DayOfWeek getStartingDay() {

    return this.startingDay;
  }

  /**
   * Sets the {@link DayOfWeek} the period starts.
   *
   * @param startingDay the {@link DayOfWeek} the period starts.
   */
  @Override
  public void setStartingDay(DayOfWeek startingDay) {

    this.startingDay = startingDay;
  }

  /**
   * Returns the hour (in 24h-format) the period starts.
   *
   * @return startingHour the hour (in 24h-format) the period starts.
   */
  @Override
  @Max(24)
  @Min(0)
  public int getStartingHour() {

    return this.startingHour;
  }

  /**
   * Sets the hour (in 24h-format) the period starts.
   *
   * @param startingHour the hour (in 24h-format) the period starts.
   */
  @Override
  public void setStartingHour(int startingHour) {

    this.startingHour = startingHour;
  }

  /**
   * Returns the {@link DayOfWeek} the period ends.
   *
   * @return endingDay the {@link DayOfWeek} the period ends.
   */
  @Override
  @Enumerated(EnumType.STRING)
  public DayOfWeek getEndingDay() {

    return this.endingDay;
  }

  /**
   * Sets the {@link DayOfWeek} the period ends.
   *
   * @param endingDay the {@link DayOfWeek} the period ends.
   */
  @Override
  public void setEndingDay(DayOfWeek endingDay) {

    this.endingDay = endingDay;
  }

  /**
   * Returns the hour (in 24h-format) the period ends.
   *
   * @return endingHour the hour (in 24h-format) the period ends.
   */
  @Override
  @Max(24)
  @Min(0)
  public int getEndingHour() {

    return this.endingHour;
  }

  /**
   * Returns the hour (in 24h-format) the period ends.
   *
   * @param endingHour the hour (in 24h-format) the period ends.
   */
  @Override
  public void setEndingHour(int endingHour) {

    this.endingHour = endingHour;
  }

}
