package io.oasp.spontaneous.offermanagement.dataaccess.api.dao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.spontaneous.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.spontaneous.offermanagement.logic.api.to.SpecialSearchCriteriaTo;

/**
 * Data access interface for Special entities
 */
public interface SpecialDao extends ApplicationDao<SpecialEntity> {

  /**
   * Finds the {@link SpecialEntity specials} matching the given {@link SpecialSearchCriteriaTo}.
   *
   * @param criteria is the {@link SpecialSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link SpecialEntity} objects.
   */
  PaginatedListTo<SpecialEntity> findSpecials(SpecialSearchCriteriaTo criteria);

}
