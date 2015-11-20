package io.oasp.spontaneous.salesmanagement.logic.base.usecase;

import io.oasp.spontaneous.general.logic.base.AbstractUc;
import io.oasp.spontaneous.salesmanagement.dataaccess.api.dao.BillDao;

import javax.inject.Inject;

/**
 *
 * @author mbrunnli
 */
public abstract class AbstractBillUc extends AbstractUc {

  /** @see #getBillDao() */
  private BillDao billDao;

  /**
   * @return the {@link BillDao} instance.
   */
  public BillDao getBillDao() {

    return this.billDao;
  }

  /**
   * Sets the field 'billDao'.
   *
   * @param billDao New value for billDao
   */
  @Inject
  public void setBillDao(BillDao billDao) {

    this.billDao = billDao;
  }

}
