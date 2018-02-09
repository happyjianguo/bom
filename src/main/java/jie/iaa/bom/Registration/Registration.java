package jie.iaa.bom.Registration;

public class Registration {
	private Long id;
	private Long rolePlayerId;
	private Long authorityRolePlayerId;
	private String status;
	private Long statusDate;
	private String statusReason;
	private String description;

	/**
	 * 维护Registration和RolePlayer的关联关系registration authority
	 * 
	 * @param authorityRolePlayerId
	 *            is registered by(RolePlayer)
	 */
	public void maintainRegistrationAuthority(Long authorityRolePlayerId) {
		this.authorityRolePlayerId = authorityRolePlayerId;
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

	public void setRolePlayerId(Long rolePlayerId) {
		this.rolePlayerId = rolePlayerId;
	}

	public Long getAuthorityRolePlayerId() {
		return authorityRolePlayerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Long statusDate) {
		this.statusDate = statusDate;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
