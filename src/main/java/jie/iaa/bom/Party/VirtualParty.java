package jie.iaa.bom.Party;

import jie.iaa.bom.Party.utils.PartyConstants;

public class VirtualParty extends RolePlayer {
	private Long id;
	// sub-type
	private String type = PartyConstants.VirtualPartyTypeMobileDevice;
	private String serialNo; // 序列号。UNIQUE

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
}
