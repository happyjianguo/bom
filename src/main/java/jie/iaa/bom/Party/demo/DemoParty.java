package jie.iaa.bom.Party.demo;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.time.DateUtils;

import jie.iaa.bom.Party.utils.PartyConstants;
import jie.iaa.bom.Party.PartyName;
import jie.iaa.bom.Party.PartyRole;
import jie.iaa.bom.Party.PartyRoleInAgreement;
import jie.iaa.bom.Party.Person;
import jie.iaa.bom.Party.VirtualParty;
import jie.iaa.bom.Party.repository.IPartyRepository;

public class DemoParty {
	public static void main(String[] args) {
		// 业务订单号
		Long orderId = 10086L;

		// === VirtualParty ===
		// 投保向导系统VirtualPartyId
		Long virtualPartyId = createVirtualParty(orderId).getId();
		VirtualParty virtualParty = repo.findOneVirtualParty(virtualPartyId);
		// 投保向导系统关联PartyName
		Long virtualPartyPartyNameId = createVirtualPartyPartyName().getId();
		virtualParty.maintainPartyName(virtualPartyPartyNameId);
		repo.saveOneVirtualParty(virtualParty);

		// === Party ===
		// 投保人PersonID
		Long personPolicyholderId = createPersonPolicyholder(orderId).getId();
		Person personPolicyholder = repo.findOnePerson(personPolicyholderId);
		// 投保人关联PartyName
		Long personPolicyholderPartyNameId = createPersonPolicyholderPartyName().getId();
		personPolicyholder.maintainPartyName(personPolicyholderPartyNameId);
		repo.saveOnePerson(personPolicyholder);
		// 被保险人PersonID
		Long personInsuredId = createPersonInsured(orderId).getId();
		Person personInsured = repo.findOnePerson(personInsuredId);
		// 被保险人关联PartyName
		Long personInsuredPartyNameId = createPersonInsuredPartyName().getId();
		personInsured.maintainPartyName(personInsuredPartyNameId);
		repo.saveOnePerson(personInsured);

		// === PartyRole ===
		// 投保人、被保险人PartyRoleID
		Long partyRolePolicyholderId = createPartyRoleInAgreement(orderId, personPolicyholderId,
				PartyConstants.PartyRoleInAgreementCodePolicyholder).getId();
		Long partyRoleInsuredId = createPartyRoleInAgreement(orderId, personInsuredId,
				PartyConstants.PartyRoleInAgreementCodeInsured).getId();
		// 投保人、账户持有人、保费付款人三合一
		Long partyRoleAccountHolderId = createPartyRoleInAgreement(orderId, personPolicyholderId,
				PartyConstants.PartyRoleInAgreementCodeAccountHolder).getId();
		Long partyRolePremiumPayerId = createPartyRoleInAgreement(orderId, personPolicyholderId,
				PartyConstants.PartyRoleInAgreementCodePremiumPayer).getId();

		// 投保人、被保险人主要角色
		personPolicyholder.setPrimePartyRoleId(partyRolePolicyholderId);
		repo.saveOnePerson(personPolicyholder);
		personInsured.setPrimePartyRoleId(partyRoleInsuredId);
		repo.saveOnePerson(personInsured);
	}

	private static IPartyRepository repo = new DemoPartyRepository();

	/** 智能终端VirtualParty */
	private static VirtualParty createVirtualParty(Long orderId) {
		VirtualParty ret = new VirtualParty();
		ret.setSerialNo(UUID.randomUUID().toString());
		// 业务订单号
		ret.setOrderId(orderId);

		repo.saveOneVirtualParty(ret);
		return ret;
	}

	/** VirtualParty PartyName */
	private static PartyName createVirtualPartyPartyName() {
		PartyName ret = new PartyName();
		ret.setFullName("智能终端-投保向导系统");
		ret.setShortName("投保向导系统");
		ret.setNickName("智能终端");
		ret.setUsage(PartyConstants.PartyNameUsageTradingName);
		Date now = new Date();
		ret.setStartDate(now);
		ret.setEndDate(DateUtils.addYears(now, 20));

		repo.saveOnePartyName(ret);
		return ret;
	}

	/** 投保人Person */
	private static Person createPersonPolicyholder(Long orderId) {
		Person ret = new Person();
		ret.setIdType(PartyConstants.PersonIdTypeID);
		ret.setIdNo("321081198001295243");
		ret.setMobile("13333333333");
		// 业务订单号
		ret.setOrderId(orderId);

		repo.saveOnePerson(ret);
		return ret;
	}

	/** 被保险人Person */
	private static Person createPersonInsured(Long orderId) {
		Person ret = new Person();
		ret.setIdType(PartyConstants.PersonIdTypeID);
		ret.setIdNo("23090419951228144X");
		ret.setMobile("18888888888");
		// 业务订单号
		ret.setOrderId(orderId);

		repo.saveOnePerson(ret);
		return ret;
	}

	/** PartyRoleInAgreement */
	private static PartyRole createPartyRoleInAgreement(Long orderId, Long rolePlayerId, String code) {
		PartyRoleInAgreement ret = new PartyRoleInAgreement();
		ret.setStatus(PartyConstants.PartyRoleStatusCommenced);
		ret.setStatusDate(new Date());
		ret.setPriorityLevel(PartyConstants.PartyRolePriorityLevelPrimary);
		// PartyRoleInAgreement code enum
		ret.setCode(code);
		// 维护RolePlayer和PartyRole的关联关系role playing
		ret.maintainRolePlaying(rolePlayerId);
		// 业务订单号
		ret.setOrderId(orderId);

		repo.saveOnePartyRole(ret);
		return ret;
	}

	/** Person PartyName */
	private static PartyName createPersonPolicyholderPartyName() {
		PartyName ret = new PartyName();
		ret.setFullName("李xx");
		ret.setNickName("寻找小小");
		ret.setUsage(PartyConstants.PartyNameUsageBirthName);
		Date now = new Date();
		ret.setStartDate(now);
		ret.setEndDate(DateUtils.addYears(now, 20));

		repo.saveOnePartyName(ret);
		return ret;
	}

	private static PartyName createPersonInsuredPartyName() {
		PartyName ret = new PartyName();
		ret.setFullName("朱xx");
		ret.setNickName("小猪猪");
		ret.setUsage(PartyConstants.PartyNameUsageBirthName);
		Date now = new Date();
		ret.setStartDate(now);
		ret.setEndDate(DateUtils.addYears(now, 20));

		repo.saveOnePartyName(ret);
		return ret;
	}
}
