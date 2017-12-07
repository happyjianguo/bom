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
		// 投保人、被保险人PersonID
		Long personPolicyholderId = createPersonPolicyholder(orderId).getId();
		Long personInsuredId = createPersonInsured(orderId).getId();

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

		// 投保人关联PartyName
		Long personPartyNameId = createPersonPartyName().getId();
		Person personPolicyholder = repo.findOnePerson(personPolicyholderId);
		personPolicyholder.maintainPartyName(personPartyNameId);
		personPolicyholder.setPrimePartyRoleId(partyRolePolicyholderId);
		repo.saveOnePerson(personPolicyholder);
	}

	public static IPartyRepository repo = new DemoPartyRepository();
	public static Long id = 1L;

	/** 智能终端VirtualParty */
	public static VirtualParty createVirtualParty(Long orderId) {
		VirtualParty ret = new VirtualParty();
		ret.setId(id++);
		ret.setSerialNo(UUID.randomUUID().toString());
		// 业务订单号
		ret.setOrderId(orderId);

		repo.saveOneVirtualParty(ret);
		return ret;
	}

	/** VirtualParty PartyName */
	public static PartyName createVirtualPartyPartyName() {
		PartyName ret = new PartyName();
		ret.setId(id++);
		ret.setFullName("智能终端-投保向导系统");
		ret.setShortName("投保向导系统");
		ret.setNickName("智能终端");
		Date now = new Date();
		ret.setStartDate(now);
		ret.setEndDate(DateUtils.addYears(now, 20));

		repo.saveOnePartyName(ret);
		return ret;
	}

	/** 投保人Person */
	public static Person createPersonPolicyholder(Long orderId) {
		Person ret = new Person();
		ret.setId(id++);
		ret.setName("李四");
		ret.setIdType(PartyConstants.PersonIdTypeID);
		ret.setIdNo("321081198001295243");
		ret.setMobile("13333333333");
		// 业务订单号
		ret.setOrderId(orderId);

		repo.saveOnePerson(ret);
		return ret;
	}

	/** 被保险人Person */
	public static Person createPersonInsured(Long orderId) {
		Person ret = new Person();
		ret.setId(id++);
		ret.setName("张三");
		ret.setIdType(PartyConstants.PersonIdTypeID);
		ret.setIdNo("23090419951228144X");
		ret.setMobile("18888888888");
		// 业务订单号
		ret.setOrderId(orderId);

		repo.saveOnePerson(ret);
		return ret;
	}

	/** PartyRoleInAgreement */
	public static PartyRole createPartyRoleInAgreement(Long orderId, Long rolePlayerId, String code) {
		PartyRoleInAgreement ret = new PartyRoleInAgreement();
		ret.setId(id++);
		ret.setStatus(PartyConstants.PartyRoleStatusActive);
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
	public static PartyName createPersonPartyName() {
		PartyName ret = new PartyName();
		ret.setId(id++);
		ret.setFullName("李四");
		ret.setShortName("李");
		ret.setNickName("寻找小小");
		Date now = new Date();
		ret.setStartDate(now);
		ret.setEndDate(DateUtils.addYears(now, 20));

		repo.saveOnePartyName(ret);
		return ret;
	}
}
