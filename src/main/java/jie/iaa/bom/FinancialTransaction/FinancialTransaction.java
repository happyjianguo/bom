package jie.iaa.bom.FinancialTransaction;

import java.math.BigDecimal;
import java.util.Date;

import jie.iaa.bom.FinancialTransaction.utils.FinancialTransactionConstants;

public abstract class FinancialTransaction {
	protected Long id;
	protected BigDecimal amount; // 金额
	protected Date postedDate; // 创建时间
	protected String status = FinancialTransactionConstants.FinancialTransactionStatusPosted;
	protected Date statusDate;
	protected String statusReason;
	protected String paymentMethod; // 支付方式
	protected String description;
	protected Long payorAccountId; // 付款账户ID
	protected Long payeeAccountId; // 收款账户ID
	protected Long orderId; // 订单号
	protected Long organisationId; // 组织ID

	public FinancialTransaction() {
		Date now = new Date();
		postedDate = now;
		statusDate = now;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPayorAccountId() {
		return payorAccountId;
	}

	public void setPayorAccountId(Long payorAccountId) {
		this.payorAccountId = payorAccountId;
	}

	public Long getPayeeAccountId() {
		return payeeAccountId;
	}

	public void setPayeeAccountId(Long payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(Long organisationId) {
		this.organisationId = organisationId;
	}
}
