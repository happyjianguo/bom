package jie.iaa.bom.Party;

import java.util.Date;

import jie.iaa.bom.Party.utils.PartyConstants;

public class Person extends Party {
	private Long id;
	// 基本信息
	private String idType = PartyConstants.PersonIdTypeID; // 证件类型
	private String idNo; // 证件号码
	private String mobile; // 手机号码
	private Date birthDate; // 出生日期
	private Date deathDate; // 死亡日期
	private String gender = PartyConstants.PersonGenderUnknown; // 性别
	// 教育背景
	private String educationLevel = PartyConstants.PersonEducationLevelNone; // 教育水平
	// 职业信息
	private Long employerId; // is employee of employer(Party)
	private String employmentStatus = PartyConstants.PersonEmploymentStatusContractual; // 雇佣状况
	private String previousEmployer; // 之前雇主
	private String currentEmployer; // 当前雇主
	// 婚姻信息
	private String maritalStatus = PartyConstants.PersonMaritalStatusUnknown; // 婚姻状况
	private String maritalStatusDate; // 婚姻状况时间

	/**
	 * 维护Party和Person的关联关系empoyment
	 * 
	 * @param employerId
	 *            is employee of employer(Party)
	 */
	public void maintainEmployment(Long employerId) {
		this.employerId = employerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public Long getEmployerId() {
		return employerId;
	}

	@Deprecated
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getPreviousEmployer() {
		return previousEmployer;
	}

	public void setPreviousEmployer(String previousEmployer) {
		this.previousEmployer = previousEmployer;
	}

	public String getCurrentEmployer() {
		return currentEmployer;
	}

	public void setCurrentEmployer(String currentEmployer) {
		this.currentEmployer = currentEmployer;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMaritalStatusDate() {
		return maritalStatusDate;
	}

	public void setMaritalStatusDate(String maritalStatusDate) {
		this.maritalStatusDate = maritalStatusDate;
	}
}
