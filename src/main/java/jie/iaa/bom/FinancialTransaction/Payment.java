package jie.iaa.bom.FinancialTransaction;

import java.util.Date;

public class Payment extends FinancialTransaction {
	private Date paymentDate; // 付款时间
	private Date valueDate; // 资金到账时间

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
}
