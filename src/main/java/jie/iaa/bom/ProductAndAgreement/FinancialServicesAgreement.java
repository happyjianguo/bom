package jie.iaa.bom.ProductAndAgreement;

import java.util.Date;

public class FinancialServicesAgreement extends TopLevelAgreement {
	private Date boundDate; // 绑定时间
	private Long financialServicesAgreementId; // pays(FinancialServicesAgreement)
	private Long newBusinessRequestId; // is created by (NewBusinessRequest)

	/**
	 * 维护自身关联关系agreement payment
	 * 
	 * @param financialServicesAgreementId
	 *            pays (FinancialServicesAgreement)
	 */
	public void maintainAgreementPayment(Long financialServicesAgreementId) {
		this.financialServicesAgreementId = financialServicesAgreementId;
	}

	/**
	 * 维护NewBusinessRequest和FinancialServicesAgreement的关联关系agreement creation
	 * 
	 * @param newBusinessRequestId
	 *            is created by (NewBusinessRequest)
	 */
	public void maintainAgreementCreation(Long newBusinessRequestId) {
		this.newBusinessRequestId = newBusinessRequestId;
	}

	public Date getBoundDate() {
		return boundDate;
	}

	public void setBoundDate(Date boundDate) {
		this.boundDate = boundDate;
	}

	public Long getFinancialServicesAgreementId() {
		return financialServicesAgreementId;
	}

	public Long getNewBusinessRequestId() {
		return newBusinessRequestId;
	}
}
