package jie.iaa.bom.Party;

public abstract class Party extends RolePlayer {
	protected Long parentId; // reports to(Party)
	protected Long primePartyRoleId; // 主要的PartyRole ID

	/**
	 * 维护自身关联关系reporting chain
	 * 
	 * @param parentId
	 *            reports to(Party)
	 */
	public void maintainReportingChain(Long parentId) {
		this.parentId = parentId;
	}

	public Long getParentId() {
		return parentId;
	}

	@Deprecated
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getPrimePartyRoleId() {
		return primePartyRoleId;
	}

	public void setPrimePartyRoleId(Long primePartyRoleId) {
		this.primePartyRoleId = primePartyRoleId;
	}
}
