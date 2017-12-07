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
	/** UnderGraduate */
	public static final String PersonEducationLevelUnderGraduate = "UnderGraduate";
	/** PostGraduate */
	public static final String PersonEducationLevelPostGraduate = "PostGraduate";

	// === Person employmentStatus enum ===
	/** Employee */
	public static final String PersonEmploymentStatusEmployee = "Employee";

	// === Person maritalStatus enum ===
	/** Married */
	public static final String PersonMaritalStatusMarried = "Married";
	/** Unmarried */
	public static final String PersonMaritalStatusUnmarried = "Unmarried";
	/** Unknown */
	public static final String PersonMaritalStatusUnknown = "Unknown";

	// === PartyRole status enum ===
	/** Active */
	public static final String PartyRoleStatusActive = "Active";
	/** Suspended */
	public static final String PartyRoleStatusSuspended = "Suspended";
	/** Terminated */
	public static final String PartyRoleStatusTerminated = "Terminated";

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
}
