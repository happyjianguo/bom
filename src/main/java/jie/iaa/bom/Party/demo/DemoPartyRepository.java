package jie.iaa.bom.Party.demo;

import java.util.HashMap;
import java.util.Map;

import jie.iaa.bom.Party.Organisation;
import jie.iaa.bom.Party.PartyName;
import jie.iaa.bom.Party.PartyRole;
import jie.iaa.bom.Party.Person;
import jie.iaa.bom.Party.VirtualParty;
import jie.iaa.bom.Party.repository.IPartyRepository;

public class DemoPartyRepository implements IPartyRepository {
	Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public void saveOnePerson(Person lhs) {
		map.put("Person" + lhs.getId(), lhs);
	}

	@Override
	public void saveOneOrganisation(Organisation lhs) {
		map.put("Organisation" + lhs.getId(), lhs);
	}

	@Override
	public void saveOnePartyRole(PartyRole lhs) {
		map.put("PartyRole" + lhs.getId(), lhs);
	}

	@Override
	public void saveOneVirtualParty(VirtualParty lhs) {
		map.put("VirtualParty" + lhs.getId(), lhs);
	}

	@Override
	public void saveOnePartyName(PartyName lhs) {
		map.put("PartyName" + lhs.getId(), lhs);
	}

	@Override
	public Person findOnePerson(Long id) {
		return (Person) map.get("Person" + id);
	}

	@Override
	public Organisation findOneOrganisation(Long id) {
		return (Organisation) map.get("Organisation" + id);
	}

	@Override
	public PartyRole findOnePartyRole(Long id) {
		return (PartyRole) map.get("PartyRole" + id);
	}

	@Override
	public VirtualParty findOneVirtualParty(Long id) {
		return (VirtualParty) map.get("VirtualParty" + id);
	}

	@Override
	public PartyName findOnePartyName(Long id) {
		return (PartyName) map.get("PartyName" + id);
	}
}
