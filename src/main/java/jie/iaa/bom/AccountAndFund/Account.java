package jie.iaa.bom.AccountAndFund;

import java.util.Date;

public class Account {
	protected Long id;
	protected Long parentId; // is consolidated into parent(Account)
	protected Long clientId;
	protected String name; // 建议enum
	protected Date openingDate;
	protected Date closingDate;
	protected String description;

	/**
	 * 维护自身关联关系account consolidation
	 * 
	 * @param parentId
	 *            is consolidated into parent(Account)
	 */
	public void maintainAccountConsolidation(Long parentId) {
		this.parentId = parentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
