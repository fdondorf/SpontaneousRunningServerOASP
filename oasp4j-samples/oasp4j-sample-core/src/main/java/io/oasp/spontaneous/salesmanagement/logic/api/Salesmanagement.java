package io.oasp.spontaneous.salesmanagement.logic.api;

import io.oasp.spontaneous.salesmanagement.logic.api.usecase.UcChangeTable;
import io.oasp.spontaneous.salesmanagement.logic.api.usecase.UcFindBill;
import io.oasp.spontaneous.salesmanagement.logic.api.usecase.UcFindOrder;
import io.oasp.spontaneous.salesmanagement.logic.api.usecase.UcFindOrderPosition;
import io.oasp.spontaneous.salesmanagement.logic.api.usecase.UcManageBill;
import io.oasp.spontaneous.salesmanagement.logic.api.usecase.UcManageOrder;
import io.oasp.spontaneous.salesmanagement.logic.api.usecase.UcManageOrderPosition;

/**
 * This is the interface for the {@link Salesmanagement} component of the application core.
 *
 * @author hohwille
 */
public interface Salesmanagement extends UcChangeTable, UcFindBill, UcFindOrder, UcFindOrderPosition, UcManageBill,
    UcManageOrder, UcManageOrderPosition {

}
