package io.oasp.spontaneous.offermanagement.dataaccess.api.dao;

import io.oasp.module.jpa.dataaccess.api.MasterDataDao;
import io.oasp.spontaneous.general.dataaccess.api.dao.ApplicationRevisionedDao;
import io.oasp.spontaneous.offermanagement.dataaccess.api.MealEntity;

/**
 * {@link ApplicationRevisionedDao Data Access Object} for {@link MealEntity}.
 *
 * @author hohwille
 */
public interface MealDao extends ApplicationRevisionedDao<MealEntity>, MasterDataDao<MealEntity> {

}
