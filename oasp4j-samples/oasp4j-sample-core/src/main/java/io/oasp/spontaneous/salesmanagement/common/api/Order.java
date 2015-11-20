package io.oasp.spontaneous.salesmanagement.common.api;

import io.oasp.spontaneous.general.common.api.ApplicationEntity;
import io.oasp.spontaneous.salesmanagement.common.api.datatype.OrderState;

/**
 * This is the interface for an {@link Order}. It is {@link #getTableId() associated} with a
 * {@link io.oasp.spontaneous.tablemanagement.common.api.Table} and consists of multiple {@link OrderPosition
 * positions}.
 *
 * @author hohwille
 */
public interface Order extends ApplicationEntity {

  /**
   * @return the {@link io.oasp.spontaneous.tablemanagement.common.api.Table#getId() ID} of the associated
   *         {@link io.oasp.spontaneous.tablemanagement.common.api.Table} where this {@link Order} was
   *         disposed.
   */
  long getTableId();

  /**
   * @param tableId the new {@link #getTableId() tableId}.
   */
  void setTableId(long tableId);

  /**
   * @return the {@link OrderState state} of this {@link Order}.
   */
  OrderState getState();

  /**
   * @param state is the new {@link #getState() state}.
   */
  void setState(OrderState state);
}
