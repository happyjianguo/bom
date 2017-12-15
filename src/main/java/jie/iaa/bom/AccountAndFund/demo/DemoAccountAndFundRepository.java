package jie.iaa.bom.AccountAndFund.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import jie.iaa.bom.AccountAndFund.Account;
import jie.iaa.bom.AccountAndFund.AccountEntry;
import jie.iaa.bom.AccountAndFund.FinancialAsset;
import jie.iaa.bom.AccountAndFund.repository.IAccountAndFundRepository;

@Component
public class DemoAccountAndFundRepository implements IAccountAndFundRepository {
	private Map<String, Object> map = new HashMap<String, Object>();
	private static Long id = 1L;

	@Override
	public void saveOneAccount(Account lhs) {
		if (lhs.getId() == null)
			lhs.setId(id++);
		map.put("Account" + lhs.getId(), lhs);
	}

	@Override
	public void saveOneAccountEntry(AccountEntry lhs) {
		if (lhs.getId() == null)
			lhs.setId(id++);
		map.put("AccountEntry" + lhs.getId(), lhs);
	}

	@Override
	public void saveOneFinancialAsset(FinancialAsset lhs) {
		if (lhs.getId() == null)
			lhs.setId(id++);
		map.put("FinancialAsset" + lhs.getId(), lhs);
	}

	@Override
	public Account findOneAccount(Long id) {
		return (Account) map.get("Account" + id);
	}

	@Override
	public AccountEntry findOneAccountEntry(Long id) {
		return (AccountEntry) map.get("AccountEntry" + id);
	}

	@Override
	public FinancialAsset findOneFinancialAsset(Long id) {
		return (FinancialAsset) map.get("FinancialAsset" + id);
	}

	@Override
	public List<Account> findAccounts(Long clientId) {
		List<Account> ret = new ArrayList<Account>();
		for (Entry<String, Object> entry : map.entrySet()) {
			Object obj = entry.getValue();
			if (obj instanceof Account) {
				Account account = (Account) obj;
				if (clientId.equals(account.getClientId()))
					ret.add(account);
			}
		}
		return ret;
	}
}
