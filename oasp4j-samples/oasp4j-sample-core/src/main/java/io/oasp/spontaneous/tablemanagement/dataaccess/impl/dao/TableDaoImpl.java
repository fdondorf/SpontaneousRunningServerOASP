package io.oasp.spontaneous.tablemanagement.dataaccess.impl.dao;

import io.oasp.module.jpa.common.api.to.OrderByTo;
import io.oasp.module.jpa.common.api.to.OrderDirection;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.general.common.api.constants.NamedQueries;
import io.oasp.spontaneous.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.spontaneous.tablemanagement.common.api.datatype.TableState;
import io.oasp.spontaneous.tablemanagement.dataaccess.api.TableEntity;
import io.oasp.spontaneous.tablemanagement.dataaccess.api.dao.TableDao;
import io.oasp.spontaneous.tablemanagement.logic.api.to.TableSearchCriteriaTo;

import java.util.List;

import javax.inject.Named;
import javax.persistence.Query;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

/**
 * Implementation of {@link TableDao}.
 *
 * @author hohwille
 */
@Named
public class TableDaoImpl extends ApplicationMasterDataDaoImpl<TableEntity> implements TableDao {

  /**
   * The constructor.
   */
  public TableDaoImpl() {

    super();
  }

  @Override
  public Class<TableEntity> getEntityClass() {

    return TableEntity.class;
  }

  @Override
  public List<TableEntity> getFreeTables() {

    Query query = getEntityManager().createNamedQuery(NamedQueries.GET_FREE_TABLES, TableEntity.class);
    return query.getResultList();
  }

  @Override
  public PaginatedListTo<TableEntity> findTables(TableSearchCriteriaTo criteria) {

    TableEntity table = Alias.alias(TableEntity.class);
    EntityPathBase<TableEntity> alias = Alias.$(table);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long waiterId = criteria.getWaiterId();
    if (waiterId != null) {
      query.where(Alias.$(table.getWaiterId()).eq(waiterId));
    }
    Long number = criteria.getNumber();
    if (number != null) {
      query.where(Alias.$(table.getNumber()).eq(number));
    }
    TableState state = criteria.getState();
    if (state != null) {
      query.where(Alias.$(table.getState()).eq(state));
    }

    // Add order by fields
    addOrderBy(query, alias, table, criteria.getSort());

    return findPaginated(criteria, query, alias);
  }

  private void addOrderBy(JPAQuery query, EntityPathBase<TableEntity> alias, TableEntity table, List<OrderByTo> sort) {

    if (sort != null && !sort.isEmpty()) {
      for (OrderByTo orderEntry : sort) {
        if ("number".equals(orderEntry.getName())) {

          if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
            query.orderBy(Alias.$(table.getNumber()).asc());
          } else {
            query.orderBy(Alias.$(table.getNumber()).desc());
          }

        } else if ("waiterId".equals(orderEntry.getName())) {

          if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
            query.orderBy(Alias.$(table.getWaiterId()).asc());
          } else {
            query.orderBy(Alias.$(table.getWaiterId()).desc());
          }

        } else if ("state".equals(orderEntry.getName())) {

          if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
            query.orderBy(Alias.$(table.getState()).asc());
          } else {
            query.orderBy(Alias.$(table.getState()).desc());
          }

        }

      }
    }

  }

}
