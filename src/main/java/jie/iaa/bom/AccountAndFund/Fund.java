package jie.iaa.bom.AccountAndFund;

import java.math.BigDecimal;

import jie.iaa.bom.AccountAndFund.utils.AccountAndFundConstants;

public class Fund extends FinancialAsset {
	private String fundCode; // 基金代码
	private BigDecimal net; // 最新净值（元）。TODO

	public Fund() {
		super.type = AccountAndFundConstants.FinancialAssetTypeFund;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public BigDecimal getNet() {
		return net;
	}

	public void setNet(BigDecimal net) {
		this.net = net;
	}
}
