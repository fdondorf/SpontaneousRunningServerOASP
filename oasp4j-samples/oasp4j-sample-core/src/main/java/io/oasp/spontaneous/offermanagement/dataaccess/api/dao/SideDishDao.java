package io.oasp.spontaneous.offermanagement.dataaccess.api.dao;

import io.oasp.module.jpa.dataaccess.api.MasterDataDao;
import io.oasp.spontaneous.general.dataaccess.api.dao.ApplicationRevisionedDao;
import io.oasp.spontaneous.offermanagement.dataaccess.api.SideDishEntity;

/**
 * {@link ApplicationRevisionedDao Data Access Object} for {@link SideDishEntity}.
 *
 * @author hohwille
 */
public interface SideDishDao extends ApplicationRevisionedDao<SideDishEntity>, MasterDataDao<SideDishEntity> {

}
