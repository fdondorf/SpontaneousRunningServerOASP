package io.oasp.spontaneous.offermanagement.dataaccess.impl.dao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.general.common.api.datatype.Money;
import io.oasp.spontaneous.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.spontaneous.offermanagement.common.api.datatype.DayOfWeek;
import io.oasp.spontaneous.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.spontaneous.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.spontaneous.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.spontaneous.offermanagement.logic.api.to.WeeklyPeriodSearchCriteriaTo;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

/**
 * This is the implementation of {@link SpecialDao}.
 */
@Named
public class SpecialDaoImpl extends ApplicationDaoImpl<SpecialEntity> implements SpecialDao {

  /**
   * The constructor.
   */
  public SpecialDaoImpl() {

    super();
  }

  @Override
  public Class<SpecialEntity> getEntityClass() {

    return SpecialEntity.class;
  }

  @Override
  public PaginatedListTo<SpecialEntity> findSpecials(SpecialSearchCriteriaTo criteria) {

    SpecialEntity special = Alias.alias(SpecialEntity.class);
    EntityPathBase<SpecialEntity> alias = Alias.$(special);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long offer = criteria.getOfferId();
    if (offer != null) {
      query.where(Alias.$(special.getOfferId()).eq(offer));
    }

    WeeklyPeriodSearchCriteriaTo weeklyPeriod = criteria.getActivePeriod();
    if (weeklyPeriod != null) {
      DayOfWeek startingDay = weeklyPeriod.getStartingDay();
      if (startingDay != null) {
        query.where(Alias.$(special.getActivePeriod().getStartingDay()).eq(startingDay));
      }

      Integer startingHour = weeklyPeriod.getStartingHour();
      if (startingHour != null) {
        query.where(Alias.$(special.getActivePeriod().getStartingHour()).eq(startingHour));
      }

      DayOfWeek endingDay = weeklyPeriod.getEndingDay();
      if (endingDay != null) {
        query.where(Alias.$(special.getActivePeriod().getEndingDay()).eq(endingDay));
      }

      Integer endingHour = weeklyPeriod.getEndingHour();
      if (endingHour != null) {
        query.where(Alias.$(special.getActivePeriod().getEndingHour()).eq(endingHour));
      }
    }

    Money specialPrice = criteria.getSpecialPrice();
    if (specialPrice != null) {
      query.where(Alias.$(special.getSpecialPrice()).eq(specialPrice));
    }

    return findPaginated(criteria, query, alias);
  }

}
