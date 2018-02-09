package jie.iaa.bom.ProductAndAgreement;

public class AgreementComponent extends Agreement {
	private Long agreementId; // is included in (Agreement)

	/**
	 * 维护Agreement和AgreementComponent的关联关系agreement composition
	 * 
	 * @param agreementId
	 *            is included in (Agreement)
	 */
	public void maintainAgreementComposition(Long agreementId) {
		this.agreementId = agreementId;
	}

	public Long getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(Long agreementId) {
		this.agreementId = agreementId;
	}
}