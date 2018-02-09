package jie.iaa.bom.ProductAndAgreement;

import java.util.Date;

public class Agreement {
	private Long id;
	protected String status; // 合同在生命周期模型的状况。Agreement status enum
	protected Date statusDate; // 最新status开始生效的时间
	protected String statusReason;
	protected Date plannedEndDate; // 计划结束时间
	protected String inceptionDate; // 合同首次启用的时间

	/**
	 * 执行规则
	 */
	public void evaluateRule() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getPlannedEndDate() {
		return plannedEndDate;
	}

	public void setPlannedEndDate(Date plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

	public String getInceptionDate() {
		return inceptionDate;
	}

	public void setInceptionDate(String inceptionDate) {
		this.inceptionDate = inceptionDate;
	}
}