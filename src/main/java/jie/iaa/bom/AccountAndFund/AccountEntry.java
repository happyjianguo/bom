package jie.iaa.bom.AccountAndFund;

import java.math.BigDecimal;
import java.util.Date;

public class AccountEntry {
	protected Long id;
	protected Long clientId;
	protected Long accountId; // has (Account)
	protected BigDecimal amount; // 资金金额
	protected Date postedDate;
	protected String debitCreditIndicator; // AccountEntry.debitCreditIndicator.enum
	protected String description;

	/**
	 * 维护Account和AccountEntry的关联关系entry of account
	 * 
	 * @param accountId
	 *            has (Account)
	 */
	public void maintainEntryOfAccount(Long accountId) {
		this.accountId = accountId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getAccountId() {
		return accountId;
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

	public String getDebitCreditIndicator() {
		return debitCreditIndicator;
	}

	public void setDebitCreditIndicator(String debitCreditIndicator) {
		this.debitCreditIndicator = debitCreditIndicator;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
