package jie.iaa.bom.Party.utils;

public class PartyConstants {
	// === Person idType enum ===
	/** 身份证ID */
	public static final String PersonIdTypeID = "ID";

	// === Person gender enum ===
	/** Male */
	public static final String PersonGenderMale = "Male";
	/** Female */
	public static final String PersonGenderFemale = "Female";
	/** Unknown */
	public static final String PersonGenderUnknown = "Unknown";

	// === Person educationLevel enum ===
	/** 高中HighSchool */
	public static final String PersonEducationLevelHighSchool = "HighSchool";
	/** 学士Bachelor */
	public static final String PersonEducationLevelBachelor = "Bachelor";
	/** 硕士Master */
	public static final String PersonEducationLevelMaster = "Master";
	/** None */
	public static final String PersonEducationLevelNone = "None";

	// === Person employmentStatus enum ===
	/** 合同聘用Contractual */
	public static final String PersonEmploymentStatusContractual = "Contractual";
	/** 全职FullTime */
	public static final String PersonEmploymentStatusFullTime = "FullTime";
	/** 兼职PartTime */
	public static final String PersonEmploymentStatusPartTime = "PartTime";
	/** 退休Retired */
	public static final String PersonEmploymentStatusRetired = "Retired";

	// === Person maritalStatus enum ===
	/** 已婚Married */
	public static final String PersonMaritalStatusMarried = "Married";
	/** 未婚Unmarried */
	public static final String PersonMaritalStatusUnmarried = "Unmarried";
	/** 离异Divorced */
	public static final String PersonMaritalStatusDivorced = "Divorced";
	/** Unknown */
	public static final String PersonMaritalStatusUnknown = "Unknown";

	// === Organisation type enum ===
	/** 公司Company */
	public static final String OrganisationTypeCompany = "Company";
	/** 分公司Branch */
	public static final String OrganisationTypeBranch = "Branch";
	/** 部门Department */
	public static final String OrganisationTypeDepartment = "Department";
	/** 团队Team */
	public static final String OrganisationTypeTeam = "Team";
	/** 家庭HouseHold */
	public static final String OrganisationTypeHouseHold = "HouseHold";

	// === Organisation status enum ===
	/** Active */
	public static final String OrganisationStatusActive = "Active";
	/** Stopped */
	public static final String OrganisationStatusStopped = "Stopped";

	// === VirtualParty type enum ===
	/** 移动设备MobileDevice */
	public static final String VirtualPartyTypeMobileDevice = "MobileDevice";

	// === PartyRole status enum ===
	/** 开始Commenced */
	public static final String PartyRoleStatusCommenced = "Commenced";
	/** 辞职Resignation */
	public static final String PartyRoleStatusResignation = "Resignation";
	/** 退休Retirement */
	public static final String PartyRoleStatusRetirement = "Retirement";
	/** 暂时分配TemporaryAssignment */
	public static final String PartyRoleStatusTemporaryAssignment = "TemporaryAssignment";

	// === PartyRole priorityLevel enum ===
	/** Primary */
	public static final String PartyRolePriorityLevelPrimary = "Primary";
	/** Secondary */
	public static final String PartyRolePriorityLevelSecondary = "Secondary";

	// === PartyRoleInAgreement code enum ===
	/** Applicant申请人 */
	public static final String PartyRoleInAgreementCodeApplicant = "Applicant";
	/** Policyholder投保人 */
	public static final String PartyRoleInAgreementCodePolicyholder = "Policyholder";
	/** AccountHolder账户持有人 */
	public static final String PartyRoleInAgreementCodeAccountHolder = "AccountHolder";
	/** PremiumPayer保费付款人 */
	public static final String PartyRoleInAgreementCodePremiumPayer = "PremiumPayer";
	/** Insured被保险人 */
	public static final String PartyRoleInAgreementCodeInsured = "Insured";
	/** Beneficiary受益人 */
	public static final String PartyRoleInAgreementCodeBeneficiary = "Beneficiary";
	/** NamedDriver车主 */
	public static final String PartyRoleInAgreementCodeNamedDriver = "NamedDriver";

	// === PartyName usage enum ===
	/** 出生姓名BirthName */
	public static final String PartyNameUsageBirthName = "BirthName";
	/** 商业名称BusinessName */
	public static final String PartyNameUsageBusinessName = "BusinessName";
	/** 公司名称CompanyName */
	public static final String PartyNameUsageCompanyName = "CompanyName";
	/** 正式名称OfficialName */
	public static final String PartyNameUsageOfficialName = "OfficialName";
	/** 商标名称TradingName */
	public static final String PartyNameUsageTradingName = "TradingName";
}
