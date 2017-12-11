package jie.iaa.bom.FinancialTransaction;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentDueSettlement {
	private Long id;
	private Long paymentDueId;
	private Long paymentId;
	private Long orderId;
	private BigDecimal amount;
	private String type;
	private Date postedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPaymentDueId() {
		return paymentDueId;
	}

	public void setPaymentDueId(Long paymentDueId) {
		this.paymentDueId = paymentDueId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
}
