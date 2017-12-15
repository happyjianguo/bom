package jie.iaa.bom.AccountAndFund.demo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jie.iaa.bom.AccountAndFund.Account;
import jie.iaa.bom.AccountAndFund.AccountEntry;
import jie.iaa.bom.AccountAndFund.AssetAccount;
import jie.iaa.bom.AccountAndFund.AssetHolding;
import jie.iaa.bom.AccountAndFund.CostAccount;
import jie.iaa.bom.AccountAndFund.EquityAccount;
import jie.iaa.bom.AccountAndFund.IncomeAccount;
import jie.iaa.bom.AccountAndFund.MonetaryAccount;
import jie.iaa.bom.AccountAndFund.Service.AccountAndFundService;
import jie.iaa.bom.AccountAndFund.repository.IAccountAndFundRepository;
import jie.iaa.bom.AccountAndFund.utils.AccountAndFundConstants;

public class DemoAccountAndFund {
	private static IAccountAndFundRepository repo = new DemoAccountAndFundRepository();
	private static AccountAndFundService svs = new AccountAndFundService();

	private static Long clientId = 10086L;
	/** 申购金额 */
	private static BigDecimal depositAmount = BigDecimal.valueOf(100);
	/** 收益 */
	private static BigDecimal interestAmout = BigDecimal.valueOf(0.01);
	/** 货币基金申购费用 */
	private static BigDecimal mfDepositFeeAmout = BigDecimal.ZERO;

	/** 个人资产（底仓账户） */
	private static AssetAccount assetAccount = createAssetAccount();
	/** 个人权益（银行卡现金） */
	private static EquityAccount equityAccount = createEquityAccount();
	/** 个人收入（底仓账户收益） */
	private static IncomeAccount incomeAccount = createIncomeAccount();
	/** 个人收入（补贴收入） */
	private static IncomeAccount bonusIncomeAccount = createBonusIncomeAccount();
	/** 个人资产（在途资金） */
	private static AssetAccount transitAsset = createTransitAssetAccount();
	/** 个人资产（资金产品） */
	private static AssetAccount monetaryAssetAccount = createMonetaryAssetAccount();
	/** 个人资产（资金产品收益） */
	private static AssetAccount monetaryInterestAssetAccount = createMonetaryInterestAssetAccount();
	/** 个人收入（资金产品收益） */
	private static IncomeAccount monetaryIncomeAccount = createMonetaryIncomeAccount();
	/** 个人费用（申购费用） */
	private static CostAccount costAccount = createCostAccount();

	public static void main(String[] args) {
		try {
			// === 1 货币基金场景 ===
			// 银行卡申购货币基金
			moneyFundScenarioDeposit();
			// 货币基金收益登账
			moneyFundScenarioInterest();

			System.out.println("=== 个人资金/资产账户汇总表 ===");
			List<Account> accounts = repo.findAccounts(clientId);
			for (Account account : accounts) {
				if (account instanceof MonetaryAccount) {
					MonetaryAccount monetaryAccount = (MonetaryAccount) account;
					System.out.println(monetaryAccount.getName() + " 会计科目: " + monetaryAccount.getSubject() + " 余额: "
							+ monetaryAccount.getBalance());
				} else if (account instanceof AssetHolding) {
					AssetHolding assetHolding = (AssetHolding) account;
					System.out.println(assetHolding.getName() + " 确认份额: " + assetHolding.getQuantity() + " 持有金额:"
							+ assetHolding.getHoldingValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** I类银行账户申购（银行卡支付）货币基金 */
	private static void moneyFundScenarioDeposit() throws Exception {
		at101(depositAmount);
		at301(depositAmount);
		at201(depositAmount, mfDepositFeeAmout);
	}

	/** 货币基金收益登账 */
	private static void moneyFundScenarioInterest() throws Exception {
		at203(interestAmout);
	}

	/** AT101 底仓账户-转入 */
	private static void at101(BigDecimal amount) throws Exception {
		System.out.println("=== AT101 底仓账户-转入 ￥" + amount + " ===");
		// 记账规则：A-个人资产（底仓账户） + DR, E-个人权益（银行卡现金） + CR
		AccountEntry assetDepositAccountEntry = svs.accounting(assetAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit, amount);
		System.out.println(assetAccount.getName() + assetAccount.getSubject() + " 余额" + assetAccount.getBalance());
		repo.saveOneAccount(assetAccount);
		repo.saveOneAccountEntry(assetDepositAccountEntry);

		AccountEntry equityDepositAccountEntry = svs.accounting(equityAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorCredit, amount);
		System.out.println(equityAccount.getName() + equityAccount.getSubject() + " 余额" + equityAccount.getBalance());
		repo.saveOneAccount(equityAccount);
		repo.saveOneAccountEntry(equityDepositAccountEntry);
	}

	/** AT102 底仓账户-转出 */
	private static void at102(BigDecimal amount) throws Exception {
		System.out.println("=== AT102 底仓账户-转出：货币基金转出到银行卡 ￥" + amount + " ===");
		// 记账规则：A-个人资产（底仓账户） - CR, E-个人权益（银行卡现金） - DR
		AccountEntry assetWithdrawAccountEntry = svs.accounting(assetAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorCredit, amount);
		System.out.println(assetAccount.getName() + assetAccount.getSubject() + " 余额" + assetAccount.getBalance());
		repo.saveOneAccount(assetAccount);
		repo.saveOneAccountEntry(assetWithdrawAccountEntry);

		AccountEntry equityWithdrawAccountEntry = svs.accounting(equityAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit, amount);
		System.out.println(equityAccount.getName() + equityAccount.getSubject() + " 余额" + equityAccount.getBalance());
		repo.saveOneAccount(equityAccount);
		repo.saveOneAccountEntry(equityWithdrawAccountEntry);
	}

	/** AT103 底仓账户-自然派息 */
	private static void at103(BigDecimal amount) throws Exception {
		System.out.println("=== AT103 底仓账户-自然派息 ￥" + amount + " ===");
		// 记账规则：A-个人资产（底仓账户） + DR, I-个人收入（底仓账户收益） + CR
		AccountEntry assetInterestAccountEntry = svs.accounting(assetAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit, amount);
		System.out.println(assetAccount.getName() + assetAccount.getSubject() + " 余额" + assetAccount.getBalance());
		repo.saveOneAccount(assetAccount);
		repo.saveOneAccountEntry(assetInterestAccountEntry);

		AccountEntry incomeInteresetAccountEntry = svs.accounting(incomeAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorCredit, amount);
		System.out.println(incomeAccount.getName() + incomeAccount.getSubject() + " 余额" + incomeAccount.getBalance());
		repo.saveOneAccount(incomeAccount);
		repo.saveOneAccountEntry(incomeInteresetAccountEntry);
	}

	/** AT104 底仓账户-补偿红包 */
	private static void at104(BigDecimal amount) throws Exception {
		System.out.println("=== AT104 底仓账户-补偿红包 ￥" + amount + " ===");
		// 记账规则：A-个人资产（底仓账户） + DR, I-个人收入（补贴收入） + CR
		AccountEntry assetBonusIncomeAccountEntry = svs.accounting(assetAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit, amount);
		System.out.println(assetAccount.getName() + assetAccount.getSubject() + " 余额" + assetAccount.getBalance());
		repo.saveOneAccount(assetAccount);
		repo.saveOneAccountEntry(assetBonusIncomeAccountEntry);

		AccountEntry incomeBonusAccountEntry = svs.accounting(bonusIncomeAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorCredit, amount);
		System.out.println(bonusIncomeAccount.getName() + bonusIncomeAccount.getSubject() + " 余额"
				+ bonusIncomeAccount.getBalance());
		repo.saveOneAccount(bonusIncomeAccount);
		repo.saveOneAccountEntry(incomeBonusAccountEntry);
	}

	/** 资产-申购（先赎回） */
	private static void at201(BigDecimal amount, BigDecimal fee) throws Exception {
		System.out.println("=== AT201 资产-申购（先赎回） ￥" + amount + " ===");
		// 记账规则：A-个人资产（在途资金） - CR, A-个人资产（资金产品） + DR, C-个人费用（申购费用） + DR
		AccountEntry assetTransitAccountEntry = svs.accounting(transitAsset, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorCredit, amount);
		System.out.println(transitAsset.getName() + transitAsset.getSubject() + " 余额" + transitAsset.getBalance());
		repo.saveOneAccount(transitAsset);
		repo.saveOneAccountEntry(assetTransitAccountEntry);

		AccountEntry transitMonetaryAccountEntry = svs.accounting(monetaryAssetAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit, amount);
		System.out.println(monetaryAssetAccount.getName() + monetaryAssetAccount.getSubject() + " 余额"
				+ monetaryAssetAccount.getBalance());
		repo.saveOneAccount(monetaryAssetAccount);
		repo.saveOneAccountEntry(transitMonetaryAccountEntry);

		AccountEntry costAccountEntry = svs.accounting(costAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit, fee);
		System.out.println(costAccount.getName() + costAccount.getSubject() + " 余额" + costAccount.getBalance());
		repo.saveOneAccount(costAccount);
		repo.saveOneAccountEntry(costAccountEntry);
	}

	/** 资产-收益登账-现金 */
	private static void at203(BigDecimal amount) throws Exception {
		System.out.println("=== AT203 资产-收益登账-现金 ￥" + amount + " ===");
		// 记账规则：A-个人资产（资金产品收益） + DR, I-个人收入（资金产品收益） + CR
		AccountEntry interestMonetaryAccountEntry = svs.accounting(monetaryInterestAssetAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit, amount);
		System.out.println(monetaryInterestAssetAccount.getName() + monetaryInterestAssetAccount.getSubject() + " 余额"
				+ monetaryInterestAssetAccount.getBalance());
		repo.saveOneAccount(monetaryInterestAssetAccount);
		repo.saveOneAccountEntry(interestMonetaryAccountEntry);

		AccountEntry monetaryIncomeInteresetAccountEntry = svs.accounting(monetaryIncomeAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorCredit, amount);
		System.out.println(monetaryIncomeAccount.getName() + monetaryIncomeAccount.getSubject() + " 余额"
				+ monetaryIncomeAccount.getBalance());
		repo.saveOneAccount(monetaryIncomeAccount);
		repo.saveOneAccountEntry(monetaryIncomeInteresetAccountEntry);
	}

	/** 资产-收益登账-累计升息 */
	private static void at204(BigDecimal amount) throws Exception {
		System.out.println("=== AT204 资产-收益登账-累计升息 ￥" + amount + " ===");
		// 记账规则：A-个人资产（资金产品） + DR, I-个人收入（资金产品收益） + CR
		AccountEntry interestMonetaryAccountEntry = svs.accounting(monetaryAssetAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit, amount);
		System.out.println(monetaryAssetAccount.getName() + monetaryAssetAccount.getSubject() + " 余额"
				+ monetaryAssetAccount.getBalance());
		repo.saveOneAccount(monetaryAssetAccount);
		repo.saveOneAccountEntry(interestMonetaryAccountEntry);

		AccountEntry monetaryIncomeInteresetAccountEntry = svs.accounting(monetaryIncomeAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorCredit, amount);
		System.out.println(monetaryIncomeAccount.getName() + monetaryIncomeAccount.getSubject() + " 余额"
				+ monetaryIncomeAccount.getBalance());
		repo.saveOneAccount(monetaryIncomeAccount);
		repo.saveOneAccountEntry(monetaryIncomeInteresetAccountEntry);
	}

	/** 资金-付款 */
	private static void at301(BigDecimal amount) throws Exception {
		System.out.println("=== AT301 资金-付款 ￥" + amount + " ===");
		// 记账规则：A-个人资产（底仓账户） - CR, A-个人资产（在途资金） + DR
		AccountEntry assetPayAccountEntry = svs.accounting(assetAccount, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorCredit, amount);
		System.out.println(assetAccount.getName() + assetAccount.getSubject() + " 余额" + assetAccount.getBalance());
		repo.saveOneAccount(assetAccount);
		repo.saveOneAccountEntry(assetPayAccountEntry);

		AccountEntry assetTransitAccountEntry = svs.accounting(transitAsset, clientId,
				AccountAndFundConstants.AccountEntryDebitCreditIndicatorDebit, amount);
		System.out.println(transitAsset.getName() + transitAsset.getSubject() + " 余额" + transitAsset.getBalance());
		repo.saveOneAccount(transitAsset);
		repo.saveOneAccountEntry(assetTransitAccountEntry);
	}

	/** Account: 个人资产（底仓账户） */
	private static AssetAccount createAssetAccount() {
		AssetAccount ret = new AssetAccount();
		ret.setClientId(clientId);
		ret.setName("个人资产（底仓账户）");
		ret.setOpeningDate(new Date());
		ret.setBalance(BigDecimal.ZERO); // 初始金额0

		repo.saveOneAccount(ret);
		return ret;
	}

	/** Account: 个人权益（银行卡现金） */
	private static EquityAccount createEquityAccount() {
		EquityAccount ret = new EquityAccount();
		ret.setClientId(clientId);
		ret.setName("个人权益（银行卡现金）");
		ret.setOpeningDate(new Date());
		ret.setBalance(BigDecimal.ZERO); // 初始金额0

		repo.saveOneAccount(ret);
		return ret;
	}

	/** Account: 个人收入（底仓账户收益） */
	private static IncomeAccount createIncomeAccount() {
		IncomeAccount ret = new IncomeAccount();
		ret.setClientId(clientId);
		ret.setName("个人收入（底仓账户收益）");
		ret.setOpeningDate(new Date());
		ret.setBalance(BigDecimal.ZERO); // 初始金额0

		repo.saveOneAccount(ret);
		return ret;
	}

	/** Account: 个人收入（补贴收入） */
	private static IncomeAccount createBonusIncomeAccount() {
		IncomeAccount ret = new IncomeAccount();
		ret.setClientId(clientId);
		ret.setName("个人收入（补贴收入）");
		ret.setOpeningDate(new Date());
		ret.setBalance(BigDecimal.ZERO); // 初始金额0

		repo.saveOneAccount(ret);
		return ret;
	}

	/** Account: 个人资产（在途资金） */
	private static AssetAccount createTransitAssetAccount() {
		AssetAccount ret = new AssetAccount();
		ret.setClientId(clientId);
		ret.setName("个人资产（在途资金）");
		ret.setOpeningDate(new Date());
		ret.setBalance(BigDecimal.ZERO); // 初始金额0

		repo.saveOneAccount(ret);
		return ret;
	}

	/** Account: 个人资产（资金产品） */
	private static AssetAccount createMonetaryAssetAccount() {
		AssetAccount ret = new AssetAccount();
		ret.setClientId(clientId);
		ret.setName("个人资产（资金产品）");
		ret.setOpeningDate(new Date());
		ret.setBalance(BigDecimal.ZERO); // 初始金额0

		repo.saveOneAccount(ret);
		return ret;
	}

	/** Account: 个人费用（申购费用） */
	private static CostAccount createCostAccount() {
		CostAccount ret = new CostAccount();
		ret.setClientId(clientId);
		ret.setName("个人费用（申购费用）");
		ret.setOpeningDate(new Date());
		ret.setBalance(BigDecimal.ZERO); // 初始金额0

		repo.saveOneAccount(ret);
		return ret;
	}

	/** Account: 个人资产（资金产品收益） */
	private static AssetAccount createMonetaryInterestAssetAccount() {
		AssetAccount ret = new AssetAccount();
		ret.setClientId(clientId);
		ret.setName("个人资产（资金产品收益）");
		ret.setOpeningDate(new Date());
		ret.setBalance(BigDecimal.ZERO); // 初始金额0

		repo.saveOneAccount(ret);
		return ret;
	}

	/** Account: 个人收入（资金产品收益） */
	private static IncomeAccount createMonetaryIncomeAccount() {
		IncomeAccount ret = new IncomeAccount();
		ret.setClientId(clientId);
		ret.setName("个人收入（资金产品收益）");
		ret.setOpeningDate(new Date());
		ret.setBalance(BigDecimal.ZERO); // 初始金额0

		repo.saveOneAccount(ret);
		return ret;
	}
}
