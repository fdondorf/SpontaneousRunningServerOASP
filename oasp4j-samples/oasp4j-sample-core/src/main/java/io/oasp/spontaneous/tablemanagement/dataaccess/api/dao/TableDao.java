package io.oasp.spontaneous.tablemanagement.dataaccess.api.dao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;
import io.oasp.spontaneous.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.spontaneous.tablemanagement.dataaccess.api.TableEntity;
import io.oasp.spontaneous.tablemanagement.logic.api.to.TableSearchCriteriaTo;

import java.util.List;

/**
 * {@link ApplicationDao Data Access Object} for {@link TableEntity} entity.
 *
 * @author hohwille
 */
public interface TableDao extends ApplicationDao<TableEntity>, MasterDataDao<TableEntity> {

  /**
   * Returns a list of free restaurant tables.
   *
   * @return {@link List} of free restaurant {@link TableEntity}s
   */
  List<TableEntity> getFreeTables();

  /**
   * Finds the {@link TableEntity orders} matching the given {@link TableSearchCriteriaTo}.
   *
   * @param criteria is the {@link TableSearchCriteriaTo}.
   * @return the {@link List} with the matching {@link TableEntity} objects.
   */
  PaginatedListTo<TableEntity> findTables(TableSearchCriteriaTo criteria);

}
