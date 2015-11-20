package io.oasp.spontaneous.offermanagement.dataaccess.impl.dao;

import io.oasp.spontaneous.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.spontaneous.offermanagement.dataaccess.api.DrinkEntity;
import io.oasp.spontaneous.offermanagement.dataaccess.api.dao.DrinkDao;

import javax.inject.Named;

/**
 * Implementation of {@link DrinkDao}.
 *
 * @author hohwille
 */
@Named
public class DrinkDaoImpl extends ApplicationMasterDataDaoImpl<DrinkEntity> implements DrinkDao {

  /**
   * The constructor.
   */
  public DrinkDaoImpl() {

    super();
  }

  @Override
  protected Class<DrinkEntity> getEntityClass() {

    return DrinkEntity.class;
  }

}
