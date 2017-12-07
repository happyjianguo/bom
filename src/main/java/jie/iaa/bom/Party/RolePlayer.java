package jie.iaa.bom.Party;

public abstract class RolePlayer {
	protected Long orderId; // 订单号
	protected Long partyNameId; // has for name (PartyName)
	protected String description;

	/**
	 * 维护PartyName和RolePlayer的关联关系role player naming
	 * 
	 * @param partyNameId
	 *            has for name (PartyName)
	 */
	public void maintainPartyName(Long partyNameId) {
		this.partyNameId = partyNameId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getPartyNameId() {
		return partyNameId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
