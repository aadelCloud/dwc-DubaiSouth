package model;

import com.google.gson.annotations.SerializedName;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Abanoub Wagdy on 9/6/2015.
 */
public class FreeZonePayment {

    @JsonProperty("Id")
    @SerializedName("Id")
    String Id;
    @JsonProperty("Name")
    @SerializedName("Name")
    String name;

    String EmployeeName;

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    @JsonProperty("Status__c")
    @SerializedName("Status__c")
    String status;
    @JsonProperty("Payment_Type__c")
    @SerializedName("Payment_Type__c")
    String paymentType;
    @JsonProperty("Narrative__c")
    @SerializedName("Narrative__c")
    String narrative;
    @JsonProperty("Effect_on_Account__c")
    @SerializedName("Effect_on_Account__c")
    String effectOnAccount;
    @JsonProperty("Paypal_Amount__c")
    @SerializedName("Paypal_Amount__c")
    String paypalAmount;
    @JsonProperty("Debit_Amount__c")
    @SerializedName("Debit_Amount__c")
    String debitAmount;
    @JsonProperty("Credit_Amount__c")
    @SerializedName("Credit_Amount__c")
    String creditAmount;
    @JsonProperty("Closing_Balance__C")
    @SerializedName("Closing_Balance__C")
    String closingBalance;
    @JsonProperty("CreatedDate")
    @SerializedName("CreatedDate")
    String createdDate;
    @JsonProperty("Transaction_Date__c")
    @SerializedName("Transaction_Date__c")
    String transactionDate;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getEffectOnAccount() {
        return effectOnAccount;
    }

    public void setEffectOnAccount(String effectOnAccount) {
        this.effectOnAccount = effectOnAccount;
    }

    public String getPaypalAmount() {
        return paypalAmount;
    }

    public void setPaypalAmount(String paypalAmount) {
        this.paypalAmount = paypalAmount;
    }

    public String getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount;
    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(String closingBalance) {
        this.closingBalance = closingBalance;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
