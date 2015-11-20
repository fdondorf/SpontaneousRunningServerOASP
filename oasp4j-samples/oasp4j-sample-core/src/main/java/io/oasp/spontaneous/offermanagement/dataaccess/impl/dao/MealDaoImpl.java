package io.oasp.spontaneous.offermanagement.dataaccess.impl.dao;

import io.oasp.spontaneous.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.spontaneous.offermanagement.dataaccess.api.MealEntity;
import io.oasp.spontaneous.offermanagement.dataaccess.api.dao.MealDao;

import javax.inject.Named;

/**
 * Implementation of {@link MealDao}.
 *
 * @author hohwille
 */
@Named
public class MealDaoImpl extends ApplicationMasterDataDaoImpl<MealEntity> implements MealDao {

  /**
   * The constructor.
   */
  public MealDaoImpl() {

    super();
  }

  @Override
  protected Class<MealEntity> getEntityClass() {

    return MealEntity.class;
  }

}
