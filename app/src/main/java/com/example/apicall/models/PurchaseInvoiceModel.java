package com.example.apicall.models;

import java.util.Date;

public class PurchaseInvoiceModel {
    private long purchaseInvoice_Id;
    private String pI_Code;
    private String company;
    private Date pI_Date;
    private Date dueDate;
    private long supplierId;
    private String supplierName;
    private boolean status;
    private boolean isSent;

    // Getters and Setters
    public long getPurchaseInvoice_Id() {
        return purchaseInvoice_Id;
    }

    public void setPurchaseInvoice_Id(long purchaseInvoice_Id) {
        this.purchaseInvoice_Id = purchaseInvoice_Id;
    }

    public String getpI_Code() {
        return pI_Code;
    }

    public void setpI_Code(String pI_Code) {
        this.pI_Code = pI_Code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getpI_Date() {
        return pI_Date;
    }

    public void setpI_Date(Date pI_Date) {
        this.pI_Date = pI_Date;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getisSent() {
        return isSent;
    }

    public void setisSent(boolean sent) {
        isSent = sent;
    }

    @Override
    public String toString() {
        return "PurchaseInvoiceModel{" +
                "purchaseInvoice_Id=" + purchaseInvoice_Id +
                ", pI_Code='" + pI_Code + '\'' +
                ", company='" + company + '\'' +
                ", pI_Date=" + pI_Date +
                ", dueDate=" + dueDate +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", status=" + status +
                ", isSent=" + isSent +
                '}';
    }
}

