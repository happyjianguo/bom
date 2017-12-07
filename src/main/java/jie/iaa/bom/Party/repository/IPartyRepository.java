package jie.iaa.bom.Party.repository;

import jie.iaa.bom.Party.Organisation;
import jie.iaa.bom.Party.PartyName;
import jie.iaa.bom.Party.PartyRole;
import jie.iaa.bom.Party.Person;
import jie.iaa.bom.Party.VirtualParty;

public interface IPartyRepository {
	void saveOnePerson(Person lhs);

	void saveOneOrganisation(Organisation lhs);

	void saveOnePartyRole(PartyRole lhs);

	void saveOneVirtualParty(VirtualParty lhs);

	void saveOnePartyName(PartyName lhs);

	Person findOnePerson(Long id);

	Organisation findOneOrganisation(Long id);

	PartyRole findOnePartyRole(Long id);

	VirtualParty findOneVirtualParty(Long id);

	PartyName findOnePartyName(Long id);
}
