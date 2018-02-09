package jie.iaa.bom.ProductAndAgreement;

import java.util.Date;

import jie.iaa.bom.ProductAndAgreement.utils.ProductAndAgreementConstants;

public class Specification {
	private String name;
	private String description;
	private String status = ProductAndAgreementConstants.SpecificationStatusUnderDevelopment;
	private Date statusDate;
	private String statusReason;
	private Long version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
