package io.oasp.spontaneous.general.dataaccess.base.dao;

import io.oasp.module.jpa.dataaccess.api.MutablePersistenceEntity;
import io.oasp.module.jpa.dataaccess.base.AbstractRevisionedDao;
import io.oasp.spontaneous.general.dataaccess.api.dao.ApplicationDao;

import org.springframework.stereotype.Repository;

/**
 * This is the abstract base implementation of {@link ApplicationDao}.
 *
 * @param <ENTITY> is the {@link #getEntityClass() type} of the managed entity.
 *
 * @author hohwille
 */
@Repository
public abstract class ApplicationDaoImpl<ENTITY extends MutablePersistenceEntity<Long>> extends
    AbstractRevisionedDao<ENTITY> implements ApplicationDao<ENTITY> {

  /**
   * The constructor.
   */
  public ApplicationDaoImpl() {

    super();
  }

}