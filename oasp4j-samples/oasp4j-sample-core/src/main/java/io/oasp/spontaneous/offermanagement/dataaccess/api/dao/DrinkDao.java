package io.oasp.spontaneous.offermanagement.dataaccess.api.dao;

import io.oasp.module.jpa.dataaccess.api.MasterDataDao;
import io.oasp.spontaneous.general.dataaccess.api.dao.ApplicationRevisionedDao;
import io.oasp.spontaneous.offermanagement.dataaccess.api.DrinkEntity;

/**
 * {@link ApplicationRevisionedDao Data Access Object} for {@link DrinkEntity}.
 *
 * @author hohwille
 */
public interface DrinkDao extends ApplicationRevisionedDao<DrinkEntity>, MasterDataDao<DrinkEntity> {

}
