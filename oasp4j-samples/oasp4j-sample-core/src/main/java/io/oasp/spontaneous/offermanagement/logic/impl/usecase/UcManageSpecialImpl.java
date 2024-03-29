package io.oasp.spontaneous.offermanagement.logic.impl.usecase;

import io.oasp.spontaneous.general.logic.api.UseCase;
import io.oasp.spontaneous.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.spontaneous.offermanagement.logic.api.to.SpecialEto;
import io.oasp.spontaneous.offermanagement.logic.api.usecase.UcManageSpecial;
import io.oasp.spontaneous.offermanagement.logic.base.usecase.AbstractSpecialUc;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

/**
 * Use case implementation for modifying and deleting Specials
 */
@Named
@UseCase
@Validated
public class UcManageSpecialImpl extends AbstractSpecialUc implements UcManageSpecial {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageSpecialImpl.class);

  @Override
  public boolean deleteSpecial(Long specialId) {

    SpecialEntity special = getSpecialDao().find(specialId);
    getSpecialDao().delete(special);
    LOG.debug("The special with id '{}' has been deleted.", specialId);
    return true;
  }

  @Override
  public SpecialEto saveSpecial(SpecialEto special) {

    Objects.requireNonNull(special, "special");

    SpecialEntity specialEntity = getBeanMapper().map(special, SpecialEntity.class);

    // initialize, validate specialEntity here if necessary

    getSpecialDao().save(specialEntity);
    LOG.debug("Special with id '{}' has been created.", specialEntity.getId());
    return getBeanMapper().map(specialEntity, SpecialEto.class);
  }

}
