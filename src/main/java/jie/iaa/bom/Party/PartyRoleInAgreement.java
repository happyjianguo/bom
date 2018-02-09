package jie.iaa.bom.Party;

public class PartyRoleInAgreement extends PartyRole {
	private String code; // PartyRoleInAgreement code enum
	private Long agreementId;

	/**
	 * 维护Agreement和PartyRoleInAgreement的关联关系
	 * 
	 * @param agreementId
	 */
	public void maintainAgreement(Long agreementId) {
		this.agreementId = agreementId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getAgreementId() {
		return agreementId;
	}

	@Deprecated
	public void setAgreementId(Long agreementId) {
		this.agreementId = agreementId;
	}
}
