package jie.iaa.bom.AccountAndFund;

import java.math.BigDecimal;

public class MonetaryAccount extends Account {
	protected String subject; // 会计科目类别。Account subject enum
	protected BigDecimal balance; // 货币（资金）余额。即AccountEntry所有amount的余额

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
