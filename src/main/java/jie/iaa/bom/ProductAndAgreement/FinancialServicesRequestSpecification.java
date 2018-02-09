package jie.iaa.bom.ProductAndAgreement;

import jie.iaa.bom.ProductAndAgreement.utils.ProductAndAgreementConstants;

public class FinancialServicesRequestSpecification extends Specification {
	private String frequency = ProductAndAgreementConstants.FinancialServicesRequestSpecificationFrequency;
	private Long maximumNumberOfRequests; // 可执行FinancialServicesRequest的最大次数

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Long getMaximumNumberOfRequests() {
		return maximumNumberOfRequests;
	}

	public void setMaximumNumberOfRequests(Long maximumNumberOfRequests) {
		this.maximumNumberOfRequests = maximumNumberOfRequests;
	}
}
