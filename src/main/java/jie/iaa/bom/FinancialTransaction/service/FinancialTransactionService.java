package jie.iaa.bom.FinancialTransaction.service;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import jie.iaa.bom.FinancialTransaction.FinancialTransaction;
import jie.iaa.bom.FinancialTransaction.Payment;
import jie.iaa.bom.FinancialTransaction.PaymentDue;
import jie.iaa.bom.FinancialTransaction.PaymentDueSettlement;
import jie.iaa.bom.FinancialTransaction.utils.FinancialTransactionConstants;

@Component
public class FinancialTransactionService {
	/**
	 * 
	 * @param financialTransaction
	 * @return
	 * @throws Exception
	 */
	public PaymentDueSettlement accounting(FinancialTransaction financialTransaction) throws Exception {
		PaymentDueSettlement ret = new PaymentDueSettlement();
		if (financialTransaction instanceof PaymentDue) {
			PaymentDue paymentDue = (PaymentDue) financialTransaction;
			if (!StringUtils.equals(paymentDue.getState(), FinancialTransactionConstants.PaymentDueStateDue)
					&& !StringUtils.equals(paymentDue.getState(),
							FinancialTransactionConstants.PaymentDueStatePartiallySettled))
				throw new Exception("WRONG paymentDue state: " + paymentDue.getState());

			ret.setType(FinancialTransactionConstants.PaymentDueSettlementTypeDue);
		} else if (financialTransaction instanceof Payment) {
			Payment payment = (Payment) financialTransaction;
			if (!StringUtils.equals(payment.getStatus(),
					FinancialTransactionConstants.FinancialTransactionStatusCompleted))
				throw new Exception("WRONG payment status: " + payment.getStatus());

			ret.setType(FinancialTransactionConstants.PaymentDueSettlementTypePaid);
		}

		Date now = new Date();
		ret.setPaymentId(financialTransaction.getId());
		ret.setAmount(financialTransaction.getAmount());
		ret.setOrderId(financialTransaction.getOrderId());
		ret.setPostedDate(now);
		return ret;
	}

	/**
	 * Due --> PartiallySettled / FullySettled或PartiallySettled --> FullySettled
	 * 
	 * @param payment
	 *            is settled by
	 * @param paymentDue
	 *            settles
	 * @throws Exception
	 */
	public PaymentDueSettlement settle(Payment payment, PaymentDue paymentDue) throws Exception {
		if (payment.getOrderId().compareTo(paymentDue.getOrderId()) != 0)
			throw new Exception("orderId can NOT be inconsistent");

		if (!StringUtils.equals(paymentDue.getState(), FinancialTransactionConstants.PaymentDueStateDue) && !StringUtils
				.equals(paymentDue.getState(), FinancialTransactionConstants.PaymentDueStatePartiallySettled))
			throw new Exception("WRONG paymentDue state: " + paymentDue.getState());

		if (!StringUtils.equals(payment.getStatus(), FinancialTransactionConstants.FinancialTransactionStatusCompleted))
			throw new Exception("WRONG payment status: " + payment.getStatus());

		BigDecimal anAmount = payment.getAmount();
		BigDecimal outstandingAmount = paymentDue.getOutstandingAmount();

		BigDecimal updatedOutstandingAmount = outstandingAmount.subtract(anAmount);
		switch (updatedOutstandingAmount.compareTo(BigDecimal.ZERO)) {
		case 0:
			paymentDue.setState(FinancialTransactionConstants.PaymentDueStateFullySettled);
			paymentDue.setStatus(FinancialTransactionConstants.FinancialTransactionStatusCompleted);
			break;
		case -1:
			// TODO anAmount > outstandingAmount
			paymentDue.setState(FinancialTransactionConstants.PaymentDueStateFullySettled);
			paymentDue.setStatus(FinancialTransactionConstants.FinancialTransactionStatusCompleted);
			break;
		case 1:
			paymentDue.setState(FinancialTransactionConstants.PaymentDueStatePartiallySettled);
			paymentDue.setStatus(FinancialTransactionConstants.FinancialTransactionStatusRunning);
			break;
		default:
			break;
		}
		Date now = new Date();
		paymentDue.setOutstandingAmount(updatedOutstandingAmount);
		paymentDue.setStatusDate(now);

		PaymentDueSettlement ret = new PaymentDueSettlement();
		ret.setAmount(anAmount);
		ret.setPaymentId(payment.getId());
		ret.setPaymentDueId(paymentDue.getId());
		ret.setOrderId(paymentDue.getOrderId());
		ret.setType(FinancialTransactionConstants.PaymentDueSettlementTypePaid);
		ret.setPostedDate(now);
		return ret;
	}

	/**
	 * Due / PartiallySettled --> WrittenOff
	 * 
	 * @throws Exception
	 */
	public void writeOff(PaymentDue paymentDue) throws Exception {
		String state = paymentDue.getState();
		if (!StringUtils.equals(state, FinancialTransactionConstants.PaymentDueStateDue)
				&& !StringUtils.equals(state, FinancialTransactionConstants.PaymentDueStatePartiallySettled))
			throw new Exception("WRONG paymentDue state: " + state);

		Date now = new Date();
		paymentDue.setState(FinancialTransactionConstants.PaymentDueStateWrittenOff);
		paymentDue.setWrittenOfDate(now);
		paymentDue.setStatus(FinancialTransactionConstants.FinancialTransactionStatusTerminated);
		paymentDue.setStatusDate(now);
		paymentDue.setStatusReason("WrittenOff");
	}
}
