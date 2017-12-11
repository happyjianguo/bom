package jie.iaa.bom.FinancialTransaction.repository;

import jie.iaa.bom.FinancialTransaction.Payment;
import jie.iaa.bom.FinancialTransaction.PaymentDue;
import jie.iaa.bom.FinancialTransaction.PaymentDueSettlement;

public interface IFinancialTransactionRepository {
	void saveOnePaymentDue(PaymentDue lhs);

	void saveOnePayment(Payment lhs);

	void saveOnePaymentDueSettlement(PaymentDueSettlement lhs);

	PaymentDue findOnePaymentDue(Long id);

	Payment findOnePayment(Long id);

	PaymentDueSettlement findOnePaymentDueSettlement(Long id);
}
