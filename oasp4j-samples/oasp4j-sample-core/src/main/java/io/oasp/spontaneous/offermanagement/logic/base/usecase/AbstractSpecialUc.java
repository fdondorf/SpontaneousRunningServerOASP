package io.oasp.spontaneous.offermanagement.logic.base.usecase;

import io.oasp.spontaneous.general.logic.base.AbstractUc;
import io.oasp.spontaneous.offermanagement.dataaccess.api.dao.SpecialDao;

import javax.inject.Inject;

/**
 * Abstract use case for Specials, which provides access to the commonly necessary data access objects.
 */
public class AbstractSpecialUc extends AbstractUc {

  /** @see #getSpecialDao() */
  private SpecialDao specialDao;

  /**
   * Returns the field 'specialDao'.
   * 
   * @return the {@link SpecialDao} instance.
   */
  public SpecialDao getSpecialDao() {

    return this.specialDao;
  }

  /**
   * Sets the field 'specialDao'.
   * 
   * @param specialDao New value for specialDao
   */
  @Inject
  public void setSpecialDao(SpecialDao specialDao) {

    this.specialDao = specialDao;
  }

}
