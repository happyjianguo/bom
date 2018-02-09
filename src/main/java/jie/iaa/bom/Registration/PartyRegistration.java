package jie.iaa.bom.Registration;

public class PartyRegistration extends Registration {
	private Long partyNameId;
	private String type; // 证件类型
	private String number; // 证件号码
	private Long effectiveDate; // 证件有效期限
	private Long expireDate;
	private String reserved;

	/**
	 * 维护PartyRegistration和PartyName的关联关系party name registration
	 * 
	 * @param partyNameId
	 *            registers(PartyName)
	 */
	public void maintainPartyNameRegistration(Long partyNameId) {
		this.partyNameId = partyNameId;
	}

	public Long getPartyNameId() {
		return partyNameId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Long effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Long getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Long expireDate) {
		this.expireDate = expireDate;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
}
