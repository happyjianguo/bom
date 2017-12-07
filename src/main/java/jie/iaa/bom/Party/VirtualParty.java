package jie.iaa.bom.Party;

public class VirtualParty extends RolePlayer {
	private Long id;
	private String serialNo; // 唯一序列号

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
}
