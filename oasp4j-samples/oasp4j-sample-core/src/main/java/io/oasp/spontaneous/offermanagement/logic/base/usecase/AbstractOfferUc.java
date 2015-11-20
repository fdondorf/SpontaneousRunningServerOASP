package io.oasp.spontaneous.offermanagement.logic.base.usecase;

import io.oasp.spontaneous.general.logic.base.AbstractUc;
import io.oasp.spontaneous.offermanagement.dataaccess.api.dao.OfferDao;

import javax.inject.Inject;

/**
 * Abstract use case for Offers, which provides access to the commonly necessary data access objects.
 */
public class AbstractOfferUc extends AbstractUc {

  /** @see #getOfferDao() */
  private OfferDao offerDao;

  /**
   * Returns the field 'offerDao'.
   * 
   * @return the {@link OfferDao} instance.
   */
  public OfferDao getOfferDao() {

    return this.offerDao;
  }

  /**
   * Sets the field 'offerDao'.
   * 
   * @param offerDao New value for offerDao
   */
  @Inject
  public void setOfferDao(OfferDao offerDao) {

    this.offerDao = offerDao;
  }

}
