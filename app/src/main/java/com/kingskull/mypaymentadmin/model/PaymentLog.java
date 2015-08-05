package com.kingskull.mypaymentadmin.model;

import android.graphics.drawable.Drawable;

import java.util.Date;

/**
 * Created by Usuario on 03/08/2015.
 */
public class PaymentLog {

    private Drawable icon;
    private double original_amount;
    private double transaction;
    private String description;
    private Date date;
    private long id;

    private boolean deposit_transaction;

    public PaymentLog(Drawable icon, double original_amount, double transaction, String description, long id, boolean deposit_transaction, Date date) {
        this.icon = icon;
        this.original_amount = original_amount;
        this.transaction = transaction;
        this.description = description;
        this.id = id;
        this.deposit_transaction = deposit_transaction;
        this.date = date;
    }

    public PaymentLog(Drawable icon, double original_amount, double transaction, String description, Date date) {
        this.icon = icon;
        this.original_amount = original_amount;
        this.transaction = transaction;
        this.description = description;
        this.date = date;

        this.id = -1;

        if (transaction<0) this.deposit_transaction = false;
        else this.deposit_transaction = true;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public double getOriginal_amount() {
        return original_amount;
    }

    public void setOriginal_amount(double original_amount) {
        this.original_amount = original_amount;
    }

    public double getTransaction() {
        return transaction;
    }

    public void setTransaction(double transaction) {
        this.transaction = transaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeposiTransaction() {
        return deposit_transaction;
    }

    public void setDepositTransaction(boolean up) {
        this.deposit_transaction = up;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
