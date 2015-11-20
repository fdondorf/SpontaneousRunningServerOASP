package io.oasp.spontaneous.salesmanagement.websocket;

import io.oasp.spontaneous.salesmanagement.common.api.datatype.OrderPositionState;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PositionStatusChangeTo {
  private Long id;

  private OrderPositionState status;

  @JsonCreator
  public PositionStatusChangeTo(@JsonProperty("id") Long id, @JsonProperty("status") OrderPositionState status) {

    this.id = id;
    this.status = status;
  }

  /**
   * @return id
   */
  public Long getId() {

    return this.id;
  }

  /**
   * @return OrderPosition status
   */
  public OrderPositionState getStatus() {

    return this.status;
  }
}
