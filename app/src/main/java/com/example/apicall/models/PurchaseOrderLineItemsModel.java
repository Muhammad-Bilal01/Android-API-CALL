package com.example.apicall.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseOrderLineItemsModel {
    private long pO_LineItemID;
    private String pO_LineItemCode;
    private String requiredBy;
    private int quantity;
    private int uomid;
    private double rate;
    private double amount;
    private long pO_ID;

    // Getters and Setters
    public long getPO_LineItemID() {
        return pO_LineItemID;
    }

    public void setPO_LineItemID(long pO_LineItemID) {
        this.pO_LineItemID = pO_LineItemID;
    }

    public String getPO_LineItemCode() {
        return pO_LineItemCode;
    }

    public void setPO_LineItemCode(String pO_LineItemCode) {
        this.pO_LineItemCode = pO_LineItemCode;
    }

    public String getRequiredBy() {
        return requiredBy;
    }

    public void setRequiredBy(String requiredBy) {
        this.requiredBy = requiredBy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUomid() {
        return uomid;
    }

    public void setUomid(int uomid) {
        this.uomid = uomid;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getPO_ID() {
        return pO_ID;
    }

    public void setPO_ID(long pO_ID) {
        this.pO_ID = pO_ID;
    }

    @Override
    public String toString() {
        return "PurchaseOrderLineItemsModel{" +
                "pO_LineItemID=" + pO_LineItemID +
                ", pO_LineItemCode='" + pO_LineItemCode + '\'' +
                ", requiredBy='" + requiredBy + '\'' +
                ", quantity=" + quantity +
                ", uomid=" + uomid +
                ", rate=" + rate +
                ", amount=" + amount +
                ", pO_ID=" + pO_ID +
                '}';
    }
}
