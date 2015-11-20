package io.oasp.spontaneous.offermanagement.dataaccess.impl.dao;

import io.oasp.spontaneous.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.spontaneous.offermanagement.dataaccess.api.SideDishEntity;
import io.oasp.spontaneous.offermanagement.dataaccess.api.dao.SideDishDao;

import javax.inject.Named;

/**
 * Implementation of {@link SideDishDao}.
 *
 * @author hohwille
 */
@Named
public class SideDishDaoImpl extends ApplicationMasterDataDaoImpl<SideDishEntity> implements SideDishDao {

  /**
   * The constructor.
   */
  public SideDishDaoImpl() {

    super();
  }

  @Override
  protected Class<SideDishEntity> getEntityClass() {

    return SideDishEntity.class;
  }

}
