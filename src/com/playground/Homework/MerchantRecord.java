package com.playground.Homework;

/**
 * This class holds information about a merchant record. It includes information
 * like the Merchant Name, Merchant ID, Phone Number, and Contact Name.
 * <p>
 * It represents a merchant record in a file.
 * The file contains each merchant record on a separate line. Each record in the
 * file is represented as comma-separated values in the following manner:
 * <merchant name>,<merchant ID>,<phone number>,<merchant contact>
 *
 * @author Ajay Mahendru
 */
public class MerchantRecord {

    /* Stores the name of the merchant */
    private String merchantName;

    /* Stores the id of the merchant */
    private String merchantID;

    /* Stores the phone number of the merchant */
    private String phoneNumber;

    /* Stores the contact name of the merchant */
    private String merchantContact;

    // Contructor to build a merchant.
    public MerchantRecord(String merchantName, String merchantID, String phoneNumber, String merchantContact) {

        this.merchantName = merchantName;
        this.merchantID = merchantID;
        this.phoneNumber = phoneNumber;
        this.merchantContact = merchantContact;
    }

    /*
     * @return  Returns the merchant contact name.
     */
    public String getMerchantContact() {
        return merchantContact;
    }

    /*
     * @param merchantContactName - Sets the merchant contact name.
     */
    public void setMerchantContact(String merchantContact) {
        this.merchantContact = merchantContact;
    }

    /*
     * @return Returns the merhchant id.
     */
    public String getMerchantID() {
        return merchantID;
    }

    /*
     * @param merchantID - Sets the merchantID.
     */
    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    /*
     * @return Returns the merchant name.
     */
    public String getMerchantName() {
        return merchantName;
    }

    /*
     * @param merchantName - Sets the merchant name.
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /*
     * @return - Returns the phone number for the merchant.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /*
     * @param phoneNumber - Sets the phone number for the merchant.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
