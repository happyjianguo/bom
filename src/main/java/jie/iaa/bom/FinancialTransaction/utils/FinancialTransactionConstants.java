package jie.iaa.bom.FinancialTransaction.utils;

public class FinancialTransactionConstants {
	// === FinancialTransaction status enum ===
	/** Posted */
	public static final String FinancialTransactionStatusPosted = "Posted";
	/** Running */
	public static final String FinancialTransactionStatusRunning = "Running";
	/** Failed */
	public static final String FinancialTransactionStatusFailed = "Failed";
	/** Completed */
	public static final String FinancialTransactionStatusCompleted = "Completed";
	/** Terminated */
	public static final String FinancialTransactionStatusTerminated = "Terminated";

	// === FinancialTransaction paymentMethod enum ===
	/** EFT电子资金转账 */
	public static final String FinancialTransactionPaymentMethodEFT = "EFT";
	/** AliPay支付宝 */
	public static final String FinancialTransactionPaymentMethodAliPay = "AliPay";
	/** WechatPay微信支付 */
	public static final String FinancialTransactionPaymentMethodWechatPay = "WechatPay";

	// === PaymentDue state enum ===
	/** Due */
	public static final String PaymentDueStateDue = "Due";
	/** PartiallySettled */
	public static final String PaymentDueStatePartiallySettled = "PartiallySettled";
	/** FullySettled */
	public static final String PaymentDueStateFullySettled = "FullySettled";
	/** WrittenOff */
	public static final String PaymentDueStateWrittenOff = "WrittenOff";

	// === PaymentDueSettlement type enum ===
	/** Due */
	public static final String PaymentDueSettlementTypeDue = "Due";
	/** Paid */
	public static final String PaymentDueSettlementTypePaid = "Paid";
}
