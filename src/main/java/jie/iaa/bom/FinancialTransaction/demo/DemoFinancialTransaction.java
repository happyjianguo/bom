package jie.iaa.bom.FinancialTransaction.demo;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import jie.iaa.bom.FinancialTransaction.Payment;
import jie.iaa.bom.FinancialTransaction.PaymentDue;
import jie.iaa.bom.FinancialTransaction.PaymentDueSettlement;
import jie.iaa.bom.FinancialTransaction.repository.IFinancialTransactionRepository;
import jie.iaa.bom.FinancialTransaction.service.FinancialTransactionService;
import jie.iaa.bom.FinancialTransaction.utils.FinancialTransactionConstants;

public class DemoFinancialTransaction {
	public static void main(String[] args) {
		// 业务订单号
		Long orderId = 10086L;

		// 订单+供应商信息=>PaymentDue
		Long paymentDueId = createPaymentDue(orderId).getId();
		PaymentDue paymentDue = repo.findOnePaymentDue(paymentDueId);
		// mock用户完成支付订单
		// 订单+供应商支付（成功）回调信息=>Payment
		Long paymentId = createPayment(orderId).getId();
		Payment payment = repo.findOnePayment(paymentId);
		// settle
		try {
			PaymentDueSettlement paymentDueSettlement = svs.settle(payment, paymentDue);
			repo.saveOnePayment(payment);
			repo.saveOnePaymentDue(paymentDue);
			repo.saveOnePaymentDueSettlement(paymentDueSettlement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static IFinancialTransactionRepository repo = new DemoFinancialTransactionRepository();
	private static FinancialTransactionService svs = new FinancialTransactionService();

	private static Long payeeAccountId = 10086L; // 供应商账户ID
	private static Long payorAccountId = 999L; // 用户账户ID
	private static Long organisationId = 10000L; // 供应商的组织ID
	private static BigDecimal dueAmount = BigDecimal.valueOf(100);

	/** PaymentDue */
	private static PaymentDue createPaymentDue(Long orderId) {
		Date now = new Date();
		PaymentDue ret = new PaymentDue();
		ret.setAmount(dueAmount);
		ret.setPaymentMethod(FinancialTransactionConstants.FinancialTransactionPaymentMethodAliPay);
		ret.setPayeeAccountId(payeeAccountId);
		ret.setOrderId(orderId);
		ret.setOrganisationId(organisationId);
		ret.setDueDate(DateUtils.addMinutes(now, 30));
		ret.setOutstandingAmount(dueAmount);

		repo.saveOnePaymentDue(ret);
		return ret;
	}

	/** Payment */
	private static Payment createPayment(Long orderId) {
		Date now = new Date();
		Payment ret = new Payment();
		ret.setAmount(BigDecimal.valueOf(70));
		ret.setPaymentMethod(FinancialTransactionConstants.FinancialTransactionPaymentMethodAliPay);
		ret.setPayorAccountId(payorAccountId);
		ret.setOrderId(orderId);
		ret.setOrganisationId(organisationId);
		ret.setPaymentDate(now);
		ret.setValueDate(now);
		ret.setStatus(FinancialTransactionConstants.FinancialTransactionStatusCompleted);

		repo.saveOnePayment(ret);
		return ret;
	}
}
