package io.oasp.spontaneous.salesmanagement.logic.api.usecase;

import io.oasp.spontaneous.salesmanagement.logic.api.to.OrderEto;
import io.oasp.spontaneous.tablemanagement.logic.api.to.TableEto;

/**
 * Interface of {@link io.oasp.spontaneous.general.logic.base.AbstractUc use case} to
 * {@link #changeTable(long, long) change the table}.
 *
 * Interface of UcChangeTable to centralize documentation and signatures of methods.
 *
 * @author mvielsac
 */
public interface UcChangeTable {

  /**
   * UseCase to change from one {@link TableEto table} to another. The people sitting at a table are identified by their
   * {@link OrderEto order} that has to be provided as argument.
   *
   * @param orderId the {@link OrderEto order}
   * @param newTableId the new {@link TableEto table} to switch to.
   */
  void changeTable(long orderId, long newTableId);

}
