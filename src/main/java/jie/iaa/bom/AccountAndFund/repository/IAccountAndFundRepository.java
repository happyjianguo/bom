package jie.iaa.bom.AccountAndFund.repository;

import java.util.List;

import jie.iaa.bom.AccountAndFund.Account;
import jie.iaa.bom.AccountAndFund.AccountEntry;
import jie.iaa.bom.AccountAndFund.FinancialAsset;

public interface IAccountAndFundRepository {
	void saveOneAccount(Account lhs);

	void saveOneAccountEntry(AccountEntry lhs);

	void saveOneFinancialAsset(FinancialAsset lhs);

	Account findOneAccount(Long id);

	AccountEntry findOneAccountEntry(Long id);

	FinancialAsset findOneFinancialAsset(Long id);

	List<Account> findAccounts(Long clientId);
}
