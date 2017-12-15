package jie.iaa.bom.AccountAndFund.Service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

import jie.iaa.bom.AccountAndFund.AccountEntry;
import jie.iaa.bom.AccountAndFund.AssetAccount;
import jie.iaa.bom.AccountAndFund.AssetHolding;
import jie.iaa.bom.AccountAndFund.AssetHoldingDetail;
import jie.iaa.bom.AccountAndFund.CostAccount;
import jie.iaa.bom.AccountAndFund.EquityAccount;
import jie.iaa.bom.AccountAndFund.Fund;
import jie.iaa.bom.AccountAndFund.IncomeAccount;
import jie.iaa.bom.AccountAndFund.LiabilityAccount;
import jie.iaa.bom.AccountAndFund.MonetaryAccount;
import jie.iaa.bom.AccountAndFund.utils.AccountAndFundConstants;

@Component
public class AccountAndFundService {
	/**
	 * 复式记账
	 * 
	 * @param monetaryAccount
	 *            货币（资金）账户
	 * @param clientId
	 * @param debitCreditIndicator
	 *            DR/CR
	 * @param amount
	 *            资金金额
	 * @return AccountEntry
	 * @throws Exception
	 */
	public AccountEntry accounting(MonetaryAccount monetaryAccount, Long clientId, String debitCreditIndicator,
			BigDecimal amount) throws Exception {
		if (!clientId.equals(monetaryAccount.getClientId()))
			throw new Exception("clientId can NOT be inconsistent");

		// 计算DebitCredit对应的+/-方向
		BigDecimal factor = null;
		switch (debitCreditIndicator) {
		// DR
		case AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit:
			if (monetaryAccount instanceof AssetAccount || monetaryAccount instanceof CostAccount)
				factor = BigDecimal.valueOf(1);
			else if (monetaryAccount instanceof EquityAccount || monetaryAccount instanceof LiabilityAccount
					|| monetaryAccount instanceof IncomeAccount)
				factor = BigDecimal.valueOf(-1);
			break;
		// CR
		case AccountAndFundConstants.AccountEntryDebitCreditIndicatorCredit:
			if (monetaryAccount instanceof AssetAccount || monetaryAccount instanceof CostAccount)
				factor = BigDecimal.valueOf(-1);
			else if (monetaryAccount instanceof EquityAccount || monetaryAccount instanceof LiabilityAccount
					|| monetaryAccount instanceof IncomeAccount)
				factor = BigDecimal.valueOf(1);
			break;
		}
		BigDecimal addAmount = amount.multiply(factor);
		// 更新货币（资金）余额
		monetaryAccount.setBalance(monetaryAccount.getBalance().add(addAmount));

		AccountEntry ret = new AccountEntry();
		ret.setClientId(clientId);
		ret.setAmount(amount);
		ret.setPostedDate(new Date());
		ret.setDebitCreditIndicator(debitCreditIndicator);
		ret.maintainEntryOfAccount(monetaryAccount.getId());
		return ret;
	}

	/**
	 * 基金记账
	 * 
	 * @param assetHolding
	 *            基金账户
	 * @param fund
	 * @param clientId
	 * @param debitCreditIndicator
	 *            DR/CR
	 * @param quantity
	 *            资金金额（扣除申购费）
	 * @return AssetHoldingDetail
	 * @throws Exception
	 */
	public AssetHoldingDetail accounting(AssetHolding assetHolding, Fund fund, Long clientId,
			String debitCreditIndicator, BigDecimal amount) throws Exception {
		if (!clientId.equals(assetHolding.getClientId()))
			throw new Exception("clientId can NOT be inconsistent");
		if (!assetHolding.getFinancialAssetId().equals(fund.getId()))
			throw new Exception("fundId can NOT be inconsistent");

		// 计算DebitCredit对应的+/-方向
		BigDecimal factor = null;
		switch (debitCreditIndicator) {
		// DR
		case AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit:
			factor = BigDecimal.valueOf(1);
			break;
		// CR
		case AccountAndFundConstants.AccountEntryDebitCreditIndicatorCredit:
			factor = BigDecimal.valueOf(-1);
		}
		BigDecimal addQuantity = (amount.divide(fund.getNet(), 4, BigDecimal.ROUND_UP)).multiply(factor);
		// 更新确认份额及持有金额
		assetHolding.setQuantity(assetHolding.getQuantity().add(addQuantity));
		assetHolding.setHoldingValue(assetHolding.getHoldingValue().add(amount));

		AssetHoldingDetail ret = new AssetHoldingDetail();
		ret.setClientId(clientId);
		ret.setAmount(amount);
		ret.setPostedDate(new Date());
		ret.setDebitCreditIndicator(debitCreditIndicator);
		ret.maintainEntryOfAccount(assetHolding.getId());
		ret.setQuantity(addQuantity);
		return ret;
	}
}
