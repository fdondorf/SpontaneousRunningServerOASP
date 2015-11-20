package io.oasp.spontaneous.offermanagement.logic.impl.usecase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.general.logic.api.UseCase;
import io.oasp.spontaneous.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.spontaneous.offermanagement.logic.api.to.SpecialEto;
import io.oasp.spontaneous.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.spontaneous.offermanagement.logic.api.usecase.UcFindSpecial;
import io.oasp.spontaneous.offermanagement.logic.base.usecase.AbstractSpecialUc;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

/**
 * Use case implementation for searching, filtering and getting Specials
 */
@Named
@UseCase
@Validated
public class UcFindSpecialImpl extends AbstractSpecialUc implements UcFindSpecial {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindSpecialImpl.class);

  @Override
  public SpecialEto findSpecial(Long id) {

    LOG.debug("Get Special with id {} from database.", id);
    SpecialEto specialEto = getBeanMapper().map(getSpecialDao().findOne(id), SpecialEto.class);
    return specialEto;
  }

  @Override
  public PaginatedListTo<SpecialEto> findSpecialEtos(SpecialSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<SpecialEntity> specials = getSpecialDao().findSpecials(criteria);
    return mapPaginatedEntityList(specials, SpecialEto.class);
  }

}
