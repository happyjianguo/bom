package jie.iaa.bom.ProductAndAgreement;

import java.util.Date;

import jie.iaa.bom.ProductAndAgreement.utils.ProductAndAgreementConstants;

public class FinancialServicesRequest {
	private Date requestDate; // 请求时间
	private Date requestedDate; // 请求结果的生效时间
	private String requestReason;
	private String valid = ProductAndAgreementConstants.FinancialServicesRequestValid; // 请求有效性
	private Long financialServicesAgreementId; // modifies.(FinancialServicesAgreement)

	/**
	 * 维护FinancialServicesAgreement和FinancialServicesRequest的关联关系agreement
	 * modification
	 * 
	 * @param financialServicesAgreementId
	 *            modifies.(FinancialServicesAgreement)
	 */
	public void maintainAgreementModification(Long financialServicesAgreementId) {
		this.financialServicesAgreementId = financialServicesAgreementId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getRequestReason() {
		return requestReason;
	}

	public void setRequestReason(String requestReason) {
		this.requestReason = requestReason;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public Long getFinancialServicesAgreementId() {
		return financialServicesAgreementId;
	}
}
