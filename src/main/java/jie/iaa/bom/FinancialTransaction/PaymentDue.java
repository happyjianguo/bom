package jie.iaa.bom.FinancialTransaction;

import java.math.BigDecimal;
import java.util.Date;

import jie.iaa.bom.FinancialTransaction.utils.FinancialTransactionConstants;

public class PaymentDue extends FinancialTransaction {
	private Date dueDate; // 应付款时间
	// 固定周期的paymentDue
	private Date paymentDuePeriodStartDate;
	private Date paymentDuePeriodEndDate;
	private Date writtenOfDate; // 注销时间
	private BigDecimal outstandingAmount; // 未偿还金额
	private String state = FinancialTransactionConstants.PaymentDueStateDue; // PaymentDueSettlement操作状态机

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDuePeriodStartDate() {
		return paymentDuePeriodStartDate;
	}

	public void setPaymentDuePeriodStartDate(Date paymentDuePeriodStartDate) {
		this.paymentDuePeriodStartDate = paymentDuePeriodStartDate;
	}

	public Date getPaymentDuePeriodEndDate() {
		return paymentDuePeriodEndDate;
	}

	public void setPaymentDuePeriodEndDate(Date paymentDuePeriodEndDate) {
		this.paymentDuePeriodEndDate = paymentDuePeriodEndDate;
	}

	public Date getWrittenOfDate() {
		return writtenOfDate;
	}

	public void setWrittenOfDate(Date writtenOfDate) {
		this.writtenOfDate = writtenOfDate;
	}

	public BigDecimal getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(BigDecimal outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
