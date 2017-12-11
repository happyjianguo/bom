package jie.iaa.bom.FinancialTransaction.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import jie.iaa.bom.FinancialTransaction.Payment;
import jie.iaa.bom.FinancialTransaction.PaymentDue;
import jie.iaa.bom.FinancialTransaction.PaymentDueSettlement;
import jie.iaa.bom.FinancialTransaction.repository.IFinancialTransactionRepository;

@Component
public class DemoFinancialTransactionRepository implements IFinancialTransactionRepository {
	private Map<String, Object> map = new HashMap<String, Object>();
	private static Long id = 1L;

	@Override
	public void saveOnePaymentDue(PaymentDue lhs) {
		if (lhs.getId() == null)
			lhs.setId(id++);
		map.put("PaymentDue" + lhs.getId(), lhs);
	}

	@Override
	public void saveOnePayment(Payment lhs) {
		if (lhs.getId() == null)
			lhs.setId(id++);
		map.put("Payment" + lhs.getId(), lhs);
	}

	@Override
	public void saveOnePaymentDueSettlement(PaymentDueSettlement lhs) {
		if (lhs.getId() == null)
			lhs.setId(id++);
		map.put("PaymentDueSettlement" + lhs.getId(), lhs);
	}

	@Override
	public PaymentDue findOnePaymentDue(Long id) {
		return (PaymentDue) map.get("PaymentDue" + id);
	}

	@Override
	public Payment findOnePayment(Long id) {
		return (Payment) map.get("Payment" + id);
	}

	@Override
	public PaymentDueSettlement findOnePaymentDueSettlement(Long id) {
		return (PaymentDueSettlement) map.get("PaymentDueSettlement" + id);
	}
}
