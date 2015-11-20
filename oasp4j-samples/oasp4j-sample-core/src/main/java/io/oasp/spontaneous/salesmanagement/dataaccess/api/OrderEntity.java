/**
 *
 */
package io.oasp.spontaneous.salesmanagement.dataaccess.api;

import io.oasp.spontaneous.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.spontaneous.salesmanagement.common.api.Order;
import io.oasp.spontaneous.salesmanagement.common.api.datatype.OrderState;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * {@link ApplicationPersistenceEntity Entity} that represents an {@link Order} of a customer associated with the
 * according {@link io.oasp.spontaneous.tablemanagement.dataaccess.api.TableEntity}.
 *
 * @author rjoeris
 */
@Entity(name = "Order")
// Order is a reserved word in SQL/RDBMS and can not be used as table name
@Table(name = "RestaurantOrder")
public class OrderEntity extends ApplicationPersistenceEntity implements Order {

  private static final long serialVersionUID = 1L;

  private long tableId;

  private OrderState state;

  /**
   * The constructor.
   */
  public OrderEntity() {

    super();
    this.state = OrderState.OPEN;
  }

  @Override
  @Column(name = "table_id")
  public long getTableId() {

    return this.tableId;
  }

  @Override
  public void setTableId(long tableId) {

    this.tableId = tableId;
  }

  @Override
  public OrderState getState() {

    return this.state;
  }

  @Override
  public void setState(OrderState state) {

    this.state = state;
  }

}
