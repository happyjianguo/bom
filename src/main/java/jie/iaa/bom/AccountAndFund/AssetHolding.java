package jie.iaa.bom.AccountAndFund;

import java.math.BigDecimal;

public class AssetHolding extends Account {
	private Long financialAssetId; // holds
	private BigDecimal quantity; // 确认份额（份）。即AssetHoldingDetail所有quantity的余额
	private BigDecimal holdingValue; // 持有金额（元）。随时间变化

	/**
	 * 维护FinancialAsset和AssetHolding的关联关系holding of asset
	 * 
	 * @param financialAssetId
	 *            holds
	 */
	public void maintainHoldingOfAsset(Long financialAssetId) {
		this.financialAssetId = financialAssetId;
	}

	public Long getFinancialAssetId() {
		return financialAssetId;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getHoldingValue() {
		return holdingValue;
	}

	public void setHoldingValue(BigDecimal holdingValue) {
		this.holdingValue = holdingValue;
	}
}
