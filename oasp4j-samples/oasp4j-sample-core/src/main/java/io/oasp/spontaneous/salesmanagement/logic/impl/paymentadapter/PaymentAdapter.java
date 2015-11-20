package io.oasp.spontaneous.salesmanagement.logic.impl.paymentadapter;

import io.oasp.spontaneous.salesmanagement.common.api.datatype.PaymentStatus;

/**
 * Interface of the adapter for external payment.
 * 
 * @author etomety
 */
public interface PaymentAdapter {

  /**
   * @param paymentTransactionData paymentTransactionData
   * @return PaymentStatus
   */
  PaymentStatus pay(PaymentTransactionData paymentTransactionData);
}
