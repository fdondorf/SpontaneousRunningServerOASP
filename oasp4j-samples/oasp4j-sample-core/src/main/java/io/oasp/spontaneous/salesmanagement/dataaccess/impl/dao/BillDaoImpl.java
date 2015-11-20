package io.oasp.spontaneous.salesmanagement.dataaccess.impl.dao;

import io.oasp.spontaneous.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.spontaneous.salesmanagement.dataaccess.api.BillEntity;
import io.oasp.spontaneous.salesmanagement.dataaccess.api.dao.BillDao;

import javax.inject.Named;

/**
 * Implementation of {@link BillDao}.
 *
 * @author jozitz
 */
@Named
public class BillDaoImpl extends ApplicationDaoImpl<BillEntity> implements BillDao {

  @Override
  public Class<BillEntity> getEntityClass() {

    return BillEntity.class;
  }

}
