package io.oasp.spontaneous.salesmanagement.logic.base.usecase;

import io.oasp.spontaneous.general.logic.base.AbstractUc;
import io.oasp.spontaneous.salesmanagement.dataaccess.api.dao.OrderPositionDao;

import javax.inject.Inject;

/**
 *
 * @author mbrunnli
 */
public abstract class AbstractOrderPositionUc extends AbstractUc {

  /** @see #getOrderPositionDao() */
  private OrderPositionDao orderPositionDao;

  /**
   * @return the {@link OrderPositionDao} instance.
   */
  public OrderPositionDao getOrderPositionDao() {

    return this.orderPositionDao;
  }

  /**
   * Sets the field 'orderPositionDao'.
   *
   * @param orderPositionDao New value for orderPositionDao
   */
  @Inject
  public void setOrderPositionDao(OrderPositionDao orderPositionDao) {

    this.orderPositionDao = orderPositionDao;
  }

}
