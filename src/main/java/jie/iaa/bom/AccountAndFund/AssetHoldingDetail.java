package jie.iaa.bom.AccountAndFund;

import java.math.BigDecimal;

public class AssetHoldingDetail extends AccountEntry {
	private BigDecimal quantity; // 确认份额（份）。替代super.amount

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
}
