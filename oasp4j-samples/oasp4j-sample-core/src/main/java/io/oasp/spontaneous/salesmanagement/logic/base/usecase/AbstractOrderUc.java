package io.oasp.spontaneous.salesmanagement.logic.base.usecase;

import io.oasp.spontaneous.general.logic.base.AbstractUc;
import io.oasp.spontaneous.salesmanagement.dataaccess.api.dao.OrderDao;

import javax.inject.Inject;

/**
 *
 * @author mbrunnli
 */
public abstract class AbstractOrderUc extends AbstractUc {

  /** @see #getOrderDao() */
  private OrderDao orderDao;

  /**
   * @return orderDao
   */
  public OrderDao getOrderDao() {

    return this.orderDao;
  }

  /**
   * Sets the field 'orderPositionDao'.
   *
   * @param orderDao New value for orderDao
   */
  @Inject
  public void setOrderDao(OrderDao orderDao) {

    this.orderDao = orderDao;
  }

}
