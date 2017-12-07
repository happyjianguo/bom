package jie.iaa.bom.Party;

import java.util.Date;

public class PartyRole extends RolePlayer {
	private Long id;
	private Long rolePlayerId; // is played by (RolePlayer)
	private String status; // PartyRole status enum
	private Date statusDate;
	private String statusReason;
	private String priorityLevel; // PartyRole priorityLevel enum

	/**
	 * 维护RolePlayer和PartyRole的关联关系role playing
	 * 
	 * @param rolePlayerId
	 *            is played by (RolePlayer)
	 */
	public void maintainRolePlaying(Long rolePlayerId) {
		this.rolePlayerId = rolePlayerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRolePlayerId() {
		return rolePlayerId;
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

	public String getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

}
