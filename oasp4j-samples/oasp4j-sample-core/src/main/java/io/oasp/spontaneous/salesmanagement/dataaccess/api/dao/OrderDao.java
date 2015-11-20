package io.oasp.spontaneous.salesmanagement.dataaccess.api.dao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.spontaneous.salesmanagement.dataaccess.api.OrderEntity;
import io.oasp.spontaneous.salesmanagement.logic.api.to.OrderSearchCriteriaTo;

import java.util.List;

/**
 * {@link ApplicationDao Data Access Object} for {@link OrderEntity} entity.
 *
 * @author hohwille
 * @author rjoeris
 */
public interface OrderDao extends ApplicationDao<OrderEntity> {

  /**
   * @param tableId the {@link io.oasp.spontaneous.tablemanagement.dataaccess.api.TableEntity#getNumber()
   *        table ID} for which the open {@link OrderEntity} is requested.
   * @return the {@link OrderEntity} with the given {@link OrderEntity#getTableId() table ID} in
   *         {@link OrderEntity#getState() state}
   *         {@link io.oasp.spontaneous.salesmanagement.common.api.datatype.OrderState#OPEN} or
   *         {@code null} if no such entity exists.
   */
  OrderEntity findOpenOrderByTable(long tableId);

  /**
   * Finds the {@link OrderEntity orders} matching the given {@link OrderSearchCriteriaTo}.
   *
   * @param criteria is the {@link OrderSearchCriteriaTo}.
   * @return the {@link List} with the matching {@link OrderEntity} objects.
   */
  PaginatedListTo<OrderEntity> findOrders(OrderSearchCriteriaTo criteria);

}
