package io.oasp.spontaneous.salesmanagement.logic.impl.paymentadapter.impl;

import io.oasp.spontaneous.general.common.base.AbstractBeanMapperSupport;
import io.oasp.spontaneous.salesmanagement.common.api.datatype.PaymentStatus;
import io.oasp.spontaneous.salesmanagement.logic.impl.paymentadapter.PaymentAdapter;
import io.oasp.spontaneous.salesmanagement.logic.impl.paymentadapter.PaymentTransactionData;

import javax.inject.Named;

/**
 * Implementation of the external payment functionalities.
 *
 * @author etomety
 */
@Named
public class PaymentAdapterImpl extends AbstractBeanMapperSupport implements PaymentAdapter {

  @Override
  public PaymentStatus pay(PaymentTransactionData paymentTransactionData) {

    return PaymentStatus.SUCCESS;

    // return dozer.map(statusTo, PaymentStatus.class);
  }

}
